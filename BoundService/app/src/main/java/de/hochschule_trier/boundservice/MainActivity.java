package de.hochschule_trier.boundservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private CounterImpl mCounter;
    private MyServiceConnection mServiceConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setCounter(CounterImpl newCounter) {
        this.mCounter = newCounter;
    }
}
