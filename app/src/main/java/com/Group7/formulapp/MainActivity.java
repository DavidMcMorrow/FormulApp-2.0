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
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);

        maths_homepage_btn   =  (Button) findViewById(R.id.maths_homepage_btn);         //declaring buttons
        Physics_homepage_btn = (Button) findViewById(R.id.Physics_Homepage_btn);

        listView = (ListView) findViewById(R.id.listView);


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
        listView.setVisibility(View.GONE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, Trig_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                } else if(position == 1) {
                    Intent intent = new Intent(MainActivity.this, quadrix.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 2) {
                    Intent intent = new Intent(MainActivity.this, Physics_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 3) {
                    Intent intent = new Intent(MainActivity.this, Trig_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 4) {
                    Intent intent = new Intent(MainActivity.this, Length_Area_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 5) {
                    Intent intent = new Intent(MainActivity.this, mechanics_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 6) {
                    Intent intent = new Intent(MainActivity.this, Maths_Setting_Graph.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 7) {
                    Intent intent = new Intent(MainActivity.this, MathsNumericIntegration.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 8) {
                    Intent intent = new Intent(MainActivity.this, uvast_calc.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }else if(position == 9) {
                    Intent intent = new Intent(MainActivity.this, Trig_page.class);
                    startActivity(intent);
                    listView.setVisibility(View.GONE);
                }
            }
        });

    }

    public void openMaths_Homepage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Maths_Homepage.class);
        startActivity(intent);
    }

    public void openPhysics_homepage(){
        Intent intent = new Intent(this,physics_homepage.class);
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
                listView.setVisibility(View.VISIBLE);
                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this,"No Match found" ,Toast.LENGTH_LONG).show();
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(newText);
                return false;
            }



        });
        return super.onCreateOptionsMenu(menu);
    }
}


