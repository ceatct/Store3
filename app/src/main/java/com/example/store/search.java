package com.example.store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import okhttp3.OkHttpClient;

public class search extends AppCompatActivity {

    private RecyclerView rv;
    private String path, responce;
    private OkHttpClient client;
    ModelSearch.Example ex;

    public ModelSearch model;
    private ApiCall apiCall;
    private List<ModelSearch.Example> data;

    private RecyclerAdapterSearch recyclerAdapters;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rv = findViewById(R.id.rv);

        apiCall = new ApiCall();
        data = new ArrayList<>();

        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);

        try{
            path = BaseUrl.BASE_URL2;
            new GetData().execute();
        }
        catch (Exception e){}
    }

    private class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            recyclerAdapters = new RecyclerAdapterSearch(search.this, data);
            rv.setAdapter(recyclerAdapters);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                client = new OkHttpClient();
                responce = apiCall.GETMAINSRC(client, path);

                Gson gson = new Gson();
                Type type = new TypeToken<Collection<Model>>(){

                }.getType();

                model = gson.fromJson(responce, ModelSearch.class);

                if (data.isEmpty()){
                    for (int i = 0; i < 15; i++){
                        //data.add(ex.getId().get(i));
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