package de.hochschule_trier.boundservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private CounterImpl mCounter;
    private MyServiceConnection mServiceConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCounter != null) {
            handleUnbindService(null);
        }
    }
    public void setCounter(CounterImpl newCounter) {
        this.mCounter = newCounter;
        TextView textView = (TextView) findViewById(R.id.serviceMessage);
        if (mCounter != null) {
            textView.setText(R.string.service_bound_message);
        }
        else {
            textView.setText(R.string.service_unbound_message);
        }
    }
    public void handleBindService(View v) {
        if (mServiceConnection == null) {
            Log.d("test", Thread.currentThread().getName());
            Intent intent = new Intent(this, BoundService.class);
            mServiceConnection = new MyServiceConnection(this);
            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        }
    }
    public void handleUnbindService(View v) {
        if (mServiceConnection != null) {
            unbindService(mServiceConnection);
            mServiceConnection = null;
            setCounter(null);
        }
    }
    public void handleIncrement(View v) {
        handle(1);
    }
    public void handleReset(View v) {
        handle(2);
    }
    private void handle(int command) {
        TextView counterOutput = (TextView) findViewById(R.id.counterOutput);
        if (mCounter != null) {
            int newValue;
            switch (command) {
                case 1: newValue = mCounter.increment();
                    break;
                case 2: newValue = mCounter.reset();
                    break;
                default:
                    return;
            }
            counterOutput.setText("" + newValue);
        }
        else {
            counterOutput.setText(R.string.no_op_possible_message);
        }
    }
}
