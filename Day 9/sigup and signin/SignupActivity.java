package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    EditText etname,etemail,etpassword,etphone;
    Button btnsignup;
    public static final String main_key="mypref";
    public static final String name_key="name";
    public static final String email_key="email";
    public static final String password_key="password";
    public static final String phone_key="phone";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etname = findViewById(R.id.etname);
        etemail = findViewById(R.id.etemail);
        etpassword= findViewById(R.id.etpassword);
        etphone = findViewById(R.id.etphone);
        btnsignup = findViewById(R.id.btnsignup);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences(main_key,MODE_PRIVATE);
                String name,email,password,phone;
                name=etname.getText().toString();
                email=etemail.getText().toString();
                password=etpassword.getText().toString();
                phone=etphone.getText().toString();

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(name_key,name);
                editor.putString(email_key,email);
                editor.putString(password_key,password);
                editor.putString(phone_key,phone);

                editor.commit();

                Intent intent=new Intent(SignupActivity.this,loginActivity.class);
                startActivity(intent);

            }
        });
    }
}
