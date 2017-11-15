package edu.codeanywhere.j4.pictures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

import edu.codeanywhere.j4.pictures.service.PictureUserDetailService;

/**
 * WebAppSecurityConfig.
 *
 * @author rmathew
 */
@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Value("${sec.authorized.role}")
    private String authorizedRole;

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Autowired
    private PictureUserDetailService pictureUserDetailsService;

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.
        antMatcher("/**").
        authorizeRequests().
        antMatchers("/anonymous/**", "/home/**").
        permitAll().
        anyRequest().
        authenticated().
        and().
        httpBasic().
        authenticationEntryPoint(authEntryPoint).
        and().
        logout().
        permitAll().
        and().
        csrf().
        disable();
    }

    /*
     * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { auth
     * .inMemoryAuthentication() .withUser("j4user").password("jjjj").roles("USER");
     * 
     * }
     */

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(pictureUserDetailsService);
    }

}
