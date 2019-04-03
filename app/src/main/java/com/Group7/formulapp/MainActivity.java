package com.Group7.formulapp;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    private Button maths_homepage_btn;
    private Button Physics_homepage_btn;
    private Button Units_btn;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maths_homepage_btn   =  (Button) findViewById(R.id.maths_homepage_btn);         //declaring buttons
        Physics_homepage_btn = (Button) findViewById(R.id.Physics_Homepage_btn);

        listView = (ListView) findViewById(R.id.listView);

        Units_btn = (Button) findViewById(R.id.Units_btn);

        maths_homepage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMaths_Homepage();         //function for opening page
            }
        });

        Physics_homepage_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysics_homepage();   //function for opening page
            }

        });
        Units_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openUnits_page();   //function for opening page
            }

        });


        list = new ArrayList<>();
        list.add("Formula 1");
        list.add("Formula 2");
        list.add("Formula 3");
        list.add("Formula 4");
        list.add("Formula 5");
        list.add("Formula 6");
        list.add("Formula 7");
        list.add("Formula 8");
        list.add("Formula 9");
        list.add("Formula 10");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    }

    public void openMaths_Homepage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Maths_Homepage.class);
        startActivity(intent);
    }

    public void openPhysics_homepage(){
        Intent intent = new Intent(this,physics_homepage.class);
        startActivity(intent);
    }
    public void openUnits_page(){
        Intent intent = new Intent(this,units_page.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchViewItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this,"No Match found" ,Toast.LENGTH_LONG).show();
                }
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


