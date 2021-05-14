package com.power.travel.controller;

import com.power.travel.core.Result;
import com.power.travel.service.ReserveService;
import com.power.travel.model.Attractions;
import com.power.travel.model.Hotel;
import com.power.travel.model.UserAttractions;
import com.power.travel.model.UserHotel;
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
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @RequestMapping("/reserveHotelListUI")
    public String reserveHotelListUI(Model model, @ModelAttribute("searchName") String searchName, @PageableDefault(size = 10) Pageable pageable) {
        Page<Hotel> page = reserveService.reserveHotelListUI(searchName, pageable);
        List<Hotel> top10Hotel = reserveService.getTop10Hotel();
        List<Attractions> top10Attractions = reserveService.getTop10Attractions();
        model.addAttribute("top10Hotel", top10Hotel);
        model.addAttribute("top10Attractions", top10Attractions);
        model.addAttribute("page", page);
        return "reserve/reserve-hotel";
    }

    @RequestMapping("/hotelDetailsUI")
    public String hotelDetailsUI(Model model, HttpServletRequest request, @RequestParam(name = "id") String id) {
        Hotel hotel = reserveService.findHotelById(id);
        //如果用户显示已经预约,就是查看预约列表
        Boolean flag = reserveService.isReserveHotel(request, id);
        List<Hotel> top10Hotel = reserveService.getTop10Hotel();
        List<Attractions> top10Attractions = reserveService.getTop10Attractions();
        model.addAttribute("top10Hotel", top10Hotel);
        model.addAttribute("top10Attractions", top10Attractions);
        model.addAttribute("hotel", hotel);
        model.addAttribute("flag", flag);
        return "reserve/reserve-hotel-details";
    }

    @RequestMapping("/reserveManageUI")
    public String reserveManageUI(Model model, HttpServletRequest request) {
        List<UserHotel> userHotelList = reserveService.getReserveHotelByUser(request);
        List<UserAttractions> userAttractionsList = reserveService.getReserveAttractionsByUser(request);
        model.addAttribute("userHotelList", userHotelList);
        model.addAttribute("userAttractionsList",userAttractionsList);
        return "reserve/reserve-user-manage";
    }

    @RequestMapping("/cancelReserve")
    @ResponseBody
    public Result cancelReserve(HttpServletRequest request, String id) {
        return reserveService.cancelReserve(request,id);
    }

    @RequestMapping("/reserveAttractionsListUI")
    public String reserveAttractionsListUI(Model model, @ModelAttribute("searchName") String searchName, @PageableDefault(size = 10) Pageable pageable) {
        Page<Attractions> page = reserveService.reserveAttractionsListUI(searchName,pageable);
        List<Hotel> top10Hotel = reserveService.getTop10Hotel();
        List<Attractions> top10Attractions = reserveService.getTop10Attractions();
        model.addAttribute("top10Hotel", top10Hotel);
        model.addAttribute("top10Attractions", top10Attractions);
        model.addAttribute("page", page);
        return "reserve/reserve-attractions";
    }

    @RequestMapping("/attractionsDetailsUI")
    public String attractionsDetailsUI(Model model, HttpServletRequest request, @RequestParam(name = "id") String id) {
        Attractions attractions = reserveService.findAttractionsById(id);
        //如果用户显示已经预约,就是查看预约列表
        Boolean flag = reserveService.isReserveAttractions(request, id);
        List<Hotel> top10Hotel = reserveService.getTop10Hotel();
        List<Attractions> top10Attractions = reserveService.getTop10Attractions();
        model.addAttribute("top10Hotel", top10Hotel);
        model.addAttribute("top10Attractions", top10Attractions);
        model.addAttribute("attractions", attractions);
        model.addAttribute("flag", flag);
        return "reserve/reserve-attractions-details";
    }


    @RequestMapping("/cancelAttractionsReserve")
    @ResponseBody
    public Result cancelAttractionsReserve(HttpServletRequest request,String id) {
        return reserveService.cancelAttractionsReserve(request,id);
    }

}
