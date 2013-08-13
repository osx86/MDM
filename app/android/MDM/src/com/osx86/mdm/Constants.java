package com.osx86.mdm;

import android.util.Log;


public class Constants {
		
	/*
	 *  static variables 
	 */
	// build level 
	public static final int BUILD_LEVEL_RELEASE						= 0x01;
	public static final int BUILD_LEVEL_DEBUG						= 0x02;
			
	// log tags 
	public static final String LOG_TAG								= EnvVar.SOLUTION_NAME;
	 
	public static final int LOG_LEVEL_VERBOSE						= Log.VERBOSE;	
	public static final int LOG_LEVEL_DEBUG							= Log.DEBUG;
	public static final int LOG_LEVEL_INFO							= Log.INFO;
	public static final int LOG_LEVEL_WARN							= Log.WARN;
	public static final int LOG_LEVEL_ERROR							= Log.ERROR;
	public static final int LOG_LEVEL_ASSERT						= Log.ASSERT;

	// gcm values
    public static final long GCM_EXPIRE_TIME_MS 					= 1000 * 3600 * 24 * 7; // 7 days

	
	// default values
	public static final String DEFAULT_STRING_VAL 					= "";
	public static final int DEFAULT_INT_VAL 						= 0;
	public static final int DEFAULT_LONG_VAL 						= 0;
	
	public static final int STAT_DISABLED							= 0;
	public static final int STAT_ENABLED							= 1;
	
	// preference 
	public static final int MAX_RETRY_PREF_COMMIT					= 10;

	// GCM Notification Types 
	public static final String GCM_TITLE							= EnvVar.SOLUTION_NAME + "Notification";
	
	public static final int GCM_SOUND_DEFAULT						= 1;
	public static final int GCM_SOUND_RINGTONE						= 2;
	
	public static final long[] GCM_VIBRATION_PATTERN_ONCE			= {5000};
	public static final long[] GCM_VIBRATION_PATTERN_SHORT			= {500,500,500,500,500,500,500,500,500};
	public static final long[] GCM_VIBRATION_PATTERN_LONG			= {5000,5000,5000,5000,5000,5000,5000,5000,5000};
	
	// Notification.BigPictureStyle, Notification.BigTextStyle, Notification.InboxStyle
	public static final int GCM_STYLE_BIGPICTURE					= 1;
	public static final int GCM_STYLE_BIGTEXT						= 2;
	public static final int GCM_STYLE_INBOX							= 3;
	
	public static final String GCM_EXTRAS_MESSAGE					= "msg";
	public static final String GCM_EXTRAS_PROP						= "prop";
	
	
	
}
