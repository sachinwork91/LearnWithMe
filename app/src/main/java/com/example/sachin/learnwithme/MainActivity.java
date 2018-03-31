package com.example.sachin.learnwithme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sachin.learnwithme.data.Registeration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText userName_vw;
    private EditText userPassword_vw;
    private TextView error_vw;
    private Button login_bw;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName_vw=(EditText) findViewById(R.id.username);
        userPassword_vw=(EditText) findViewById(R.id.userpassword);
        error_vw=(TextView) findViewById(R.id.error);
        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Users");

        if(mAuth == null ){
            Log.d("Test ", "Auth is Falialin" );
        }else{
            Log.d("Test ", "Auth is Good" );
        }
    }

    //used for Firebase
    public void loginButtonClicked(View view){

        String email = userName_vw.getText().toString().trim();
        String pass = userPassword_vw.getText().toString().trim();


        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "TASK CLEAR" , Toast.LENGTH_SHORT).show();
                                checkUserExists();
                            }else{
                                Toast.makeText(MainActivity.this, "TASK INVALIDDDDD" , Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
            );
        }else{

            Toast.makeText(MainActivity.this, "Please Enter the Details Correctly" , Toast.LENGTH_SHORT).show();

        }
    }
    //THis method checks if the User exists or not Using FireBase
    public void checkUserExists(){
        if(mAuth == null ){
            Log.d("Test ", "Auth is Falialin" );
        }else{
            Log.d("Test ", "Auth is Good" );
        }
        final String user_id = mAuth.getCurrentUser().getUid();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)){ // the User exists and redirecting the user

                    Intent intent = new Intent(MainActivity.this, CatActivity.class);
                    startActivity(intent);


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "INVALID USER" , Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.d("Test", "Main Activity ....tool bar");
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        if(id==R.id.action_settings){
           Intent intent = new Intent(MainActivity.this, UserProfile.class);
           startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }



    public void onSignUpClicked(View view){
        Intent intent = new Intent(MainActivity.this, Registeration.class);
        startActivity(intent);

    }
}
