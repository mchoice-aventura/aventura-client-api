<?php

/**
 * @author: Arunoda Susiripala <arunoda.susiripala@gmail.com>
 * @license  GNU Affero General Public License http://www.gnu.org/licenses/ 
 * 
 * contains SMS Sending class for the AppZone
 */

//include_once "log.php";

class AppZoneSender{
	var $server;
	var $username;
	var $password;
	
	public function __construct($server,$username,$password){
		$this->server=$server;
		$this->username=$username;
		$this->password=$password;
	}
	
	
	public function smsToAll($message){
		$postfields="version=1.0&address=list:all_registered&message=".urlencode($message);
		//logFile($postfields);
		return $this->sendRequest($postfields);
	}
	
	/**
	 * Send sms to one or more address
	 * @param $message message
	 * @param $addresses address list
	 * @throws Exception
	 */
	public function sms($message,$addresses){
		if(is_array($addresses)){
			return $this->smsMany($message,$addresses);
		}
		else if(is_string($addresses) && trim($addresses)!=""){
			return $this->smsMany($message,array($addresses));
		}
		else{
			throw new Exception("address should a string or a array of strings");
		}
	}
	
	private function smsMany($message,$addresses){
		$addressList="";
		foreach ($addresses as $address){
			$addressList.="address=tel:" . urlencode($address) . "&";	
		}
		
		$postfields="version=1.0&".$addressList."message=".urlencode($message);
		//logFile($postfields);
		return $this->sendRequest($postfields);
	}
	
	private function sendRequest($postfields){
		
		$ch = curl_init($this->server);
		//curl_setopt($ch, CURLOPT_HEADER, 0);
		curl_setopt($ch, CURLOPT_POST, 1);
		curl_setopt($ch,CURLOPT_HTTPHEADER,array($this->getAuthHeader()));
		curl_setopt($ch, CURLOPT_POSTFIELDS, $postfields);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
		$res = curl_exec($ch);       
		curl_close($ch);
		return $this->handleResponse($res);
	}
	
	private function getAuthHeader(){
		$auth=$this->username . ':' . $this->password;
		$auth=base64_encode($auth);
		return 'Authorization: Basic ' . $auth;
	}
	
	private function handleResponse($resp){
		$respObj=simplexml_load_string($resp);
		
		$retryCodes=array(
			'SBL-SMS-MT-5000','SBL-SMS-MT-5001',
			'SBL-SMS-MT-5004',
		);
		
		if($resp==""){
			throw new AppZoneException
				("Server URL is invalid",'500');
		}else if($respObj->status_code=='SBL-SMS-MT-2000'){
			return true;
		}else{
			throw new AppZoneException
				($respObj->status_message,$respObj->status_code,$respObj);
		}
	}
	
}

class AppZoneException extends Exception{
	var $code;
	var $response;
	var $statusMessage;
	
	public function __construct($message,$code,$response=null){
		parent::__construct($message);
		$this->statusMessage=$message;
		$this->code=$code;
		$this->response=$response;
	}
	
	public function getStatusCode(){
		return $this->code;
	}
	
	public function getStatusMessage(){
		return $this->statusMessage;
	}
	
	public function getRawResponse(){
		return $this->response;
	}
}
