package com.osx86.mdm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MainActivity extends Activity {
	private Context mCtx;
	
	private GCMManager mGCM;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mCtx = getApplicationContext();
        init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    
    public boolean init() {
    	mGCM = new GCMManager(mCtx);
    	return true;
    }
}
