package com.example.sachin.learnwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userName_vw;
    private EditText userPassword_vw;
    private TextView error_vw;
    private Button login_bw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_bw= (Button) findViewById(R.id.login);
        login_bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test","Button Clicked .... ");
                verifyUser();
            }
        });
    }




    void verifyUser(){

        userName_vw=(EditText) findViewById(R.id.username);
        userPassword_vw=(EditText) findViewById(R.id.userpassword);
        error_vw=(TextView) findViewById(R.id.error);
        String userName= userName_vw.getText().toString();
        String userPassword= userPassword_vw.getText().toString();

        if( !UserValidation.isValidUser(userName,userPassword) )
        {
           error_vw.setVisibility(View.VISIBLE);
            error_vw.setText("Error");
        }else{
            error_vw.setText("Good Work");
            error_vw.setVisibility(View.VISIBLE);
            Intent intent = new Intent(this, CatActivity.class);
            startActivity(intent);
        }

    }

}
