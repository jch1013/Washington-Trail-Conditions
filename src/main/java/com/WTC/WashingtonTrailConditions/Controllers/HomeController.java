package com.WTC.WashingtonTrailConditions.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = {"/", "/home"})
    public String homepage() {
        return "homepage";
    }
}
