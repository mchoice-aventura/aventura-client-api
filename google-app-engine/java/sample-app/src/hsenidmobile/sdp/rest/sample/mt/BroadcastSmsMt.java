/*
 *   (C) Copyright 2010-2011 hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */

package hsenidmobile.sdp.rest.sample.mt;

import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraMessagingException;
import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraResponse;
import hsenidmobile.sdp.rest.servletbase.MchoiceAventuraSmsSender;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Broadcast given message to all registered users of the application.
 *
 * $LastChangedDate: 2010-05-25 11:44:24 +0530 (Tue, 25 May 2010) $
 * $LastChangedBy: kasunl $ $LastChangedRevision: 61197 $
 */
public class BroadcastSmsMt {

	public static void main(String[] args) {
		try {
			MchoiceAventuraSmsSender sender = new MchoiceAventuraSmsSender(new URL("http://127.0.0.1:65182"), "PD_ET_e0550",
					"098f6bcd4621d373cade4e832627b4f6");

			// send message to a single destination
			String message;
			if (args.length == 1) {
				// Take message from command line
				message = args[0];
			} else {
				// Use default message
				message = "test message";
			}

			System.out.println("Start sending broadcast message[" + message + "]");

			MchoiceAventuraResponse response = sender.broadcastMessage(message);
			if (response.isSuccess()) {
				System.out.println("Message [" + message + "] broadcast successfully.");
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
