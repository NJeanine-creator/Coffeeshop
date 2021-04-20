package com.example.coffeeshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeshop.R;
import com.example.coffeeshop.models.Coffee;
import com.example.coffeeshop.ui.CoffeeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeListAdapter extends RecyclerView.Adapter<CoffeeListAdapter.CoffeeViewHolder> {
    private ArrayList<Coffee> mcoffee = new ArrayList<>();
    private Context mContext;

    public CoffeeListAdapter(Context context, ArrayList<Coffee> coffee){
        mContext = context;
        mcoffee = coffee;
    }

    @Override
    public CoffeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_list_item, parent, false);
        CoffeeViewHolder viewHolder = new CoffeeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CoffeeViewHolder holder, int position){
        holder.bindCoffee(mcoffee.get(position));
    }

    @Override
    public int getItemCount(){
        return mcoffee.size();
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.coffeeimage) ImageView mcoffeeimage;
        @BindView(R.id.coffeenametxt) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public CoffeeViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindCoffee(Coffee coffee) {
            mNameTextView.setText(coffee.getName());
            mCategoryTextView.setText(coffee.getCategories().get(0));
            mRatingTextView.setText("Rating: " + coffee.getRating() + "/5");
            Picasso.get().load(coffee.getImageUrl()).into(mcoffeeimage);
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, CoffeeDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("hotels", Parcels.wrap(mcoffee));
            mContext.startActivity(intent);
        }
    }
}
