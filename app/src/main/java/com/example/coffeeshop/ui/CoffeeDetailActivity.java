package com.example.coffeeshop.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.coffeeshop.R;
import com.example.coffeeshop.adapter.CoffeePageADapter;
import com.example.coffeeshop.models.Coffee;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private CoffeePageADapter adapterViewPager;
    ArrayList<Coffee> mcoffee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_detail);

        ButterKnife.bind(this);

        mcoffee = Parcels.unwrap(getIntent().getParcelableExtra("coffee"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new CoffeePageADapter(getSupportFragmentManager(), mcoffee);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}