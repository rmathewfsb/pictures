package edu.codeanywhere.j4.pictures.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PictureRepositoryTest
{
    
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    PictureRepository pictureRepository;
    
    @Test
    public void testAddPicture()
    {
        final Picture samplePicture = new Picture();
        samplePicture.setDate("10/16/2017");
        samplePicture.setName("Troy");
        samplePicture.setOwner("rmathew");
        samplePicture.setSize(1024L);
        samplePicture.setType("photo");
        
        entityManager.persist(samplePicture);
        entityManager.flush();
        
        final Picture pic = pictureRepository.findPicture("Troy");
        
        assertThat(pic.getName())
        .isEqualTo(samplePicture.getName());
    }

}

