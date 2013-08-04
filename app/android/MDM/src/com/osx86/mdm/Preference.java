package com.osx86.mdm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

class Preference 
{
	protected SharedPreferences mPref;
	
	protected Preference(Context ctx) 
	{
		mPref = PreferenceManager.getDefaultSharedPreferences(ctx);
	}
	
	protected synchronized boolean setValue(String key, Object value) 
	{
		if ( value == null ) 
		{
			return false;
		}
		
		Editor editor = mPref.edit();

		if ( value instanceof Boolean ) 
		{
			editor.putBoolean(key, (Boolean)value);
		}
		else if ( value instanceof Integer ) 
		{
			editor.putInt(key, (Integer)value);
		}
		else if ( value instanceof Long) 
		{
			editor.putLong(key, (Long)value);
		}
		else if ( value instanceof Float ) 
		{
			editor.putFloat(key, (Float)value);
		}
		else if ( value instanceof String ) 
		{
			editor.putString(key, (String)value);
		}
		else {
			return false;
		}
		
		int retry;
		for ( retry = 0; retry < Constants.MAX_RETRY_PREF_COMMIT && !editor.commit();) {
			retry++;
		}
		
		return retry < Constants.MAX_RETRY_PREF_COMMIT; 
	}
	

	void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) 
	{
		mPref.registerOnSharedPreferenceChangeListener(listener);
	}
	
	void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) 
	{
		mPref.unregisterOnSharedPreferenceChangeListener(listener);
	}

}
