package com.osx86.mdm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.app.TaskStackBuilder;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {
	
	private Uri notisound;
	private Style notistyle;
	private long[] notivib;	
	
	private int mMsgid = 0;
	
	public GCMIntentService() {
		super(EnvVar.GCM_SENDER_ID);
		init();
	}

	@SuppressWarnings("unused")
	private void init() {
		Debug.log("Initializing GCM Style...");
		
		if ( EnvVar.GCM_SOUND == Constants.GCM_SOUND_DEFAULT ) {
			notisound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		}else if (EnvVar.GCM_SOUND == Constants.GCM_SOUND_RINGTONE ) {
			notisound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
		}else {
			notisound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		}
		
		if ( EnvVar.GCM_STYLE == Constants.GCM_STYLE_BIGPICTURE ) {
			notistyle = new NotificationCompat.BigPictureStyle();
		}else if ( EnvVar.GCM_STYLE == Constants.GCM_STYLE_BIGTEXT ) {
			notistyle = new NotificationCompat.BigTextStyle();
		}else if ( EnvVar.GCM_STYLE == Constants.GCM_STYLE_INBOX ) {
			notistyle = new NotificationCompat.InboxStyle();
		}
	
		notivib = EnvVar.GCM_VIBRATION;
	}
	
	
	@Override
	protected void onError(Context arg0, String arg1) {
		Debug.log("GCMIntentService Error : " + arg1 );
	}

	
	@Override
	protected void onMessage(Context arg0, Intent arg1) {
		
		String notifymsg = arg1.getExtras().getString(Constants.GCM_EXTRAS_MESSAGE);
		Debug.log("GCMIntentService notify message : " + notifymsg);		
		
		if ( notifymsg != null ) { 
			NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
			        .setSmallIcon(R.drawable.ic_launcher)
			        .setContentTitle("MDM Notification")
			        .setSound(notisound)
			        .setVibrate(notivib)
			        .setStyle(notistyle)
			        .setContentText(notifymsg);

			// Creates an explicit intent for an Activity in your app
			Intent resultIntent = new Intent(this, MainActivity.class);

			TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
			stackBuilder.addParentStack(MainActivity.class);
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
			            0,
			            PendingIntent.FLAG_UPDATE_CURRENT
			        );
			
			mBuilder.setContentIntent(resultPendingIntent);
			NotificationManager mNotificationManager =
			    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			
			mNotificationManager.notify(mMsgid, mBuilder.build());
		}
	}

	@Override
	protected void onRegistered(Context arg0, String arg1) {
		Debug.log("GCMIntentService Registered : " + arg1 );		
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		Debug.log("GCMIntentService Unregistered : " + arg1 );

	}

}
