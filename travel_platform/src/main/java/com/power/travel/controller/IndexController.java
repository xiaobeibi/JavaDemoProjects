package com.power.travel.controller;

import com.power.travel.model.TravelRoute;
import com.power.travel.service.ReserveService;
import com.power.travel.service.RouteService;
import com.power.travel.service.StrategyService;
import com.power.travel.model.Attractions;
import com.power.travel.model.Hotel;
import com.power.travel.model.TravelStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private StrategyService strategyService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Hotel> top10Hotel = reserveService.getTop10Hotel();
        List<Attractions> top10Attractions = reserveService.getTop10Attractions();
        List<TravelRoute> top10Route = routeService.findTop10Route();
        List<TravelStrategy> top10Strategy = strategyService.findTop10Strategy();
        model.addAttribute("top10Strategy",top10Strategy);
        model.addAttribute("top10Route", top10Route);
        model.addAttribute("top10Hotel", top10Hotel);
        model.addAttribute("top10Attractions", top10Attractions);
        return "index";
    }
}
