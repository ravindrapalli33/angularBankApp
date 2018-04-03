/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.model;

import java.io.Serializable;

/**
 *
 * @author ravindra.palli
 */
public enum AuthorityType implements Serializable {
    
    USER(),
    ADMIN();
     
    private String userType; 

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
