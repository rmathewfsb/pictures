package edu.codeanywhere.j4.pictures.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
public class UserDetailsImpl implements UserDetails
{

    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;    

    public UserDetailsImpl(String username, String password, String[] grantedAuthorities)
    {
        super();
        this.username = username;
        this.password = password;
        this.grantedAuthorities =  AuthorityUtils.createAuthorityList(grantedAuthorities);
    }

    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        // TODO Auto-generated method stub
        return this.grantedAuthorities;
        
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

    public boolean isAccountNonExpired()
    {
        // TODO Auto-generated method stub
        return true;
        
    }

    public boolean isAccountNonLocked()
    {
        // TODO Auto-generated method stub
        return true;
        
    }

    public boolean isCredentialsNonExpired()
    {
        // TODO Auto-generated method stub
        return true;
        
    }

    public boolean isEnabled()
    {
        // TODO Auto-generated method stub
        return true;
        
    }

}

