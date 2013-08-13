package com.osx86.mdm;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DevAdminManager extends Activity {

	private Context mCtx;

	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_admin_manager);
        
        Debug.log("1.Loading Device Admin Receiver");
        loadActivation();
    }
	
	private void loadActivation()
	{
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, new ComponentName(Common.mCtx, DevAdminReceiver.class));

		startActivity(intent);
		Debug.log("2. Loading Device Admin Receiver");
	}
}
