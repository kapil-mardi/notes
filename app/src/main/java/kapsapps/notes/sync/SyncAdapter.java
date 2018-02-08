package kapsapps.notes.sync;

import android.accounts.Account;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kapil on 8/2/18.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter {


    AtomicInteger atomicInteger = new AtomicInteger(0);

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        Log.d("kapil","adapter called");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Log.d("kapil","notification called");

        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(new NotificationChannel("kapil","kapil",NotificationManager.IMPORTANCE_DEFAULT));

        int notificationId = atomicInteger.get();
        Notification.Builder notificationBuilder = new Notification.Builder(getContext())
                .setContentTitle("this is Sync notification")
                .setContentText("this is notificationX number " + notificationId)
                .setChannelId("kapil")
                .setAutoCancel(true);

        notificationManager.notify(notificationId,notificationBuilder.build());
    }
}
