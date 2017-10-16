/*
 *    Copyright &copy; Flagstar Bank 2017.
 *
 *    Copyright in the application source code, and in the information and
 *    material therein and in their arrangement, is owned by Flagstar Bank, FSB
 *    unless otherwise indicated.
 *
 *    You shall not remove or obscure any copyright, trademark or other notices.
 *    You may not copy, republish, redistribute, transmit, participate in the
 *    transmission of, create derivatives of, alter edit or exploit in any
 *    manner any material including by storage on retrieval systems, without the
 *    express written permission of Flagstar Bank.
 */
package edu.codeanywhere.j4.pictures.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void givenPicture_whenFindPicture_thenReturnJson() throws Exception
    {
        final Picture pic = new Picture();
        pic.setName("Jess");
        
        when(pictureService.findPicture("jess")).thenReturn(pic);
        
        mvc.perform(get("/pic/Jess")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is(pic.getName())));
        
    }
    
}

