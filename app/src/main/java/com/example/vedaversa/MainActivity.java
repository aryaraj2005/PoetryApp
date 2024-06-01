package com.example.vedaversa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
   RecyclerView recyclerView;
   PoetryAdapter poetryAdapter;
  ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitlization();
        getData();

    }

 public void  intitlization(){
         recyclerView = findViewById(R.id.poetry_recyclerview);
           // initialised retrofit from client
         Retrofit retrofit = ApiClient.getClient();
         // initlised apis interface
         apiInterface=  retrofit.create( ApiInterface.class);

 }
   public void setAdapter(List<poetryModel> poetryModelList) {
       poetryAdapter = new PoetryAdapter(this, poetryModelList);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
       recyclerView.setLayoutManager(linearLayoutManager);
       recyclerView.setAdapter(poetryAdapter);
   }


private void getData(){
        // call back method return the response of our apis
          apiInterface.fetchPoetry().enqueue(new Callback<fetchPoetryModel>() {
              @Override
              public void onResponse(Call<fetchPoetryModel> call, Response<fetchPoetryModel> response) {
                  try {
                      if(response != null) {
                          if (response.body().getStatus().equals("1")) {
                              setAdapter(response.body().getData());
                          } else {
                              Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                          }
                      }
                  }catch (Exception e){
                      Log.e("failure" , e.getLocalizedMessage());
                  }
              }

              @Override
              public void onFailure(Call<fetchPoetryModel> call, Throwable t) {
                     Log.e("failure" , t.getLocalizedMessage());
              }
          });
    }

}