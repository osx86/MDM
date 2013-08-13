package com.osx86.mdm;

import android.util.Log;
import android.widget.Toast;


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
	
	static void pop(String msg) {
		Toast.makeText(Common.mCtx, (msg == null ? "null" : msg) , Toast.LENGTH_SHORT).show();
	}
}
