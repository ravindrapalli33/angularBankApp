package com.angularjs.bankapp.config;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Component;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger LOGGER
            = Logger.getLogger(CustomLogoutSuccessHandler.class.getCanonicalName());

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                    HttpServletResponse response, Authentication auth)
                    throws IOException, ServletException {
        LOGGER.info("Logout Sucessfull with Principal");

        persistentTokenBasedRememberMeServices.logout(request, response, auth);
        SecurityContextHolder.getContext().setAuthentication(null);

        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().print("{\"message\":\"SUCCESS\"}");
        response.getWriter().flush();
    }
}
