package com.example.currentlocationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.currentlocationexample.services.RestClient;
import com.example.currentlocationexample.utils.AlertDialogUtils;
import com.example.currentlocationexample.utils.Utils;

import org.json.JSONObject;

import static com.example.currentlocationexample.utils.ConstantValues.REST_ERROR;

public class MainActivity extends AppCompatActivity {
    private RestClient restClient;
    private Utils utils;
    private AlertDialogUtils alertDialogUtils;

    private static MainActivity instance = null;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;

        restClient = new RestClient(this);
        utils = new Utils(this);
        alertDialogUtils = new AlertDialogUtils(this);

        alertDialogUtils.showProgressDialog(true);
        restClient.restUserAuth();
    }

    public void userAuth(JSONObject responseObj) {
        boolean error = responseObj.optBoolean(REST_ERROR);
        if (error) {
            alertDialogUtils.showProgressDialog(false);
            utils.showToastLong("Authentication problem!! Please try latter.");
        } else {
            alertDialogUtils.showProgressDialog(false);
            utils.showToastLong("Authentication Done!!");
            startActivity(new Intent(MainActivity.this, MapsActivity.class));
            finish();
        }

    }

}
