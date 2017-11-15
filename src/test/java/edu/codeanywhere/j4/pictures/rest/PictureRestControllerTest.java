package edu.codeanywhere.j4.pictures.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.codeanywhere.j4.pictures.WebAppSecurityConfig;
import edu.codeanywhere.j4.pictures.persistence.Picture;
import edu.codeanywhere.j4.pictures.service.PictureService;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PictureRestController.class)
public class PictureRestControllerTest
{
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private PictureService pictureService;
    
    @Test
    //@WithMockUser(username = "test", password = "test", roles = "USER")
    public void givenPicture_whenFindPicture_thenReturnJson() throws Exception
    {
        final Picture pic = new Picture();
        pic.setName("jess");
        
        when(pictureService.findPicture("jess")).thenReturn(pic);
        
/*        mvc.perform(get("/pic/jess")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$.name", is(pic.getName())));*/
        
        mvc.perform(get("/pic/jess").header(HttpHeaders.AUTHORIZATION,
            "Basic " + Base64Utils.encodeToString("j4user:jjjj".getBytes()))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$.name", is(pic.getName())));        
        
    }
    
}

