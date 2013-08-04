package com.osx86.mdm;

import android.util.Log;


class Debug {
	
	static void log(String log) {
		if ( EnvVar.LOG_LEVEL == Log.VERBOSE) {
			Log.v( Constants.LOG_TAG, log);
		}
		else if ( EnvVar.LOG_LEVEL == Log.DEBUG) {
			Log.d( Constants.LOG_TAG, log);
		}
		else if ( EnvVar.LOG_LEVEL == Log.INFO) {
			Log.i( Constants.LOG_TAG, log);
		}
		else if ( EnvVar.LOG_LEVEL == Log.WARN) {
			Log.w( Constants.LOG_TAG, log);
		}
		else if ( EnvVar.LOG_LEVEL == Log.ERROR) {
			Log.e( Constants.LOG_TAG, log);
		}
//		else if ( EnvVar.LOG_LEVEL == Log.ASSERT ) {			
//		}
		else {
			Log.d( Constants.LOG_TAG, log);
		}
	}
	
}
