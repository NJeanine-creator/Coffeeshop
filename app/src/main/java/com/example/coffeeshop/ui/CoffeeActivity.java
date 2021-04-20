package com.example.coffeeshop.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeshop.R;
import com.example.coffeeshop.adapter.CoffeeListAdapter;
import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.network.YelpClient;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CoffeeActivity extends AppCompatActivity {
    public static final String TAG = com.example.coffeeshop.ui.CoffeeActivity.class.getSimpleName();
    private ArrayList<Coffee> coffee = new ArrayList<>();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private CoffeeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getCoffee(location);
    }

    private void getCoffee(String location){
        final YelpClient yelpClient = new YelpClient();
        yelpClient.findCoffee(location, new Callback(){

            @Override
            public void onFailure(Call call, IOException e){
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                coffee = yelpClient.processResults(response);
                com.example.coffeeshop.ui.CoffeeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new CoffeeListAdapter(getApplicationContext(), coffee);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(com.example.coffeeshop.ui.CoffeeActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
