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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Send sms message to given set of msisdn numbers.
 *
 * $LastChangedDate: 2010-06-15 19:45:40 +0530 (Tue, 15 Jun 2010) $
 * $LastChangedBy: jasond $ $LastChangedRevision: 61767 $
 */
public class SendSmsMtForASet {

	public static void main(String[] args) {
		try {
			MchoiceAventuraSmsSender sender = new MchoiceAventuraSmsSender(new URL("http://127.0.0.1:65182"), "PD_ET_e0550",
					"098f6bcd4621d373cade4e832627b4f6");

			// send message to a multiple destination
			String message;
			String[] addresses;
			if (args.length >= 2) {
				// Use message and destination from command line
				message = args[0];
				addresses = new String[args.length - 1];
				for (int i = 1; i < args.length; i++) {
					addresses[i - 1] = args[i];
				}
			} else {
				// Use default message and destinations
				message = "test message";
				addresses = new String[3];
				addresses[0] = "+94969696969";
				addresses[1] = "+94969696968";
				addresses[2] = "+94969696967";
			}

			System.out.println("Start sending sms message[" + message + "] to addresses[" + Arrays.toString(addresses)
					+ "]");

			MchoiceAventuraResponse response = sender.sendMessage(message, addresses);

			if (response.isSuccess()) {
				System.out.println("Message [" + message + "] sent successfully to all addresses.");
			} else {
				System.out.println("Failed to send message due to [" + response.getStatusCode() + "]["
						+ response.getStatusMessage() + "]");
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
