package edu.codeanywhere.j4.pictures;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint
{
    /**
     * This method ___
     * @param request
     * @param response
     * @param authEx
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
      throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("j4 codenywhere edu");
        super.afterPropertiesSet();
    }
}

