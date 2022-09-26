package com.WTC.WashingtonTrailConditions.Controllers;


import com.WTC.WashingtonTrailConditions.Models.Trail;
import com.WTC.WashingtonTrailConditions.Services.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private TrailService service;
    @RequestMapping(path = {"/","/search"})
    public String home(Trail trail, Model model, String keyword) {
        if (keyword!=null) {
            List<Trail> list = service.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Trail> list = service.getAllTrails();
            model.addAttribute("list", list);}
        return "searchresults";
    }
}
