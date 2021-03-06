package de.hochschule_trier.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class BoundService extends Service {
    private static int instanceCounter = 0;
    private int number;
    public BoundService () {
        instanceCounter++;
        this.number = instanceCounter;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new CounterImpl();
    }
}
