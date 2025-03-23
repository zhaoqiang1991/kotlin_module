package com.example.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.activity.ComponentActivity;

import com.example.aidl_demo_client.R;
import com.example.aidlserver.IMyAidlInterface;


public class MainActivity extends ComponentActivity {
    private IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceConnection = null;
        }

        @Override
        public void onBindingDied(ComponentName name) {
            ServiceConnection.super.onBindingDied(name);
        }
    };

    private void bindService() {
        Intent intent = new Intent();
        intent.setClassName("com.example.aidlserver", "com.example.aidlserver.MyService");
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    private static final String TAG = "MainActivity";

    public void onClick(View view) {
        try {
            Log.d(TAG, "onClick" +
                    ", iMyAidlInterface = " + iMyAidlInterface.getName() +
                    ", iMyAidlInterface.getUserName(1) = " + iMyAidlInterface.getUserName("1") +
                    "" +
                    "");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "onClick"+ "出错了"+e.getMessage());
        }
    }

    public void sayHelloTest(View view) {
        try {
            iMyAidlInterface.sayHello("我是客户端");
            Log.d(TAG, "sayHelloTest" +
                    ", iMyAidlInterface.getUserName(1) = "  +
                    "" +
                    "");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "sayHelloTest"+ "出错了"+e.getMessage());
        }
    }

    public void bindService(View view) {
        Log.d(TAG, "bindService===");
        bindService();
    }
}
