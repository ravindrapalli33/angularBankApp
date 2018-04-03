/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.service;

import com.angularjs.bankapp.dao.IUserDao;
import com.angularjs.bankapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ravindra.palli
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        UserBuilder builder = null;
        if (user != null) {

          builder = org.springframework.security.core.userdetails.User.withUsername(username);
          builder.disabled(!user.getIsActive());
          builder.password(user.getPassword());
          String[] authorities = user.getAuthorities()
              .stream().map(a -> a.getAuthority()).toArray(String[]::new);

          builder.authorities(authorities);
        } else {
          throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
