<?php

	/**
	 * StandAlone SMS Sending
	 */

	//include the api for sending
	include_once '../AppZoneSender.php';
	
	/*
	creating the sender object with 
		server url
		appId
		password
	*/
	$sender=new AppZoneSender(
		"http://localhost:8080/appzone-simulator/simulator", 
		"PD_ET_e0550", 
		"098f6bcd4621d373cade4e832627b4f6");
	
	try{
		//sending a one message
		var_dump( $sender->sms("Message is this", array(78688,'0721683234')));
		echo "<br>";
		
		//broadcasting a message
		var_dump( $sender->smsToAll("Message is this"));
	}
	catch(AppZoneException $ex){
		//throws when failed sending or receiving the sms
		echo "ERROR::{$ex->getStatusMessage()}";
	}
