package com.example.coffeeshop.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.coffeeshop.R;
import com.example.coffeeshop.models.Coffee;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.coffeeimage) ImageView mImageLabel;
    @BindView(R.id.coffeenametxt) TextView mNameLabel;
    @BindView(R.id.coffeetype) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.savecoffeebtn) TextView msavecoffeebtn;

    private Coffee mcoffee;

    public CoffeeDetailFragment() {
        // Required empty public constructor
    }

    public static com.example.coffeeshop.ui.CoffeeDetailFragment newInstance(Coffee coffee){
        com.example.coffeeshop.ui.CoffeeDetailFragment CoffeeDetailFragment = new com.example.coffeeshop.ui.CoffeeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("coffee", Parcels.wrap(coffee));
        CoffeeDetailFragment.setArguments(args);
        return CoffeeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mcoffee = Parcels.unwrap(getArguments().getParcelable("hotel"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mcoffee.getImageUrl()).into(mImageLabel);
        mNameLabel.setText(mcoffee.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", mcoffee.getCategories()));
        mRatingLabel.setText(Double.toString(mcoffee.getRating()) + "/5");
        mPhoneLabel.setText(mcoffee.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mcoffee.getAddress()));

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v){
        if (v == mWebsiteLabel){
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mcoffee.getWebsite()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mcoffee.getPhone()));
            startActivity(phoneIntent);
        }if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mcoffee.getLatitude()
                            + "," + mcoffee.getLongitude()
                            + "?q=(" + mcoffee.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}