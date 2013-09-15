package com.osx86.mdm;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

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
		init();
	}

	public void init()
	{
    	DevicePolicyManager mDPM = (DevicePolicyManager) mCtx.getSystemService(Context.DEVICE_POLICY_SERVICE);

		if (!mDPM.isAdminActive(mCname) ) {
    		Debug.log("Activating DeviceAdmin.");
    		
    		Intent intent = new Intent(Common.mCtx, DevAdminManager.class);
    		mCtx.startActivity(intent);
    	}
	}
	
	public void lockDevice()
	{
		try {
			mDPM.lockNow();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * option : 0, WIPE_EXTERNAL_STORAGE 
	 * 
	 */
	public void wipeDevice(int option)
	{
		if ( option != 0 && option != DevicePolicyManager.WIPE_EXTERNAL_STORAGE ) {
			option = 0;
		}
		
		try {
			mDPM.wipeData(option);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * API Level 14
	 * flag : true = disable, false = enable
	 */
	public void setDisableCamera(boolean flag)
	{
		try {
			mDPM.setCameraDisabled(mCname, flag);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * pwd : new password 
	 * option : 0, RESET_PASSWORD_REQUIRE_ENTRY( other admin cannot change password )
	 * 
	 */
	public void resetPassword(String pwd, int option)
	{
		boolean result = false;
		if ( option != 0 && option != DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY ) {
			option = DevicePolicyManager.RESET_PASSWORD_REQUIRE_ENTRY;
		}
		
		try {
			result = mDPM.resetPassword(pwd, option);
		}
		catch(Exception e) {
			e.printStackTrace();
			Debug.pop("[Exception] Failed to resetPassword");
		}

		if ( result ) {
			Debug.pop("resetPassword - Successfully Done");
		}else {
			Debug.pop("Failed to resetPassword");
		}
	}
	
	/*
	 * num : fail count for wipe 
	 */
	public void setMaxFailPasswordForWipe(int num)
	{
		if (num <= 0 ) {
			num = EnvVar.POLICY_PWD_MAX_FAIL_FOR_WIPE;
		}

		try {
			mDPM.setMaximumFailedPasswordsForWipe(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMaxTimeToLock(long ms)
	{
		if (ms <= 0 ) {
			ms = EnvVar.POLICY_PWD_MAX_TIME_TO_LOCK;
		}

		try {
			mDPM.setMaximumTimeToLock(mCname, ms);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void setPasswordExpirationTime(long ms)
	{
		if (ms <= 0 ) {
			ms = EnvVar.POLICY_PWD_EXPIRE_TIME;
		}

		try {
			mDPM.setPasswordExpirationTimeout(mCname, ms);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void setPasswordHistoryCount(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_HISTORY_COUNT;
		}

		try {
			mDPM.setPasswordHistoryLength(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPasswordMinLen(int len)
	{
		if (len < 0 ) {
			len = EnvVar.POLICY_PWD_MIN_LEN;
		}

		try {
			mDPM.setPasswordMinimumLength(mCname, len);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setPasswordMinLetter(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_MIN_LETTER;
		}

		try {
			mDPM.setPasswordMinimumLetters(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setPasswordMinLowerCase(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_MIN_LOWERCASE;
		}

		try {
			mDPM.setPasswordMinimumLowerCase(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void setPasswordMinNonLetter(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_MIN_NONLETTER;
		}

		try {
			mDPM.setPasswordMinimumNonLetter(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void setPasswordMinNumeric(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_MIN_NUMERIC;
		}

		try {
			mDPM.setPasswordMinimumNumeric(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPasswordMinSymbol(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_MIN_SYMBOL;
		}

		try {
			mDPM.setPasswordMinimumSymbols(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setPasswordMinUpperCase(int num)
	{
		if (num < 0 ) {
			num = EnvVar.POLICY_PWD_MIN_UPPERCASE;
		}

		try {
			mDPM.setPasswordMinimumUpperCase(mCname, num);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPasswordQuality(int quality)
	{
		if (quality < 0 ) {
			quality = EnvVar.POLICY_PWD_MIN_UPPERCASE;
		}

		try {
			mDPM.setPasswordQuality(mCname, quality);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setStorageEncrypt(boolean encrypt)
	{
		int result = 0;
		try {
			result = mDPM.getStorageEncryptionStatus(); 
			if ( result == DevicePolicyManager.ENCRYPTION_STATUS_UNSUPPORTED ) {
				Debug.pop("Failed to Encrypt Storage - UnSupported");
				return;
			}else if ( result == DevicePolicyManager.ENCRYPTION_STATUS_INACTIVE ) {
				Debug.pop("Failed to Encrypt Storage - InActive");
				return;
			}else if ( result == DevicePolicyManager.ENCRYPTION_STATUS_UNSUPPORTED ) {
				Debug.pop("Failed to Encrypt Storage - UnSupported");
				return;
			}else {
				Debug.pop("Ready to Encrypt Storage.");
			}
				
			result = mDPM.setStorageEncryption(mCname, encrypt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	// Warning Policy : http://developer.android.com/reference/android/app/admin/DevicePolicyManager.html 
	
}
