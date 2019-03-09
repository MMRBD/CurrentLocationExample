package com.example.currentlocationexample.services;

import android.content.Context;

import com.example.currentlocationexample.utils.ConstantValues;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


public class HttpClient {
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getBaseURL() + url, params, responseHandler);
    }

    public static void post(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setBasicAuth("leon@hll.com", "1234");
        client.post(getBaseURL() + url, params, responseHandler);
    }

    private static String getBaseURL() {
        return ConstantValues.API_BASE_URL;
    }
}
