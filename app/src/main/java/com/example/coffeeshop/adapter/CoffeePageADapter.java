package com.example.coffeeshop.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.ui.CoffeeDetailFragment;

import java.util.ArrayList;

public class CoffeePageADapter extends FragmentPagerAdapter {
    private ArrayList<Coffee> mcoffee;

    public CoffeePageADapter(FragmentManager fm, ArrayList<Coffee> coffee){
        super(fm);
        mcoffee = coffee;
    }

    @Override
    public Fragment getItem(int position){
        return CoffeeDetailFragment.newInstance(mcoffee.get(position));
    }

    @Override
    public int getCount(){
        return mcoffee.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mcoffee.get(position).getName();
    }
}
