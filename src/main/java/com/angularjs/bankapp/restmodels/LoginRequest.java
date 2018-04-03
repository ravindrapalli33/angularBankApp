package com.angularjs.bankapp.restmodels;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class LoginRequest {
    private String username;
    private String password;
    private String rememberMe;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password, String rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public static LoginRequest getLoginRequest(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader reader = request.getReader();

        while ((line = reader.readLine()) != null){
            sb.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(sb.toString(), LoginRequest.class);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }
}
