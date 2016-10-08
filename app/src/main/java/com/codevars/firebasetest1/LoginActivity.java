package com.codevars.firebasetest1;

import android.content.Intent;
import android.media.effect.Effect;
import android.support.annotation.NonNull;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.api.model.StringList;

public class LoginActivity extends AppCompatActivity {




    @Override


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final  FirebaseAuth auth;


        final EditText imputemail;
        final  EditText imputpassword;

        final  Button login;

        auth = FirebaseAuth.getInstance();

        imputemail = (EditText) findViewById(R.id.emaillogin);
        imputpassword = (EditText) findViewById(R.id.passwordlogin);
        login = (Button) findViewById(R.id.loginbutton);



        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                if (imputemail.getText().toString().matches("")&&imputpassword.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(),"Dude, Enter something",Toast.LENGTH_SHORT).show();
                }


                if (imputemail.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(),"Please enter you email",Toast.LENGTH_LONG).show();
                    return;
                }

                 if (imputpassword.getText().toString().matches("")) {

                    Toast.makeText(getApplicationContext(),"Please enter your password",Toast.LENGTH_SHORT).show();
                     return;
                }



                else {




                    auth.signInWithEmailAndPassword(imputemail.getText().toString().trim(),imputpassword.getText().toString().trim())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Error" +task.getException(), Toast.LENGTH_SHORT).show();



                                    } else {
                                        Toast.makeText(LoginActivity.this, "You have successfully logged in", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                                        startActivity(intent);
                                    }

                                }

                            });



                }







}
    });
    }
}


