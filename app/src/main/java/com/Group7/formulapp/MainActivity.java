package com.Group7.formulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button maths_homepage_btn;
    private Button Physics_homepage_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maths_homepage_btn   =  (Button) findViewById(R.id.maths_homepage_btn);         //declaring buttons
        Physics_homepage_btn = (Button) findViewById(R.id.Physics_Homepage_btn);


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

    }
    public void openMaths_Homepage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Maths_Homepage.class);
        startActivity(intent);
    }
    public void openPhysics_homepage(){
        Intent intent = new Intent(this,physics_homepage.class);
        startActivity(intent);
    }
}
