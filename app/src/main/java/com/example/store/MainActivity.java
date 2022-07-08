package com.example.store;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.store.Model.Product;

public class MainActivity extends AppCompatActivity {

    private String path, responce;
    private OkHttpClient client;

    public Model model;
    private Model.Example example;
    private ApiCall apiCall;
    private List<Model.Product> data;

    private RecyclerView rv;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ImageButton tri_bt;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tri_bt = findViewById(R.id.tri_bt);

        apiCall = new ApiCall();
        data = new ArrayList<>();

        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);

        try{
            path = BaseUrl.BASE_URL;
            new GetData().execute();
        }
        catch (Exception e){}

    }

    private class GetData extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            recyclerAdapter = new RecyclerAdapter(MainActivity.this, data);
            rv.setAdapter(recyclerAdapter);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                client = new OkHttpClient();
                responce = apiCall.GETMAIN(client, path);

                Gson gson = new Gson();
                Type type = new TypeToken<Collection<Model>>(){

                }.getType();

                model = gson.fromJson(responce, Model.class);

                if (data.isEmpty()){
                    for (int i = 0; i < 15; i++){
                        data.add(example.getProducts().get(i));
                    }
                }
            }

            catch (IOException e){
                e.printStackTrace();
            }

            return null;

        }
    }
}
