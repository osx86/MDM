package com.osx86.mdm;

import android.content.Context;

class CommonPreference extends Preference 
{
    CommonPreference(Context ctx)
    {
        super(ctx);
    }

    int getAppVersion()
    {
        return mPref.getInt(PrefKeys.APP_VERSION, Constants.DEFAULT_INT_VAL);
    }

    boolean setAppVersion(int appver)
    {
        return setValue(PrefKeys.APP_VERSION, appver);
    }

    // GCM Pref
    String getGCMRegID()
    {
        return mPref.getString(PrefKeys.GCM_REGID, Constants.DEFAULT_STRING_VAL);
    }

    boolean setGCMRegID(String regid)
    {
        return setValue(PrefKeys.GCM_REGID, regid);
    }

    Long getRegIDExpireTime()
    {
        return mPref.getLong(PrefKeys.GCM_REGID_EXPIRE_TIME, Constants.DEFAULT_LONG_VAL);
    }

    boolean setRegIDExpireTime(Long expiretime)
    {
        return setValue(PrefKeys.GCM_REGID_EXPIRE_TIME, expiretime);
    }
    
    
}
