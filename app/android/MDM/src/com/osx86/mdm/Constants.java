package com.osx86.mdm;

import android.app.admin.DevicePolicyManager;
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

	// default values
	public static final String DEFAULT_STRING_VAL 					= "";
	public static final int DEFAULT_INT_VAL 						= 0;
	public static final int DEFAULT_LONG_VAL 						= 0;
	
	public static final int STAT_DISABLED							= 0;
	public static final int STAT_ENABLED							= 1;
	
	public static final boolean TRUE								= true;
	public static final boolean FALSE								= false;
	
	// Time 
	public static final long MS_SECOND								= ( 1000L );
	public static final long MS_MINUTE								= ( Constants.MS_SECOND * 60L );
	public static final long MS_HOUR								= ( Constants.MS_MINUTE * 60L );
	public static final long MS_DAY									= ( Constants.MS_HOUR * 24L );
	public static final long MS_WEEK								= ( Constants.MS_DAY * 7L );

	// gcm values
    public static final long GCM_EXPIRE_TIME_MS 					= 1000 * 3600 * 24 * 7; // 7 days

	
	
	// preference 
	public static final int MAX_RETRY_PREF_COMMIT					= 10;

	// GCM Notification Types 
	public static final String GCM_TITLE							= EnvVar.SOLUTION_NAME + "Notification";
	
	public static final int GCM_SOUND_DEFAULT						= 0x01;
	public static final int GCM_SOUND_RINGTONE						= 0x02;
	
	public static final long[] GCM_VIBRATION_PATTERN_ONCE			= {5000};
	public static final long[] GCM_VIBRATION_PATTERN_SHORT			= {500,500,500,500,500,500,500,500,500};
	public static final long[] GCM_VIBRATION_PATTERN_LONG			= {5000,5000,5000,5000,5000,5000,5000,5000,5000};
	
	public static final int GCM_STYLE_BIGPICTURE					= 0x01;
	public static final int GCM_STYLE_BIGTEXT						= 0x02;
	public static final int GCM_STYLE_INBOX							= 0x03;
	
	public static final String GCM_EXTRAS_MESSAGE					= "msg";
	public static final String GCM_EXTRAS_PROP						= "prop";
	public static final String GCM_EXTRAS_DEVADMIN_ACTION			= "devadmin";
	
	// Device Administrator
	public static final int DEV_ADMIN_REQ_CODE						= 0x01;
	
	public static final int DEV_ADMIN_ACTION_CHANGE_PWD				= 0x01;
	public static final int DEV_ADMIN_ACTION_LOCK					= 0x02;
	public static final int DEV_ADMIN_ACTION_LOCK_PWD				= 0x03;
	public static final int DEV_ADMIN_ACTION_WIPE					= 0x04;
	
	// Device Administrator Policies
	public static final boolean POLICY_CAMERA_STAT_ENABLED			= TRUE;
	public static final boolean POLICY_CAMERA_STAT_DISABLE			= FALSE; 
	
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_5SEC		= ( MS_SECOND * 5L );
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_15SEC		= ( MS_SECOND * 15L );
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_30SEC		= ( MS_SECOND * 30L );
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_1MIN		= MS_MINUTE;
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_5MIN		= ( MS_MINUTE * 5L );
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_15MIN		= ( MS_MINUTE * 15L );
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_30MIN		= ( MS_MINUTE * 30L );
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK_1HOUR		= MS_HOUR;
	
	public static final long POLICY_PWD_EXPIRE_TIME_30MIN			= ( MS_MINUTE * 30L );
	public static final long POLICY_PWD_EXPIRE_TIME_1HOUR			= MS_HOUR;
	public static final long POLICY_PWD_EXPIRE_TIME_1DAY			= MS_DAY;
	public static final long POLICY_PWD_EXPIRE_TIME_1WEEK			= MS_WEEK;
	public static final long POLICY_PWD_EXPIRE_TIME_30DAY			= ( MS_DAY * 30L );
	public static final long POLICY_PWD_EXPIRE_TIME_365DAY			= ( MS_DAY * 365L );

	public static final int POLICY_PWD_HISTORY_COUNT_NEVER		= 0;
	public static final int POLICY_PWD_HISTORY_COUNT_1			= 1;
	public static final int POLICY_PWD_HISTORY_COUNT_3			= 3;
	public static final int POLICY_PWD_HISTORY_COUNT_5			= 5;
	public static final int POLICY_PWD_HISTORY_COUNT_10			= 10;
	
	public static final int POLICY_PWD_MIN_LEN_NEVER			= 0;
	public static final int POLICY_PWD_MIN_LEN					= 4;
	public static final int POLICY_PWD_MAX_LEN					= 16;
	
	public static final int POLICY_PWD_MIN_LETTER_NEVER			= 0;
	public static final int POLICY_PWD_MIN_LOWERCASE_NEVER		= 0;
	public static final int POLICY_PWD_MIN_NONLETTER_NEVER		= 0;
	public static final int POLICY_PWD_MIN_NUMERIC_NEVER		= 0;
	public static final int POLICY_PWD_MIN_SYMBOL_NEVER			= 0;
	public static final int POLICY_PWD_MIN_UPPERCASE_NEVER		= 0;
	
	public static final int POLICY_PWD_QUALITY_UNSPEICIFIED		= DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED;
	public static final int POLICY_PWD_QUALITY_SOMTHING			= DevicePolicyManager.PASSWORD_QUALITY_SOMETHING;
	public static final int POLICY_PWD_QUALITY_NUMERIC			= DevicePolicyManager.PASSWORD_QUALITY_NUMERIC;
	public static final int POLICY_PWD_QUALITY_ALPHABETIC		= DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC;
	public static final int POLICY_PWD_QUALITY_ALPHANUMERIC		= DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC;
	public static final int POLICY_PWD_QUALITY_COMPLEX			= DevicePolicyManager.PASSWORD_QUALITY_COMPLEX;

	// Sync Deviceinfo
	public static final String SIM_STATE_UNKNOWN				= "Unknown";
	public static final String SIM_STATE_ABSENT					= "Absent"; 
	public static final String SIM_STATE_PIN_REQUIRED			= "PIN Required";
	public static final String SIM_STATE_PUK_REQUIRED			= "PUK Required";
	public static final String SIM_STATE_NETWORK_LOCKED 		= "Network Locked";
	public static final String SIM_STATE_READY					= "Ready";
	
	// Defualt String, primitive values
	public static final String STR_NA							= "N/A";

	// HTTP REQUEST
	public static final String URL_COMMONSYNC					= "commonsync";
	public static final String URL_COMMONSYNC_CTRL_SYNCDATA		= "syncdata";
	
}
