package de.hochschule_trier.boundservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by eschs on 30.05.2017.
 */

public class MyServiceConnection implements ServiceConnection {
    private Activity activity;
    public MyServiceConnection (Activity activity) {
        this.activity = activity;
    }
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        CounterImpl counter = (CounterImpl) service;
        activity.setCounter(counter);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        activity.setCounter(null);
    }
}
