package de.hochschule_trier.boundservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by eschs on 30.05.2017.
 */

public class MyServiceConnection implements ServiceConnection {
    private MainActivity activity;
    private SecondActivity secondActivity;
    public MyServiceConnection (MainActivity activity) {
        this.activity = activity;
    }
    public MyServiceConnection (SecondActivity activity) {
        this.secondActivity = activity;
    }
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        CounterImpl counter = (CounterImpl) service;
        if (secondActivity == null) {
            activity.setCounter(counter);
        }
        if (activity == null) {
            secondActivity.setCounter(counter);
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        activity.setCounter(null);
    }
}
