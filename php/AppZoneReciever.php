<?php

/**
 * @author: Arunoda Susiripala <arunoda.susiripala@gmail.com>
 * @license  GNU Affero General Public License http://www.gnu.org/licenses/ 
 * 
 * Decode Response comes to AppZone MO Message
 */


class AppZoneReciever{
	private $address;
	private $message;
	private $correlator;
	
	public function __construct(){
		$this->address=(isset($_POST['address']))?$_POST['address']:null;
		$this->message=(isset($_POST['message']))?$_POST['message']:null;
		$this->correlator=(isset($_POST['correlator']))?$_POST['correlator']:null;
		
		if(!((isset($this->address) && isset($this->message) && isset($this->correlator)))){
			//throw new Exception("{$this->address} :: {$this->message} :: {$this->correlator}");
			throw new Exception("Some of the required parameters are not provided");
		}
	}
	
	public function getAddress(){
		return $this->address;
	}
	
	public function getMessage(){
		return $this->message;
	}
	
	public function getCorrelator(){
		return $this->correlator;
	}	
	
	
}