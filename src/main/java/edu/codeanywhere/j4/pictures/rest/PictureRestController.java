package edu.codeanywhere.j4.pictures.rest;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.codeanywhere.j4.pictures.persistence.Picture;
import edu.codeanywhere.j4.pictures.service.PictureService;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RestController
@RequestMapping(value = "/pic")
public class PictureRestController
{

    @Autowired
    PictureService pictureService;

    @RequestMapping(value="/{aName}", method={RequestMethod.GET})
    public Picture getNamedPicture(@PathVariable String aName, final HttpServletRequest request)
    {
        
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Principal principal = request.getUserPrincipal();
       
        System.out.println("User in session: " +  principal.getName());
        System.out.println("Users auth type: " +  request.getAuthType());        
        //return pictureService.findPicture(aName);
        return getSamplePicture();
    }

    public Picture getSamplePicture()
    {
        Picture pic = new Picture();
        pic.setName("Roy");
        pic.setOwner("rmathew");
        pic.setType("receipt");
        return pic;
    }

}
