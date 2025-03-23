package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private static User user;
    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("zhangsan");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind" + "");

        return new MyBinder();
    }

    static class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public String getName() throws RemoteException {
            return "test";
        }

        @Override
        public User getUserName(String data) throws RemoteException {
            return user;
        }

        @Override
        public void sayHello(String str) throws RemoteException {
            Log.d(TAG, "sayHello" + str);
        }
    }
}
