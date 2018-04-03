/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.service;

import com.angularjs.bankapp.model.User;
import java.util.List;

/**
 *
 * @author ravindra.palli
 */
public interface IUserService {

    User findById(int id);
    
    User findUserByUsername(String username);

    List<User> findAllUsers();

    void saveUser(User user);
     
    void updateUser(User user);

    void delete(int id);
     
    void deleteUserByUsername(String username);
}
