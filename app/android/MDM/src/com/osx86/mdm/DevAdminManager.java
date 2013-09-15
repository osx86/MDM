package com.osx86.mdm;

import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DevAdminManager extends Activity {

	private Context mCtx;
	private DevicePolicyManager mDPM;
	private DevAdminReceiver mDAR;
	private ComponentName mCname;

	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_admin_manager);
        
        mCtx = getApplicationContext();
        Debug.log("1.Loading Device Admin Receiver");
        loadActivation(mCtx);
    }
	
	private void loadActivation(Context ctx)
	{
		Debug.log("Device Admin Explanation service on ");
        mCname = new ComponentName(this, DevAdminReceiver.class);
        
		mDPM = (DevicePolicyManager) ctx.getSystemService(Context.DEVICE_POLICY_SERVICE);

		if (!mDPM.isAdminActive(mCname) ) {
		    Intent devadminIntent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
	
		    try {
		    devadminIntent.putExtra( DevicePolicyManager.EXTRA_DEVICE_ADMIN, 
		    						new ComponentName(Common.mCtx, DevAdminReceiver.class));
		    devadminIntent.putExtra( DevicePolicyManager.EXTRA_ADD_EXPLANATION, 
		    						getResources().getString(R.string.DEV_ADMIN_ACTIVATION_MESSAGE));
	
		    startActivity(devadminIntent);
		    }catch (Exception e) 
		    {
		    	e.printStackTrace();
		    }
	    	Debug.log("DeviceAdmin Activated.");
		}
	}
}
