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

#####################################################################################
                      mChoice sdp : REST Sample Application for Google app engine.
#####################################################################################

1.0 Environment variables to set:
================================
ANT                  	- the version 1.7.x
JAVA_HOME               - version jdk1.6.0
JDK_HOME                - JAVA_HOME


1.1 Configure:
================================
1) You can configure the port number and app engine SDK dir location in appengine.properties file.

	eg : appengine.sdk.dir = /home/sdpuser/softwares/appengine-java-sdk-1.3.4/
      	     port = 8282
	


1.2 Build:
================================
1) run "ant runserver" will start the service in the specified port.
