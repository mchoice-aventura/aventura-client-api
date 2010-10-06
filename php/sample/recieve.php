<?php

/**
 * Listen to the AppZone MO Message and reply back
 */
 
//include the api for sending and receiving
include_once '../AppZoneSender.php';
include_once '../AppZoneReciever.php';
include_once 'log.php';

try{
	//create the receiver
	$reciever=new AppZoneReciever();
	//getting the message content
	$rtn="{$reciever->getAddress()} :: {$reciever->getMessage()} :: {$reciever->getCorrelator()}";
	logFile($rtn);
	
	/*
	creating the sender object with 
		server url
		appId
		password
	*/
	$sender=new AppZoneSender("http://localhost:8080/appzone-simulator/simulator", "PD_ET_e0550", "098f6bcd4621d373cade4e832627b4f6");
	
	//sending a one message
	$res=$sender->sms("Thanks", $reciever->getAddress());
	
	//broadcasting a message
	$res=$sender->smsToAll("Hi all, we got a new message");
	logFile($res);	
}
catch(AppZoneException $ex){
	//throws when failed sending or receiving the sms
	logFile("ERROR: {$ex->getStatusCode()} | {$ex->getStatusMessage()}");
}

