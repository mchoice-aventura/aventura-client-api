<?php

/**
 * Listen to the AppZone MO Message and reply back
 */
include_once 'AppZoneSender.php';
include_once 'AppZoneReciever.php';
include_once 'log.php';

try{
	$reciever=new AppZoneReciever();
	$rtn="{$reciever->getAddress()} :: {$reciever->getMessage()} :: {$reciever->getCorrelator()}";
	logFile($rtn);
	
	$sender=new AppZoneSender("http://localhost:65182", "PD_ET_e0550", "098f6bcd4621d373cade4e832627b4f6");
	$res=$sender->sms("Thanks", $reciever->getAddress());
	$res=$sender->smsToAll("Hi all, we got a new message");
	logFile($res);	
}
catch(AppZoneException $ex){
	logFile("ERROR: {$ex->getStatusCode()} | {$ex->getStatusMessage()}");
}

