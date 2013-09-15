package com.osx86.mdm;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	private Context mCtx;
	private GCMManager mGCM;
	private CommonPreference mPref;
	private boolean thread_flag_datasync;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mCtx = getApplicationContext();
        if ( Common.mPref == null ) {
        	Common.mPref = new CommonPreference(mCtx);	
        }
        mPref = Common.mPref;
        
        if ( Common.mCtx == null ) {
        	Common.mCtx = mCtx;
        }
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    
    public boolean init() {
    	thread_flag_datasync = false;
    			
    			
    	if ( mPref.getGCMRegID() != null )  {
    		Debug.log("stored registration id : " + mPref.getGCMRegID() );
    	}
    	Debug.log("Loading GCMManager...");
    	
    	mGCM = new GCMManager(mCtx);
    	
    	// activate device administration 
        ComponentName mCname = new ComponentName(this, DevAdminReceiver.class);
    	DevicePolicyManager mDPM = (DevicePolicyManager) mCtx.getSystemService(Context.DEVICE_POLICY_SERVICE);

		if (!mDPM.isAdminActive(mCname) ) {
    		Debug.log("Activating DeviceAdmin.");
    		
    		Intent intent = new Intent(this, DevAdminManager.class);
    		startActivity(intent);
    	}
    	
		// sync new device info
		if ( thread_flag_datasync == false ) {
			new Thread(new Runnable() {           
				public void run() {        
					new DataSync(mCtx).syncdata();
				}
			}).start();
			thread_flag_datasync = true;
		}
		
		Debug.log("Now Syncing New Device Information. ");
		
		
    	return true;
    }
}
