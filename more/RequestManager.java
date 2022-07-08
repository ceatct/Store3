package com.example.store;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {

    Context context;

    Retrofit retrofit = new Retrofit.Builder().
            baseUrl("https://newsapi.org/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getProduct(DataListener<ApiResponce> listener, String category, String query){
        CallApi callApi = retrofit.create(CallApi.class);
        Call<ApiResponce> call = callApi.callApiStore("us", category, query, context.getString(R.string.api_key));

        try {call.enqueue(new Callback<ApiResponce>() {
            @Override
            public void onResponse(Call<ApiResponce> call, @NonNull Response<ApiResponce> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show();
                }

                assert response.body() != null;
                listener.DListener(response.body().getProducts(), response.message());
            }

            @Override
            public void onFailure(Call<ApiResponce> call, Throwable t) {
                listener.onError("error");
            }
        });}
        catch (Exception e){e.printStackTrace();}
    }

    public RequestManager(Context context) {
        this.context = context;
    }

    public interface CallApi{
        @GET("top-headlines")
        Call<ApiResponce> callApiStore(
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_key
        );
    }
}
