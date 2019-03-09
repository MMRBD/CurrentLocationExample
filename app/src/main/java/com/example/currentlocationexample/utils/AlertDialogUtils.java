package com.example.currentlocationexample.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by MMR on 20-Aug-17.
 */

public class AlertDialogUtils {

    private Activity activity;
    ProgressDialog progressDialog;
    public AlertDialogUtils() {
    }

    public AlertDialogUtils(Activity activity) {
        this.activity = activity;
        progressDialog = new ProgressDialog(activity);
    }

    public void showProgressDialog(boolean show) {
        progressDialog.setMessage("Authorizing....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }
}
