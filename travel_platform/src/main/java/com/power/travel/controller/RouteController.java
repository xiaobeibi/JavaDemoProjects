package com.power.travel.controller;

import com.power.travel.service.RouteService;
import com.power.travel.core.Result;
import com.power.travel.model.TravelRoute;
import com.power.travel.model.UserRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @RequestMapping("/travelRouteListUI")
    public String travelRouteListUI(Model model, @ModelAttribute("searchName") String searchName, @PageableDefault(size = 10) Pageable pageable) {
        Page<TravelRoute> page = routeService.TravelRouteListUI(searchName, pageable);
        List<TravelRoute> top10Route = routeService.findTop10Route();
        model.addAttribute("top10Route", top10Route);
        model.addAttribute("page", page);
        return "route/travelRoute";
    }

    @RequestMapping("/travelRouteDetailsUI")
    public String travelRouteDetailsUI(Model model, HttpServletRequest request, @RequestParam(name = "id") String id) {
        TravelRoute travelRoute = routeService.findTravelRouteById(id);
        //如果用户显示已经关注,就是查看关注列表
        Boolean flag = routeService.isRoute(request, id);
        List<TravelRoute> top10Route = routeService.findTop10Route();
        model.addAttribute("top10Route", top10Route);
        model.addAttribute("travelRoute", travelRoute);
        model.addAttribute("flag", flag);
        return "route/travelRoute-details";
    }

    @RequestMapping("/routeManageUI")
    public String routeManageUI(Model model, HttpServletRequest request) {
        List<UserRoute> userRouteList = routeService.getTravelRouteByUser(request);
        model.addAttribute("userRouteList", userRouteList);
        return "route/route-user-manage";
    }

    @RequestMapping("/cancelTravelRouteReserve")
    @ResponseBody
    public Result cancelTravelRouteReserve(HttpServletRequest request, String id) {
        return routeService.cancelTravelRouteReserve(request, id);
    }
}
