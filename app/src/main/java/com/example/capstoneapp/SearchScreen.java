package com.example.capstoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

//import static com.example.capstoneapp.R.id.mysearchbar;

public class SearchScreen extends AppCompatActivity {

    ListView searchlist;
    ArrayAdapter<String> adapter;
    SearchView search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);


        ///Initialise and assign variables
        search = (SearchView) findViewById(R.id.mysearchbar);
        searchlist = (ListView) findViewById(R.id.mysearchlist);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        ArrayList<String> CompanyNames = new ArrayList<>();
        CompanyNames.addAll(Arrays.asList(getResources().getStringArray(R.array.mycompanies)));


        adapter = new ArrayAdapter<String>(
                SearchScreen.this,
                android.R.layout.simple_list_item_1,
                CompanyNames
        );

        searchlist.setAdapter(adapter);










        // Set search button selected
        bottomNavigationView.setSelectedItemId(R.id.searchbtn);

        // perform itemSelectedListener

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.searchbtn:
                        return true;

                    case R.id.profilebtn:
                        startActivity(new Intent( getApplicationContext(),ProfilePage.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.newsfeedbtn:
                        startActivity(new Intent( getApplicationContext(),NewsFeedScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });




    }

    //R.menu.search_menu
   // @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem item = menu.findItem(R.id.mysearchlist);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}

/*
*
* <SearchView
        android:id="@+id/mysearchbar"
        android:layout_width="match_parent"
        android:layout_height="56dp"
        android:background="#6B52DD"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0" />
*
*
*
*
* */