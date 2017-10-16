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

import java.util.Set;

import javax.xml.soap.SAAJMetaFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.codeanywhere.j4.pictures.persistence.Picture;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureServiceTest
{
    @Autowired
    PictureService pictureService;
    
    @Test
    public void testGetPicturesByDate()
    {
        final Set<Picture> pictures = pictureService.getPicturesByDate("10/01/2017");
        Assert.assertNotNull(pictures);
    }
    
    @Test
    public void testAddPicture()
    {
        final Picture samplePicture = new Picture();
        samplePicture.setDate("10/16/2017");
        samplePicture.setName("Detroit");
        samplePicture.setOwner("rmathew");
        samplePicture.setSize(1024L);
        samplePicture.setType("photo");
        Assert.assertNotNull(pictureService.addPicture(samplePicture));
        final Picture pic = pictureService.findPicture("Detroit");
        Assert.assertNotNull(pic);
        System.out.println("Found picture with name = " + pic.getName() + " and Id = " + pic.getId());
    }

}

