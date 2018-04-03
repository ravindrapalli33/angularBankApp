/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angularjs.bankapp.shared;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ravindra.palli
 */
public class SimpleResponse {
    private String message;

    public SimpleResponse() {
    }

    public SimpleResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseEntity<Map<String, String>> getResponseMessage(String message, HttpStatus status) {
        HashMap<String, String> result = new HashMap<>();
        result.put("message", message);
        return new ResponseEntity<>(result, status);
    }
}

