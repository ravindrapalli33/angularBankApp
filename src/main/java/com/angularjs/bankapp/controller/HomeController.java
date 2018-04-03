/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.controller;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ravindra.palli
 */
@RestController
public class HomeController {

    private static final Logger LOGGER =
            Logger.getLogger(HomeController.class.getName());
    
    @GetMapping("/home")
    public String defaultRoute() {
        LOGGER.info("Welcome !!!");
        return "Angular Bank App";
    }
}
