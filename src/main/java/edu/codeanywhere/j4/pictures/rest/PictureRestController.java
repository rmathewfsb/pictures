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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.codeanywhere.j4.pictures.persistence.Picture;
import edu.codeanywhere.j4.pictures.service.PictureService;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RestController
@RequestMapping(value="/pic")
public class PictureRestController
{
    
    @Autowired
    PictureService pictureService;
    
    @RequestMapping(value="/{aName}", method={RequestMethod.GET})
    public Picture getNamedPicture(@PathVariable String aName)
    {
        return pictureService.findPicture(aName);
    }

}

