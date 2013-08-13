package com.osx86.mdm;

import android.app.Notification;
import android.support.v4.app.NotificationCompat.Style;

@SuppressWarnings("unused")
public class EnvVar {
	
	/*
	 * variables
	 */
	public static final String SOLUTION_NAME						= "MDM";
	public static final String GCM_SENDER_ID						= "INPUT YOUR SENDER ID";
	public static final int GCM_SOUND								= Constants.GCM_SOUND_DEFAULT;
	public static final long[] GCM_VIBRATION						= Constants.GCM_VIBRATION_PATTERN_LONG;
	public static final int GCM_STYLE								= Constants.GCM_STYLE_BIGPICTURE;
 
	public static final int RELEASE_LOG								= Constants.LOG_LEVEL_WARN;
	public static final int DEBUG_LOG								= Constants.LOG_LEVEL_DEBUG;
		
	public static final int BUILD_LEVEL								= Constants.BUILD_LEVEL_RELEASE;
	public static final int LOG_LEVEL								= BUILD_LEVEL == Constants.BUILD_LEVEL_RELEASE ? RELEASE_LOG : BUILD_LEVEL == Constants.BUILD_LEVEL_DEBUG ? DEBUG_LOG : null;
}
