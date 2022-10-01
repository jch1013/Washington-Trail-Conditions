package com.WTC.WashingtonTrailConditions.Controllers;

import java.util.List;

import com.WTC.WashingtonTrailConditions.DataScrapers.AirQuality;
import com.WTC.WashingtonTrailConditions.Models.Conditions;
import com.WTC.WashingtonTrailConditions.Models.SnowConditions;
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



    // This controller redirects the user to the WTA trail page when the button to view on WTA is clicked
    @RequestMapping ("/redirect")
    public ModelAndView getFromWTA(@ModelAttribute Trail trail, Model model, Errors errors) {
        return new ModelAndView("redirect:" + trail.getLink());
    }

    @RequestMapping("/trail")
    public String getTrail(@ModelAttribute Trail trail, Model model) {
        Trail requestedTrail = service.getByID(trail.getId());
        model.addAttribute("trail", requestedTrail);

        Conditions currentConditions = new Conditions(requestedTrail.getLatitude(), requestedTrail.getLongitude());
        SnowConditions currentSnow = new SnowConditions(requestedTrail.getLatitude(), requestedTrail.getLongitude());


        for (int i = 0; i < 10; i++) {
            System.out.println(currentSnow.getNearbyStations()[i].getStationName());
        }


        model.addAttribute("conditions", currentConditions);
        model.addAttribute("snowConditions", currentSnow);
        return "trailpage";
    }

}
