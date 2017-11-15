package edu.codeanywhere.j4.pictures.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO This class ___
 *
 * @author rmathew
 */
@RestController
@RequestMapping(value = "/anonymous")
public class AnonymousController
{
    @RequestMapping(value = "/heartbeat", method =
    { RequestMethod.GET })
    public boolean heartBeat()
    {
        return true;
    }
}
