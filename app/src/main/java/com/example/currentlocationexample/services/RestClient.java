package com.example.currentlocationexample.services;

import android.content.Context;

import com.example.currentlocationexample.MainActivity;
import com.example.currentlocationexample.utils.Utils;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RestClient {
    private Utils utils;
    private Context context;
    private RequestParams params;

    public RestClient() {
    }

    public RestClient(Context context) {
        this.context = context;
        utils = new Utils();
        params = new RequestParams();
    }


    public void restUserAuth() {
        HttpClient.post(context, "login", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                JSONObject responseObj;
                try {
                    responseObj = new JSONObject(response.toString());
                    utils.printLog("login_response", responseObj.toString());
                    MainActivity.getInstance().userAuth(responseObj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                if (errorResponse != null) {
                    utils.printLog("UserLogin: ", errorResponse.toString());
                }
            }

        });
    }
}
