/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.dao;

import com.angularjs.bankapp.model.User;
import java.util.List;

/**
 *
 * @author ravindra.palli
 */
public interface IUserDao {
    User findById(int id);
     
    User findUserByUsername(String username);
     
    void save(User user);
    
    void delete(User user);
     
    void deleteByUsername(String username);
     
    List<User> findAllUsers();
}
