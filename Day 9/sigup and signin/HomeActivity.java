package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4;
    Button b1;
    public static final String main_key = "myPref";
    public static final String name_key = "namekey";
    public static final String email_key = "emailkey";
    public static final String password_key = "passwordkey";
    public static final String mobile_key = "mobilekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        b1 = findViewById(R.id.b1);

        SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
        String name = sharedPreferences.getString(name_key,"");
        String email = sharedPreferences.getString(email_key,"");
        String password = sharedPreferences.getString(password_key,"");
        String mobile = sharedPreferences.getString(mobile_key,"");
        tv1.setText("Name:- "+name);
        tv2.setText("Email:- "+email);
        tv3.setText("Password:- "+password);
        tv4.setText("Phone:- "+mobile);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(main_key,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }
}
