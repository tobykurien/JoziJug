package com.tobykurien.jozijug;

import java.util.Date;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class GeneralReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
			String number = intent
					.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

			if (number != null) {
				NotificationManager nm = (NotificationManager) context
						.getSystemService(Context.NOTIFICATION_SERVICE);
				Notification n = new Notification(R.drawable.ic_launcher, null,
						new Date().getTime());
				CharSequence contentTitle = "JoziJUG";
				CharSequence contentText = "JoziJUG member calling: " + number;
				Intent notificationIntent = new Intent(context,
						JoziJugActivity.class);
				PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
						notificationIntent, 0);
				n.setLatestEventInfo(context, contentTitle, contentText,
						contentIntent);
				nm.notify(1, n);
			}
	}

}
