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
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import edu.codeanywhere.j4.pictures.PicturesApplication;
import edu.codeanywhere.j4.pictures.persistence.Picture;
import edu.codeanywhere.j4.pictures.persistence.PictureRepository;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = PicturesApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-integrationtest.properties")
public class PictureRestControllerIntegrationTest
{
    @Autowired
    private MockMvc mvc;
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    TestEntityManager entityManager;
    
    @Test
    public void givenPicture_whenFindPicture_thenStatus200()
      throws Exception {
     
        createTestPicture("Joel");
     
        mvc.perform(get("/api/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[0].name", is("Joel")));
    }

    /**
     * This method ___
     * @param string
     */
    
    private void createTestPicture(String string)
    {
        final Picture samplePicture = new Picture();
        samplePicture.setDate("10/16/2017");
        samplePicture.setName("Joel");
        samplePicture.setOwner("rmathew");
        samplePicture.setSize(1024L);
        samplePicture.setType("photo");
        
        entityManager.persist(samplePicture);
        entityManager.flush();
        
    }

}
