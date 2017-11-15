package edu.codeanywhere.j4.pictures.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.codeanywhere.j4.pictures.persistence.MongoUserDetails;
import edu.codeanywhere.j4.pictures.service.PictureUserDetailService;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController
{
    @Autowired
    PictureUserDetailService pictureUserDetailsService;
    
    @RequestMapping(value = "/greet", method =
    { RequestMethod.GET })
    public String welcomeUser()
    {
        return "Welcome!";
    }
    
    @RequestMapping(value = "/signup", method =
    { RequestMethod.POST })
    public String signupUser(@RequestBody final MongoUserDetails userDetails) throws Exception
    {
        if (userDetails == null)
        {
            throw new Exception("Invalid input!");
        }
        MongoUserDetails storedUserDetails = pictureUserDetailsService.saveUserDetails(userDetails);
        return "Welcome! " + userDetails.getUsername();
    }    

    /**
     * This method ___
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
