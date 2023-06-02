package com.cit.expensemange.Activity;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import com.cit.expensemange.R;
import com.cit.expensemange.databinding.ActivityMainBinding;
import com.cit.expensemange.fragment.AddTransactionFragment;

public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
          setSupportActionBar(binding.topToolbar);
          getSupportActionBar().setTitle("Transaction");

          binding.floatingActionButton.setOnClickListener(v->{

              new AddTransactionFragment().show(getSupportFragmentManager(),null);


          });











    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}