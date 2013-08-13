<?php
/* Reference : 
- GCM Architectural Overview
http://developer.android.com/google/gcm/gcm.html
- Getting Started
http://developer.android.com/google/gcm/gs.html
- Register Google API Console 
https://code.google.com/apis/console

    /* 
        Function sendgcm : simple gcm transfer 
        apikey : unique google api key ( from google api console )
        regid : unique device registration id(s) ( min 1 - max 1000)
        msg : message 
        prop : other properties 
    */

    // header variables 
    $msgtype = 'json';
    $apikey = 'YOUR API KEY';

    // primary payload variables 
    $regids = 'YOUR DEVICE REGISTRATION ID';
    $data = '';
    $prop = NULL;
    $msg = 'test message';

    // optional payload variables
    $notification_keys = '';
    $notification_key_name = '';
    $collapse_key = '';
    $delay_while_idle = '';
    $time_to_live = '';
    $restricted_package_name = '';
    $dry_run = '';

/*
    - Payload Example 1 ( JSON Format )
    { "collapse_key": "score_update",
      "time_to_live": 108,
      "delay_while_idle": true,
      "data": {
        "score": "4x8",
        "time": "15:16.2342"
      },
      "registration_ids":["4", "8", "15", "16", "23", "42"]
    }

    - Payload Example 2 ( Text Format ) 
    collapse_key=score_update&time_to_live=108&delay_while_idle=1&data.score=4x8&data.time=15:16.2342&registration_id=42
*/

    // response variables 
    $multicast_id = '';
    $success = '';
    $failure = '';
    $canonical_ids = '';
    $results = '';

    sendgcm($apikey, $msgtype, $regids, $msg, $prop); 

    function sendgcm($apikey, $msgtype='json',  $regids, $msg, $prop=NULL) {
        if ( $msgtype == 'text' ) {
            $contenttype = 'application/x-www-form-urlencoded;charset=UTF-8';
        }else if ( $msgtype == 'json' ) {
            $contenttype = 'application/json';
        }else {
            return '[ERRORNO] Invalid Message Type'; 
        } 

        $headers = array(
            'Content-Type:' . $contenttype,
            'Authorization:key=' . $apikey 
        );

        $payload = array();
        $payload['data'] = array();
        $payload['data']['msg'] = $msg;
        $payload['message'] = $msg;
        $payload['registration_ids'] = array();
        $payload['registration_ids'][0] = $regids;

        $ch = curl_init();

        curl_setopt($ch, CURLOPT_URL, 'https://android.googleapis.com/gcm/send');
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_POSTFIELDS,json_encode($payload));
        $response = curl_exec($ch);
        echo $response . PHP_EOL;
        curl_close($ch);
    }


?>
