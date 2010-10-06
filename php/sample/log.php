<?php
function logFile($rtn){
	$f=fopen("/tmp/bac","a");
	fwrite($f, $rtn . "\n");
	fclose($f);
}