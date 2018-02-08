package kapsapps.notes.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {

    SyncAdapter mSyncAdapter;
    private static final Object lock = new Object();


    public SyncService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (lock) {
            if(mSyncAdapter == null)
                mSyncAdapter = new SyncAdapter(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mSyncAdapter.getSyncAdapterBinder();
    }
}
