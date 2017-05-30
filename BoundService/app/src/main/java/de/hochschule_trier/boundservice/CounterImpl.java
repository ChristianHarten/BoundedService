package de.hochschule_trier.boundservice;

import android.os.Binder;

/**
 * Created by eschs on 30.05.2017.
 */

public class CounterImpl extends Binder {
    private int counter;
    public int increment() {
        counter++;
        return counter;
    }
    public int reset() {
        counter = 0;
        return counter;
    }
}
