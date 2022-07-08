package com.example.store;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoreService {

    public static String KEY = "YbuDNDXefN2UYqL6ptSkgjGTo2QNRFY4";
    StoreApi api;

    public StoreService(){
       // Retrofit retrofit = createRtf();
      //  api = retrofit.create(StoreApi.class);
    }

    public StoreApi getApi() {
        return api;
    }

    private OkHttpClient createOkHttpClient(){
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                final Request original = chain.request();
                final HttpUrl originalHttpUrl = original.url();
                final HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", KEY).build();
                final Request.Builder requestBuilder = original.newBuilder()
                        .url(url);
                final Request request = requestBuilder.build();
                return  chain.proceed(request);
            }
        });
        return httpClient.build();
    }

   /* private Retrofit createRtf(){
        return  new Retrofit.Builder().baseUrl("https://webmagazin-app.glyanec.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }*/

}
