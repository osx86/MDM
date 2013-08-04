package com.osx86.mdm;

public class EnvVar {
	/*
	 * variables
	 */
	public static final String GCM_SENDER_ID						= "406929460544";
	public static final String SOLUTION_NAME						= "MDM";

	public static final int RELEASE_LOG								= Constants.LOG_LEVEL_WARN;
	public static final int DEBUG_LOG								= Constants.LOG_LEVEL_DEBUG;
		
	public static final int BUILD_LEVEL								= Constants.BUILD_LEVEL_RELEASE;
	public static final int LOG_LEVEL								= BUILD_LEVEL == Constants.BUILD_LEVEL_RELEASE ? RELEASE_LOG : BUILD_LEVEL == Constants.BUILD_LEVEL_DEBUG ? DEBUG_LOG : null;
}
