package com.example.coffeeshop.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

public class CoffeeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mcoffee;
    private String[] mkitchen;

    public CoffeeArrayAdapter(Context mContext, int resource, String[] coffee, String[] mkitchen) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mcoffee = coffee;
        this.mkitchen = mkitchen;
    }

    @Override
    public Object getItem(int position) {
        String coffee = mcoffee[position];
        String kitchen = mkitchen[position];
        return String.format("%s \nServes great: %s", coffee, kitchen);
    }

    @Override
    public int getCount() {
        return mcoffee.length;
    }
}

