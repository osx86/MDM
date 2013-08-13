package com.osx86.mdm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	private Context mCtx;
	private GCMManager mGCM;
	private CommonPreference mPref;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mCtx = getApplicationContext();
        if ( Common.mPref == null ) {
        	Common.mPref = new CommonPreference(mCtx);	
        }
        mPref = Common.mPref;
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    
    public boolean init() {
    	if ( mPref.getGCMRegID() != null )  {
    		Debug.log("stored registration id : " + mPref.getGCMRegID() );
    	}
    	Debug.log("Loading GCMManager...");
    	
    	mGCM = new GCMManager(mCtx);
    	//new DevPolicyManager(mCtx);
    	new DevAdminManager();
    	
    	
    	return true;
    }
}
