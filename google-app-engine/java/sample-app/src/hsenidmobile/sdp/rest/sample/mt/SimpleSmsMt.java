/*
 *   (C) Copyright 2010-2011 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */

package hsenidmobile.sdp.rest.sample.mt;

import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraMessagingException;
import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraResponse;
import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraSmsSender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.spi.Configurator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Send sms message to single distination.
 *
 * $LastChangedDate: 2010-06-15 19:45:40 +0530 (Tue, 15 Jun 2010) $
 * $LastChangedBy: jasond $ $LastChangedRevision: 61767 $
 */
public class SimpleSmsMt {

	public static void main(String[] args) {
		try {
			// BasicConfigurator.configure();
			MchoiceAventuraSmsSender sender = new MchoiceAventuraSmsSender(new URL("http://127.0.0.1:65182"), "PD_ET_e0550",
					"098f6bcd4621d373cade4e832627b4f6");

			// send message to a single destination
			String message;
			String address;
			if (args.length == 2) {
				// Take message and destination from command line
				message = args[0];
				address = args[1];
			} else {
				// Use default message and destination
				message = "test message";
				address = "+94969696969";
			}

			System.out.println("Start sending sms message[" + message + "] to [" + address + "]");

			MchoiceAventuraResponse response = sender.sendMessage(message, address);
			if (response.isSuccess()) {
				System.out.println("Message [" + message + "] sent successfully to [" + address + "].");
			} else {
				System.out.println("Failed to send message due to [" + response.getStatusCode() + "]["
						+ response.getStatusMessage() + "].");
			}
		} catch (MalformedURLException e) {
			System.out.println("Url format is wrong, check the url again.");
			e.printStackTrace(System.err);
		} catch (MchoiceAventuraMessagingException e) {
			System.out.println("Exception occurred. Something wrong with message or connection ....");
			e.printStackTrace(System.err);
		}
	}
}
