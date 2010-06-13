<?php

	/**
	 * StandAlone SMS Sending
	 */

	include_once 'AppZoneSender.php';
	
	$sender=new AppZoneSender(
		"http://localhost:65182", 
		"PD_ET_e0550", 
		"098f6bcd4621d373cade4e832627b4f6");
	
	try{
		var_dump( $sender->sms("Message is this", array(78688,'0721683234')));
		echo "<br>";
		var_dump( $sender->smsToAll("Message is this"));
	}
	catch(AppZoneException $ex){
		echo "ERROR::{$ex->getStatusMessage()}";
	}