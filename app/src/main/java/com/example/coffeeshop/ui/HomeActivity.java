package com.example.coffeeshop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.coffeeshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.btnGo) Button mGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        FragmentManager fm = getSupportFragmentManager();
        //DailyChoose dailyChoose = new DailyChoose ();
       // PromptActivity promptActivity=new PromptActivity();
       // promptActivity.show(fm, "Sample Fragment");

        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,CoffeeChoose.class);
                startActivity(intent);
            }
        });
    }
}