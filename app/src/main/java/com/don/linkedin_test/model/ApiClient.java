package com.don.linkedin_test.model;

/**
 * Created by gideon on 25,March,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
import android.util.Log;

import com.don.linkedin_test.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private ApiInterface mApiInterface;


    public ApiInterface getApiInterface() {
        if (mApiInterface == null) {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder client = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS);

            client.addInterceptor(loggingInterceptor);


            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            mApiInterface = retrofit.create(ApiInterface.class);
            Log.d("BASE_URL", String.valueOf(retrofit));

        }
        return mApiInterface;
    }


}