package com.fidility.lovechat.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {  //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
              
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
     
                if(msgs[i].getOriginatingAddress().contains(SharedPreference.getData(context, SharedPreference.PHONENUMBER)))
                {
                	if(msgs[i].getMessageBody().toString().equals(SharedPreference.getData(context, SharedPreference.CODE)))
                	{
                		// verified phonenumber
                		 Toast.makeText(context, "Verified", Toast.LENGTH_SHORT).show();
                	}
                }
            }
            
           
        }                         
    }
}
