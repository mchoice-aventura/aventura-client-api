/*
 *   (C) Copyright 2009-2010 hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 *
 */
package hsenidmobile.sdp.rest.sample.mo;

import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraSmsMessage;
import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraSmsMoServlet;

/**
 * Sample code to receive mobile originated message.
 *
 * $LastChangedDate: 2010-05-25 11:44:24 +0530 (Tue, 25 May 2010) $
 * $LastChangedBy: kasunl $
 * $LastChangedRevision: 61197 $
 */

public class SmsMoListener extends MchoiceAventuraSmsMoServlet {

    /**
     * This method will be called every time a Mobile-Originated a messaged is received to your application.
     * Each time this method is called it will be in a new Thread.
     *
     * @param message Content of the received message
     */
    @Override
    protected void onMessage(MchoiceAventuraSmsMessage message) {
        //your logic goes here......

        //example : print the message
        System.out.println("========== Mobile Originated message received ==========");
        System.out.println("Address = " + message.getAddress());
        System.out.println("Message = " + message.getMessage());
        System.out.println("Correlator = " + message.getCorrelator());
        System.out.println("Version = " + message.getVersion());
        System.out.println("========================================================");
    }
}
