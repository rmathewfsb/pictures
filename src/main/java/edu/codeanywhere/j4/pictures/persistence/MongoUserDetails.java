package edu.codeanywhere.j4.pictures.persistence;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * MongoUserDetails.
 *
 * @author rmathew
 */
public class MongoUserDetails
{
    
    @Id
    public String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String[] authorities;
    
    
    public MongoUserDetails()    {

    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */

    public MongoUserDetails(String username, String password, String[] authorities)
    {
        super();
        this.username = username;
        this.password = password;
        this.authorities =  authorities;
    }

    public String[] getAuthorities()
    {
        // TODO Auto-generated method stub
        return this.authorities;
        
    }

    public String getPassword()
    {
        // TODO Auto-generated method stub
        return this.password;
        
    }

    public String getUsername()
    {
        // TODO Auto-generated method stub
        return this.username;
        
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAuthorities(String[] authorities)
    {
        this.authorities = authorities;
    }



}

