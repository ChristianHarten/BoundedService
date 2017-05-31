package de.hochschule_trier.boundservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class MyServiceConnection implements ServiceConnection {
    // lieber interface benutzen, anstelle von zwei klassen
    // zb IMyServiceConnection
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
