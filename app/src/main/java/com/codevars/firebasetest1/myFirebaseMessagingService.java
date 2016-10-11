package com.codevars.firebasetest1;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;



public class myFirebaseMessagingService extends FirebaseMessagingService {


    private static final String tag = "Fcm service";




    public void onMessageRecieved (RemoteMessage remoteMessage) {

        Log.d(tag,"haha" +remoteMessage.getFrom());
        Log.d(tag,"Notification Body:" +remoteMessage.getNotification().getBody());


    }
}
