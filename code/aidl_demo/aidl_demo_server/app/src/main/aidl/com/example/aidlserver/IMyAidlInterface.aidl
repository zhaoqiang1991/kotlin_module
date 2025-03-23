package com.example.aidlserver;
import com.example.aidlserver.User;

interface IMyAidlInterface {
    String getName();
    User getUserName(String data);

    void sayHello(String str);
}
