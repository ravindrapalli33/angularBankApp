/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.controller;

import com.angularjs.bankapp.model.User;
import com.angularjs.bankapp.service.IUserService;
import com.angularjs.bankapp.settings.Constants;
import com.angularjs.bankapp.shared.SimpleResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ravindra.palli
 */
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
     
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @GetMapping(value={"/user"})
    public List<User> getListOfUsers() {
        return userService.findAllUsers();
    }

    @PostMapping(value={"/user"})
    public SimpleResponse saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new SimpleResponse(Constants.VALIDATION_FAILED);
        }
        userService.saveUser(user);
        return new SimpleResponse(Constants.SUCCESS);
    }

    @PutMapping(value={"/user/{id}"})
    public SimpleResponse updateUser(
            @Valid User user,
            BindingResult result,
            @PathVariable int id) {

        if (result.hasErrors()) {
            return new SimpleResponse(Constants.VALIDATION_FAILED);
        } 
        userService.updateUser(user);
        return new SimpleResponse(Constants.SUCCESS);
    }

    @DeleteMapping(value={"/user/{id}"})
    public SimpleResponse deleteUser(@PathVariable int id) {
        userService.delete(id);
        return new SimpleResponse(Constants.SUCCESS);
    }
    
}
