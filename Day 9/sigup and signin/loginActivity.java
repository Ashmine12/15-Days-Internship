package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
EditText etemail,etpassword;
Button btnsignin,btnsignup;

    public static final String main_key="mypref";
    public static final String email_key="email";
    public static final String password_key="password";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etemail=findViewById(R.id.etemail);
        etemail=findViewById(R.id.etpassword);
        btnsignin=findViewById(R.id.btnsignin);
        btnsignup=findViewById(R.id.btnsignup);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail,userpassword;
                useremail=etemail.getText().toString();
                userpassword=etpassword.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences(main_key,MODE_PRIVATE);
                String email= sharedPreferences.getString(email_key,"");
                String password=sharedPreferences.getString(password_key,"");

                if (useremail.equals(email) && userpassword.equals(password)){
                    Intent intent=new Intent(loginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginActivity.this, "invalid login", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}
