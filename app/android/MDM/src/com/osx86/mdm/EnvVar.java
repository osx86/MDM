package com.osx86.mdm;

import android.app.Notification;
import android.support.v4.app.NotificationCompat.Style;

@SuppressWarnings("unused")
public class EnvVar {
	
	/*
	 * variables
	 */
	public static final String DEFAULT_PROTOCOL						= "http";
	public static final String SERVER_DOMAIN						= "mdm.libeasy.com";
	public static final String SERVER_URL							= DEFAULT_PROTOCOL + "://" + SERVER_DOMAIN;
	
	public static final String SOLUTION_NAME						= "MDM";
	public static final String GCM_SENDER_ID						= "";

	// gcm
	public static final int GCM_SOUND								= Constants.GCM_SOUND_DEFAULT;
	public static final long[] GCM_VIBRATION						= Constants.GCM_VIBRATION_PATTERN_LONG;
	public static final int GCM_STYLE								= Constants.GCM_STYLE_BIGPICTURE;
 
	// release
	public static final int RELEASE_LOG								= Constants.LOG_LEVEL_WARN;
	public static final int DEBUG_LOG								= Constants.LOG_LEVEL_DEBUG;
		
	// debug
	public static final int BUILD_LEVEL								= Constants.BUILD_LEVEL_RELEASE;
	public static final int LOG_LEVEL								= BUILD_LEVEL == Constants.BUILD_LEVEL_RELEASE ? RELEASE_LOG : BUILD_LEVEL == Constants.BUILD_LEVEL_DEBUG ? DEBUG_LOG : null;
	
	// device policy 
	public static final boolean POLICY_CAMERA_STAT					= Constants.POLICY_CAMERA_STAT_ENABLED;
	
	public static final int POLICY_PWD_MAX_FAIL_FOR_WIPE			= 50;
	public static final long POLICY_PWD_MAX_TIME_TO_LOCK			= Constants.POLICY_PWD_MAX_TIME_TO_LOCK_15SEC;
	public static final long POLICY_PWD_EXPIRE_TIME					= Constants.POLICY_PWD_EXPIRE_TIME_30MIN;
	public static final int POLICY_PWD_HISTORY_COUNT				= Constants.POLICY_PWD_HISTORY_COUNT_10;
	public static final int POLICY_PWD_MIN_LEN						= Constants.POLICY_PWD_MIN_LEN;
	public static final int POLICY_PWD_MIN_LETTER					= Constants.POLICY_PWD_MIN_LETTER_NEVER;
	public static final int POLICY_PWD_MIN_LOWERCASE				= Constants.POLICY_PWD_MIN_LOWERCASE_NEVER;
	public static final int POLICY_PWD_MIN_NONLETTER				= Constants.POLICY_PWD_MIN_NONLETTER_NEVER;
	public static final int POLICY_PWD_MIN_NUMERIC					= Constants.POLICY_PWD_MIN_NUMERIC_NEVER;
	public static final int POLICY_PWD_MIN_SYMBOL					= Constants.POLICY_PWD_MIN_SYMBOL_NEVER;
	public static final int POLICY_PWD_MIN_UPPERCASE				= Constants.POLICY_PWD_MIN_UPPERCASE_NEVER;
	public static final int POLICY_PWD_QUALITY_NUMERIC				= Constants.POLICY_PWD_QUALITY_NUMERIC;
	
}
