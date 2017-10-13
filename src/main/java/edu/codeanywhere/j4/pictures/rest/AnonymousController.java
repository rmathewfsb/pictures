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
