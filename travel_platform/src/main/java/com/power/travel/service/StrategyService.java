package com.power.travel.service;

import com.power.travel.core.Result;
import com.power.travel.core.ResultGenerator;
import com.power.travel.core.ServiceException;
import com.power.travel.enums.StatusEnum;
import com.power.travel.model.TravelStrategy;
import com.power.travel.model.User;
import com.power.travel.model.UserStrategy;
import com.power.travel.repository.TravelStrategyRepository;
import com.power.travel.repository.UserRepository;
import com.power.travel.repository.UserStrategyRepository;
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
public class StrategyService {

    @Autowired
    private TravelStrategyRepository travelStrategyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStrategyRepository userStrategyRepository;

    public Page<TravelStrategy> TravelStrategyListUI(String searchName, Pageable pageable) {
        //查询通过后台审核的攻略列表
        Page<TravelStrategy> travelStrategyPage = travelStrategyRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //status状态,查询状态为0,启动的攻略
            predicates.add((cb.equal(root.get("status"), 0)));
            //攻略name模糊查询
            if (!StringUtils.isEmpty(searchName)) {
                predicates.add((cb.like(root.get("title"), "%" + searchName + "%")));
            }
            query.where(predicates.toArray(new Predicate[]{}));
            query.orderBy(cb.desc(root.get("createDate")));
            return null;
        }, pageable);
        return travelStrategyPage;
    }

    public Page<TravelStrategy> PushStrategyListUI(HttpServletRequest request, String searchName, Pageable pageable) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie == null) {
            throw new ServiceException("用户未登录");
        }
        User user = userRepository.findUserByUsername(cookie.getValue());
        //查询通过后台审核的攻略列表
        Page<TravelStrategy> travelStrategyPage = travelStrategyRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //攻略name模糊查询
            predicates.add((cb.equal(root.get("user"), user)));
            //攻略name模糊查询
            if (!StringUtils.isEmpty(searchName)) {
                predicates.add((cb.like(root.get("name"), "%" + searchName + "%")));
            }
            query.where(predicates.toArray(new Predicate[]{}));
            query.orderBy(cb.desc(root.get("createDate")));
            return null;
        }, pageable);
        return travelStrategyPage;
    }

    public TravelStrategy findTravelStrategyById(String id) {
        return travelStrategyRepository.findById(id).orElseThrow(() -> new ServiceException("攻略id错误!"));
    }

    public Boolean isStrategy(HttpServletRequest request, String id) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie != null) {
            User user = userRepository.findUserByUsername(cookie.getValue());
            TravelStrategy travelStrategy1 = findTravelStrategyById(id);
            UserStrategy userStrategy = userStrategyRepository.findUserStrategyByTravelStrategyAndUser(travelStrategy1, user);
            //每个路线只能关注一次
            if (userStrategy != null) {
                return true;
            }
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    public Result cancelTravelStrategyReserve(HttpServletRequest request, String id) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie == null) {
            throw new ServiceException("用户没有登录!");
        }
        TravelStrategy travelStrategy = findTravelStrategyById(id);
        User user = userRepository.findUserByUsername(cookie.getValue());
        UserStrategy userStrategy = userStrategyRepository.findUserStrategyByTravelStrategyAndUser(travelStrategy, user);
        //存在值就是取消预约.不存在值就是预约
        if (userStrategy != null) {
            userStrategyRepository.delete(userStrategy);
        } else {
            UserStrategy newUserStrategy = new UserStrategy();
            newUserStrategy.setId(IdGenerator.id());
            newUserStrategy.setCreateDate(new Date());
            newUserStrategy.setUser(user);
            newUserStrategy.setTravelStrategy(travelStrategy);
            userStrategyRepository.saveAndFlush(newUserStrategy);
        }
        return ResultGenerator.genSuccessResult();
    }

    public List<UserStrategy> getTravelStrategyByUser(HttpServletRequest request) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie == null) {
            throw new ServiceException("未能获得正确的用户名");
        }
        User user = userRepository.findUserByUsername(cookie.getValue());
        return userStrategyRepository.findUserStrategyByUser(user);
    }

    public TravelStrategy getTravelStrategyById(String id) {
        TravelStrategy travelStrategy = travelStrategyRepository.findById(id).orElseThrow(() -> new ServiceException("攻略ID错误"));
        return travelStrategy;
    }

    @Transactional(rollbackFor = Exception.class)
    public Result saveTravelStrategy(HttpServletRequest request, TravelStrategy travelStrategy) {
        Cookie cookie = CookieUitl.get(request, "username");
        if (cookie == null) {
            throw new ServiceException("未能获得正确的用户名");
        }
        User user = userRepository.findUserByUsername(cookie.getValue());

        if (StringUtils.isEmpty(travelStrategy.getId())) {//没有id的情况
            travelStrategy.setId(IdGenerator.id());
            if (travelStrategy.getStatus() == null) {
                //默认为停用
                travelStrategy.setStatus(StatusEnum.DOWM_STATUS.getCode());
                travelStrategy.setCreateDate(new Date());
                travelStrategy.setUser(user);
            }
        } else {
            //有id的情况
            TravelStrategy oldTravelStrategy = getTravelStrategyById(travelStrategy.getId());
            travelStrategy.setStatus(oldTravelStrategy.getStatus());
            travelStrategy.setCreateDate(oldTravelStrategy.getCreateDate());
        }
        travelStrategyRepository.saveAndFlush(travelStrategy);
        return ResultGenerator.genSuccessResult();
    }

    public List<TravelStrategy> findTop10Strategy() {
        PageRequest pageable = PageRequest.of(0, 10);
        //查询启用的景区游玩路线列表
        Page<TravelStrategy> travelStrategyPage = travelStrategyRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //status状态,查询状态为0,启动的路线
            predicates.add((cb.equal(root.get("status"), 0)));
            query.where(predicates.toArray(new Predicate[]{}));
            query.orderBy(cb.desc(root.get("createDate")));
            return null;
        }, pageable);
        return travelStrategyPage.getContent();
    }
}
