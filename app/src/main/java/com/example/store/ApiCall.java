package com.example.store;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiCall {

    public String GETMAIN(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder().addHeader("X-TOKEN", "YbuDNDXefN2UYqL6ptSkgjGTo2QNRFY4")
                .addHeader("Content-Type", "application/json").url("https://webmagazin-app.glyanec.net/basket/api/v1.0/products").build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String GETMAINSRC(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder().addHeader("X-TOKEN", "YbuDNDXefN2UYqL6ptSkgjGTo2QNRFY4")
                .addHeader("Content-Type", "application/json").url("https://webmagazin-app.glyanec.net/basket/api/v1.0/categorylist").build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
