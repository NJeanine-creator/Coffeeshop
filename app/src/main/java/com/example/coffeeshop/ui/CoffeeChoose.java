package com.example.coffeeshop.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.coffeeshop.ui.LoginActivity;
import com.example.coffeeshop.R;
import com.google.firebase.auth.FirebaseAuth;

public class CoffeeChoose extends AppCompatActivity {

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(CoffeeChoose.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffeechoose);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Handler objHandler = new Handler();
                objHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Toast.makeText(getBaseContext(), "You can make order now", Toast.LENGTH_LONG).show();
                    }

                    {
                        if (position == 0) {
                            Intent intent = new Intent(CoffeeChoose.this, DrinksActivity.class);
                            startActivity(intent);

                        }
                        if (position == 1) {
                            Intent intent = new Intent(CoffeeChoose.this, CappuccinoActivity.class);
                            startActivity(intent);
                        }
                        if (position == 2) {
                            Intent intent = new Intent(CoffeeChoose.this, FilterActivity.class);
                            startActivity(intent);
                        }
                    }
 /* public void OnItemClick(AdapterView<?> listView, View v, int position,long id ){

 } */
                });
            }
        };

        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        } else if (id == R.id.action_saved_events) {
            Intent intent = new Intent(CoffeeChoose.this, FindUserFragment.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}