package com.osx86.mdm;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

public class DevPolicyManager {

	private Context mCtx;
	private DevicePolicyManager mDPM;
	private ComponentName mCname;
	
	DevPolicyManager(Context ctx) 
	{
		mCtx = ctx; 
		mDPM = (DevicePolicyManager)ctx.getSystemService(Context.DEVICE_POLICY_SERVICE);
		mCname= new ComponentName(ctx, DevAdminReceiver.class);	
		Debug.log("Initialized Device Policy Manager");
	}

	private void lock()
	{
		try {
			mDPM.lockNow();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
