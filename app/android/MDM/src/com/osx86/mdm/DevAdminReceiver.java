package com.osx86.mdm;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

public class DevAdminReceiver extends DeviceAdminReceiver {

    @Override
    public void onEnabled(Context context, Intent intent) {
        Debug.log(context.getString(R.string.DEV_ADMIN_STATUS_ENABLED));
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        return context.getString(R.string.DEV_ADMIN_STATUS_DISABLE_REQUESTED);
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
    	Debug.log(context.getString(R.string.DEV_ADMIN_STATUS_DISABLED));
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        Debug.pop(context.getString(R.string.DEV_ADMIN_STATUS_PASSWD_CHANGED));
    }

}
