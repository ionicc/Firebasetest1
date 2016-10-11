package com.codevars.firebasetest1;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class myFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private final static String tag = "FirebaseIDService";

    @Override

    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(tag,"Refreshed token :" +refreshedToken);

        sendRegistrationToServer(refreshedToken);

    }

    private void sendRegistrationToServer (String token) {

    }
}
