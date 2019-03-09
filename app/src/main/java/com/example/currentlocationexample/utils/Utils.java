package com.example.currentlocationexample.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.example.currentlocationexample.BuildConfig;


/**
 * Created by Md. MMR on 12-Aug-18.
 */

public class Utils {
    private Context mContext;
    public Utils(){}

    public Utils(Context context){
        this.mContext = context;
    }

    public void showToastShort(String message){
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public void showToastLong(String message){
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public void printLog(String key, String message){
        if(BuildConfig.DEBUG){
            Log.d(key, message);
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
