package com.power.travel.service;


import com.power.travel.core.Result;
import com.power.travel.core.ResultGenerator;
import com.power.travel.core.ServiceException;
import com.power.travel.model.TravelRoute;
import com.power.travel.model.User;
import com.power.travel.model.UserRoute;
import com.power.travel.repository.TravelRouteRepository;
import com.power.travel.repository.UserRepository;
import com.power.travel.repository.UserRouteRepository;
import com.power.travel.util.CookieUitl;
import com.power.travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RouteService {

    @Autowired
    private TravelRouteRepository travelRouteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRouteRepository userRouteRepository;

    public Page<TravelRoute> TravelRouteListUI(String searchName, Pageable pageable) {
        //查询启用的景区游玩路线列表
        Page<TravelRoute> travelRoutePage = travelRouteRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //status状态,查询状态为0,启动的路线
            predicates.add((cb.equal(root.get("status"), 0)));
            //景区游玩路线name模糊查询
            if (!StringUtils.isEmpty(searchName)) {
                predicates.add((cb.like(root.get("name"), "%" + searchName + "%")));
            }
            query.where(predicates.toArray(new Predicate[]{}));
            query.orderBy(cb.desc(root.get("createDate")));
            return null;
        }, pageable);
        return travelRoutePage;
    }

    public TravelRoute findTravelRouteById(String id) {
        return travelRouteRepository.findById(id).orElseThrow(() -> new ServiceException("路线id错误!"));
    }

    public Boolean isRoute(HttpServletRequest request, String id) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie != null) {
            User user = userRepository.findUserByUsername(cookie.getValue());
            TravelRoute travelRoute = findTravelRouteById(id);
            UserRoute userRoute = userRouteRepository.findUserRouteByTravelRouteAndUser(travelRoute, user);
            //每个路线只能关注一次
            if (userRoute != null) {
                return true;
            }
        }
        return false;
    }

    public List<UserRoute> getTravelRouteByUser(HttpServletRequest request) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie == null) {
            throw new ServiceException("未能获得正确的用户名");
        }
        User user = userRepository.findUserByUsername(cookie.getValue());
        return userRouteRepository.findUserRouteByUser(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public Result cancelTravelRouteReserve(HttpServletRequest request, String id) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie == null) {
            throw new ServiceException("用户没有登录!");
        }
        TravelRoute travelRoute = findTravelRouteById(id);
        User user = userRepository.findUserByUsername(cookie.getValue());
        UserRoute userRoute = userRouteRepository.findUserRouteByTravelRouteAndUser(travelRoute, user);
        //存在值就是取消预约.不存在值就是预约
        if (userRoute != null) {
            userRouteRepository.delete(userRoute);
        } else {
            UserRoute newUserRoute = new UserRoute();
            newUserRoute.setId(IdGenerator.id());
            newUserRoute.setCreateDate(new Date());
            newUserRoute.setUser(user);
            newUserRoute.setTravelRoute(travelRoute);
            userRouteRepository.saveAndFlush(newUserRoute);
        }
        return ResultGenerator.genSuccessResult();
    }

    public List<TravelRoute> findTop10Route() {
        PageRequest pageable = PageRequest.of(0, 10);
        //查询启用的景区游玩路线列表
        Page<TravelRoute> travelRoutePage = travelRouteRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //status状态,查询状态为0,启动的路线
            predicates.add((cb.equal(root.get("status"), 0)));
            query.where(predicates.toArray(new Predicate[]{}));
            query.orderBy(cb.desc(root.get("createDate")));
            return null;
        }, pageable);
        return travelRoutePage.getContent();
    }
}
