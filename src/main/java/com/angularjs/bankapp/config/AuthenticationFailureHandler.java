package com.angularjs.bankapp.config;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    private static final Logger LOGGER
            = Logger.getLogger(AuthenticationFailureHandler.class.getCanonicalName());

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException, ServletException {
        LOGGER.info("on Authentication failure");
        response.setStatus(401);
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().print("{\"message\":\"INVALID\"}");
        response.getWriter().flush();
    }
}
