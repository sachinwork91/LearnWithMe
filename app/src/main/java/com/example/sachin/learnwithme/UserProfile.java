package com.example.sachin.learnwithme;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfile extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private String user_profile_key= null;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    StorageReference storageReference;
    private FirebaseDatabase database;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mDatabaseUsers;

    private CircleImageView profileImage;
    private TextView email;
    private TextView phoneno;
    private TextView location;
    private TextView university;
    private TextView resume;


    private  String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        email= (TextView) findViewById(R.id.userProfileemail);
        phoneno= (TextView) findViewById(R.id.userProfileNumber);
        location= (TextView) findViewById(R.id.userProfileLocation);
        university= (TextView) findViewById(R.id.userProfileUniversity);

        user_profile_key = getIntent().getExtras().getString("UserProfileKey");


        if( user_profile_key == null ){
            //user_profile_key=
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            user_profile_key = sharedPref.getString("UserProfileKey","null");
        }

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        Toast.makeText(UserProfile.this," USER ID FROM USER PROF :" + userID, Toast.LENGTH_SHORT ).show();

        mDatabase= FirebaseDatabase.getInstance().getReference().child("LearnWithMeUserProfiles");

        mDatabase.child(user_profile_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
               Log.d("Test","eamil ..." + dataSnapshot.child("email").getValue());
                fillData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }


    private void fillData(DataSnapshot dataSnapshot){
        email.setText(dataSnapshot.child("email").getValue()+"");
        phoneno.setText(dataSnapshot.child("phoneNo").getValue()+"");
        location.setText(dataSnapshot.child("location").getValue()+"");
    //    Picasso.with(UserProfile.this).load(dataSnapshot.child("profileimage").getValue()+"").into(profileImage);
       // for(DataSnapshot ds : dataSnapshot.getChildren()){
        //    ds.child().get

       // }

    }


}
