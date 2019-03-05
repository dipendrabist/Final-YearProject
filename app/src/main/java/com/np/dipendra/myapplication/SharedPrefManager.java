package com.np.dipendra.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {


    //the constants
    private static final String SHARED_PREF_NAME = "MyPrefManager";
    private static final String KEY_ID = "keyid";
    private static final String KEY_SID = "keysid";
    private static final String KEY_SPASS = "keyspass";
    private static final String KEY_SNAME = "keysname";
    private static final String KEY_SFACULTY = "keysfaculty";
    private static final String KEY_SEMAIL = "keysemail";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    public SharedPrefManager(Context context) {
        mCtx=context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance==null){
            mInstance=new SharedPrefManager(context);

        }
        return mInstance;
    }
    public void userLogin(Modal modal) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, Integer.parseInt(modal.getId()));
        editor.putString(KEY_SNAME, modal.getSname());

        editor.putString(KEY_SFACULTY, modal.getSfaculty());
        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SID, null) != null;
    }

    public Modal getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Modal(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_SID, null),
                sharedPreferences.getString(KEY_SNAME, null),
                sharedPreferences.getString(KEY_SFACULTY, null),
                sharedPreferences.getString(KEY_SEMAIL,null),
                sharedPreferences.getString(KEY_SPASS,null)
        );
    }

    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }

}
