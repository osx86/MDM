package com.osx86.mdm;



import java.io.IOException;
import java.sql.Timestamp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.gcm.GoogleCloudMessaging;


class GCMManager extends Activity {
	GoogleCloudMessaging gcm;
	
	private CommonPreference mPref;
	private Context mCtx;  
	private String mRegid;
	
	GCMManager(Context ctx) {
		mCtx = ctx;
		if ( Common.mPref == null ) { 
			Common.mPref = new CommonPreference(mCtx);
		}

		mPref = Common.mPref;
		init(mCtx);
	}
	
	private void init(Context ctx) 
	{
		
        mRegid = getRegistrationId(mCtx);
        
        // if (mRegid.length() == 0) {
        registerBackground();
        //}
        
        gcm = GoogleCloudMessaging.getInstance(mCtx);
        Debug.log("[End of 1]. Regid :" + mRegid);
	}
	
	public String getRegistrationId(Context context) {
		
		String regid = "";
		
		try 
		{
			regid = mPref.getGCMRegID();
			Debug.log("1-1. GCM REGID : " + regid ); 
			if ( regid.length() == 0 ) {
				Debug.log("1-1. NO GCM REGID : " + mCtx.getString(R.string.E_NO_GCM_REGID) );
				return "";
			}

			// check if app was updated;
			int regver = mPref.getAppVersion();
			int curver = Utils.getAppVersion(mCtx);
			
			Debug.log("1-2. Appversion : " + curver + ", Regver :" + regver); 
			if ( regver != curver || isRegistrationExpired() ) {
				Debug.log("1-2. App version changed or registration expired");
				return "";
			}
			
		}catch(Exception e){}
		
		return regid;
	}
	
	private void setRegistrationId(Context context, String regid) {
	    int appver = Utils.getAppVersion(context);
	    long expiretime = System.currentTimeMillis() + Constants.GCM_EXPIRE_TIME_MS;
	    
	    Debug.log("Saving registration id on app version : " + appver);
	    try {
		    if ( regid != null ) {
		    	Debug.log("registration id : " + regid);
		    	mPref.setGCMRegID(regid);
		    }
		    mPref.setAppVersion(appver);
		    Debug.log("Setting registration expiry time to " + new Timestamp(expiretime) );

		    mPref.setRegIDExpireTime(expiretime);	    

	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    
	}
	
	private boolean isRegistrationExpired() {
	    long expiretime = mPref.getRegIDExpireTime();	    
	    return System.currentTimeMillis() > expiretime;
	}

	/**
	 * Registers the application with GCM servers asynchronously.
	 * <p>
	 * Stores the registration id, app versionCode, and expiration time in the 
	 * application's shared preferences.
	 */
	
	
	private void registerBackground() {
	    new AsyncTask<Void,Void,String>() {
			@Override
			protected String doInBackground(Void... params) {
				Debug.log("*** Starting registerBackground Task ");
				
	            String msg = "";
	            try {
	                if (gcm == null) {
	                    gcm = GoogleCloudMessaging.getInstance(mCtx);
	                }
	                mRegid = gcm.register(EnvVar.GCM_SENDER_ID);
	                msg = "Device registered, registration id=" + mRegid;
	                Debug.log(msg);

	                // Save the regid - no need to register again.
	                setRegistrationId(mCtx, mRegid);
	            } catch (IOException ex) {
	                msg = "Error :" + ex.getMessage();
	            }
	            return msg;
			}

	        protected void onPostExecute(String msg) {
	            Debug.log(msg + "\n");
	        }

	    }.execute();
	}
	

	public void sendGCM() {
	}
	

}
