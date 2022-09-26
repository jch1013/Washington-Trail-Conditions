package com.WTC.WashingtonTrailConditions.Controllers;

import java.util.List;

import com.WTC.WashingtonTrailConditions.Models.Trail;
import com.WTC.WashingtonTrailConditions.Services.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TrailController {

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


    @RequestMapping(value = "/redirt", method = RequestMethod.GET)
    public ModelAndView method(Trail trail) {
        System.out.println("Clicked on link");
        System.out.println(trail.getLink());
        return new ModelAndView("redirect:" + "http://www.wta.org");
    }

    @RequestMapping ("/redirect")
    public String getWTA(@ModelAttribute Trail trail, Model model, Errors errors) {
        System.out.println("Ran redirect");
        System.out.println(model);
        System.out.println(trail);
        return " ";
    }

}
