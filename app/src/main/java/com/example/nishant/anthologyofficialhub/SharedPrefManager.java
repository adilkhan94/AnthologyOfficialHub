package com.example.nishant.anthologyofficialhub;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Adilkhan on 9/27/2017.
 */
public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME="mysharedpref12";
    private static final String KEY_USER_EMAIL="useremail";
    private static final String KEY_PASSWORD="PASS";

    private SharedPrefManager(Context context)
    {
        mCtx=context;
    }
    SharedPrefManager()
    {

    }

  public static synchronized SharedPrefManager getInstance(Context context)
 {
     if(mInstance==null)
    {
        mInstance=new SharedPrefManager(context);
    }
return mInstance;
}

    public boolean userLogin(String email, String pass)
{
     SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
     SharedPreferences.Editor editor=sharedPreferences.edit();

    editor.putString(KEY_USER_EMAIL,email);
     editor.putString(KEY_PASSWORD, pass);

    editor.apply();

    return true;

}

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        if(sharedPreferences.getString(KEY_USER_EMAIL,null)!=null)
        {
            return true;
        }
        return false;
    }

public boolean logout()
{

    SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
    editor.clear();
    editor.apply();

    return  true;
}
    String s, s1;
    public String getUserEmail()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        s=sharedPreferences.getString(KEY_USER_EMAIL,null);

         //phpnj();
        return s;
    }

    public synchronized void phpnj()
    {
        Bgwork bgwork = new Bgwork(mCtx);
        String type = "EmpDesignationFetch";
        bgwork.execute(type, s);
    }

    /*@Override
    public void sendfet(String msg) {
        if(msg.equals("Employer")) {
            s1 = msg;
            Toast.makeText(mCtx, "kkkk"+s1, Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("designation",s1);
            editor.commit();

            kk=(shareddesignation)context;
            kk.sendshare(s1);
        }
        else if(msg.equals("Administrator")) {
            s1 = msg;
            Toast.makeText(mCtx, "kkkk"+s1, Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("designation",s1);
            editor.commit();

            kk=(shareddesignation)mCtx;
            kk.sendshare(s1);

        }
        else if(msg.equals("Seller")) {
            s1 = msg;
            Toast.makeText(mCtx, "kkkk"+s1, Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("designation",s1);
            editor.commit();

            kk=(shareddesignation)mCtx;
            kk.sendshare(s1);
        }
    }*/

    public String getDesignation()
    {
          SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

          String k=sharedPreferences.getString("designation",null);


        return k;
    }

}