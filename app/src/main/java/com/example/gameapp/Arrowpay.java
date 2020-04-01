package com.example.gameapp;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Arrowpay extends Application {

    public static final String TAG = Arrowpay.class.getSimpleName();
    private static Arrowpay mInstance;
    public static final String BASE_URL = "https://gameplayzone.online/";
    private static Retrofit retrofit = null;

    public Arrowpay(){
        mInstance=this;
    }

    public static Context getContext(){return mInstance;}

    @Override
    public void onCreate() {
        super.onCreate();
        /*MobileAds.initialize(this, SharedPrefs.getString(SharedPrefs.userSharedPrefData.appId));

        *//*Facebook monatization Intialize*//*
        if (AudienceNetworkAds.isInAdsProcess(this)) {
            return;
        } // else execute default application initialization code

        AudienceNetworkInitializeHelper.initialize(this);

        if (DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }*/
    }

    public static synchronized Arrowpay getInstance() {
        return mInstance;
    }

    public static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS).build();
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static boolean isNetConnectionAvailable() {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean isMobileConnection(){
        boolean mobileDataEnabled = false; // Assume disabled
        try {

            final ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            int type = networkInfo.getType();
            if (type == 0){
                mobileDataEnabled = true;
            }
            String typeName = networkInfo.getTypeName();
            return networkInfo.isConnected() && mobileDataEnabled;
        }catch (Exception e){
            return false;
        }
    }

}



