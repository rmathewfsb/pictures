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

package edu.codeanywhere.j4.pictures.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import edu.codeanywhere.j4.pictures.persistence.Picture;
import edu.codeanywhere.j4.pictures.persistence.PictureRepository;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RunWith(SpringRunner.class)
public class PictureServiceTestWithMock
{

    @TestConfiguration
    static class PictureServiceTestConfiguration
    {
        @Bean
        public PictureService pictureService()
        {
            return new PictureService();
        }
    }

    @Autowired
    private PictureService pictureService;

    @MockBean
    private PictureRepository pictureRepository;

    @Before
    public void setup()
    {
        Picture pic = new Picture();
        pic.setName("Roy");
        Mockito.when(pictureRepository.findPicture(pic.getName())).thenReturn(pic);
    }

    @Test
    public void testServiceWithMock()
    {

        String name = "Roy";
        final Picture thePic = pictureService.findPicture(name);

        assertThat(thePic.getName()).isEqualTo(name);
    }

}
