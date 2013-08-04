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
		this.init(mCtx);
		
	}
	
	private void init(Context ctx) 
	{
        mRegid = getRegistrationId(mCtx);

        if (mRegid.length() == 0) {
            registerBackground();
        }
        
        gcm = GoogleCloudMessaging.getInstance(mCtx);
	}
	
	public String getRegistrationId(Context context) {
		
		String regid = "";
		
		try 
		{
			regid = mPref.getGCMRegID();
			if ( regid.length() == 0 ) {
				Debug.log(mCtx.getString(R.string.E_NO_GCM_REGID) );
				return "";
			}

			// check if app was updated;
			int regver = mPref.getAppVersion();
			int curver = Utils.getAppVersion(mCtx);
			
			if ( regver != curver || isRegistrationExpired() ) {
				Debug.log("App version changed or registration expired");
				return "";
			}
			
		}catch(Exception e){}
		
		return regid;
	}
	
	private void setRegistrationId(Context context, String regid) {
	    int appver = Utils.getAppVersion(context);
	    Debug.log("Saving registration id on app version : " + appver);
	    mPref.setGCMRegID(regid);
	    mPref.setAppVersion(appver);
	    
	    long expiretime = System.currentTimeMillis() + Constants.GCM_EXPIRE_TIME_MS;
	    Debug.log("Setting registration expiry time to " + new Timestamp(expiretime) );

	    mPref.setRegIDExpireTime(expiretime);	    
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
	
	
	@SuppressWarnings("unchecked")
	public void registerBackground() {
	    new AsyncTask() {
			@Override
			protected Object doInBackground(Object... params) {
	            String msg = "";
	            try {
	                if (gcm == null) {
	                    gcm = GoogleCloudMessaging.getInstance(mCtx);
	                }
	                mRegid = gcm.register(EnvVar.GCM_SENDER_ID);
	                msg = "Device registered, registration id=" + mRegid;

	                // You should send the registration ID to your server over HTTP,
	                // so it can use GCM/HTTP or CCS to send messages to your app.

	                // For this demo: we don't need to send it because the device
	                // will send upstream messages to a server that echo back the message
	                // using the 'from' address in the message.

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

	    }.execute(null, null, null);
	}
	

	public void sendGCM() {
	}
	

}
