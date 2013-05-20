package com.fidility.lovechat.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
	
	public static String CODE = "CODE";
	public static String PHONENUMBER = "PHONENUMBER";
 
	
	public static void putData(Context ct , String key , String value)
	{
		SharedPreferences myPrefs = ct.getSharedPreferences("myPrefs", 1);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
	}
	
	
	public static String getData(Context ct , String key)
	{
		SharedPreferences myPrefs = ct.getSharedPreferences("myPrefs", 1);
        String prefName = myPrefs.getString(key, "nothing");
        return prefName;
	}
	
	
	
	
	

}
