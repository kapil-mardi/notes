package kapsapps.notes.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticationProvider extends Service {

    Authenticator authenticator;

    public AuthenticationProvider() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        authenticator = new Authenticator(getApplicationContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
