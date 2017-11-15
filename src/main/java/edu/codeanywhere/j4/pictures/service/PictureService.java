package edu.codeanywhere.j4.pictures.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.codeanywhere.j4.pictures.persistence.Picture;
import edu.codeanywhere.j4.pictures.persistence.PictureRepository;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@Service
public class PictureService
{
    
    @Autowired
    PictureRepository pictureRepository;
    
    public Picture findPicture(final String aName)
    {
        return pictureRepository.findPicture(aName);
    }

    /**
     * This method ___
     * @param string
     */
    
    public Set<Picture> getPicturesByDate(final String date)
    {
        return pictureRepository.getPicturesByDate(date);
        
    }

    /**
     * This method ___
     * @param samplePicture
     * @return
     */
    
    public Picture addPicture(final Picture samplePicture)
    {
        // TODO Auto-generated method stub
        return pictureRepository.save(samplePicture);
        
    }

}

