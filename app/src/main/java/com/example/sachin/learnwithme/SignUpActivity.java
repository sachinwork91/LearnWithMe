package com.example.sachin.learnwithme;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {


    CircleImageView profileImage;
    private static final int GALLERY_REQ = 2;
    Uri mImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

       profileImage = (CircleImageView) findViewById(R.id.profile_image);


        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( SignUpActivity.this, " Image is Clicked" , Toast.LENGTH_SHORT ).show();

                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("Image/*");
                startActivityForResult(galleryIntent, GALLERY_REQ);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //We are able to get the image from gallery correctly
        if(requestCode == GALLERY_REQ && resultCode == RESULT_OK){

            Uri imageUri = data.getData();
           // profileImage.setImageURI(imageUri);
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                   .setAspectRatio(1,1)
                    .start(this);
        }




        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE )
        {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode==RESULT_OK){
                mImageUri = result.getUri();
                profileImage.setImageURI(mImageUri);

            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

    }


    public void onProfileSave(View view) {




    }
}
