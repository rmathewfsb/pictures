package edu.codeanywhere.j4.pictures.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.codeanywhere.j4.pictures.persistence.MongoUserDetails;
import edu.codeanywhere.j4.pictures.persistence.MongoUserDetailsRepository;
import edu.codeanywhere.j4.pictures.persistence.UserDetailsImpl;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@Service
public class PictureUserDetailService implements UserDetailsService
{

    @Autowired
    MongoUserDetailsRepository userDetailsRepository;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */

    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException
    {
        System.out.println("Enter loadUserByUsername");
        final MongoUserDetails mongoUserDetails = userDetailsRepository.findByUsername(userName);
        System.out.println("Loaded UserDetails.");
        String[] authorities =
        {};
        if (mongoUserDetails.getAuthorities() != null)
        {
            authorities = mongoUserDetails.getAuthorities();
        }
        else
        {
            System.out.println("UserDetails loaded with ZERO authorities.");
        }

        return new UserDetailsImpl(mongoUserDetails.getUsername(), mongoUserDetails.getPassword(), authorities);

    }

    public MongoUserDetails saveUserDetails(final MongoUserDetails userDetails)
    {
        return userDetailsRepository.save(userDetails);
    }

}
