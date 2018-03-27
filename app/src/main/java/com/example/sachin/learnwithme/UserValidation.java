package com.example.sachin.learnwithme;

import android.util.Log;

/**
 * Created by sachin on 3/26/2018.
 */

public class UserValidation {




    static boolean isValidUser(String str, String password){

        if(str.equals("sachin") && password.equals("pwd")){
            Log.d("test", "Valid pwd ");
            return true;
        }else{
            return true;
        }


    }

}
