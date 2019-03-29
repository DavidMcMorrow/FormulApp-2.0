package com.Group7.formulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Maths_Homepage extends AppCompatActivity {

    private Button Trig_btn;
    private Button Physics_btn;
    private Button quadrix_btn;
    private Button LandA_btn;
    private Button VandA_btn;
    private Button graph_btn;
    private Button differentiate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__homepage);



        Trig_btn = (Button) findViewById(R.id.Trig_btn);         //declaring buttons
        Physics_btn = (Button) findViewById(R.id.Physics_btn);
        LandA_btn = (Button) findViewById(R.id.LandA_btn);
        quadrix_btn = (Button) findViewById(R.id.quadrix_btn);
        VandA_btn = (Button) findViewById(R.id.VandA_btn);
        graph_btn = (Button) findViewById(R.id.graph_btn);
        differentiate_btn = (Button) findViewById(R.id.differentiate_btn);

        Trig_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openTrigPage();         //function for opening page
            }
        });

        Physics_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage();   //function for opening page
            }

        });

        LandA_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openLengthandAreaPage(); // function for opening page
            }
        });

        quadrix_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openQuadrixPage(); // function for opening page
            }
        });
        VandA_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openVandAPage(); // function for opening page
            }
        });
        graph_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGraphPage(); // function for opening page
            }
        });
        differentiate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendifferentiatepage();
            }
        });
    }

    public void openTrigPage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Trig_page.class);
        startActivity(intent);
    }
    public void openPhysicsPage(){
        Intent intent = new Intent(this,Physics_page.class);
        startActivity(intent);
    }
    public void openLengthandAreaPage(){
        Intent intent = new Intent(this,Length_Area_page.class);
        startActivity(intent);
    }
    public void openQuadrixPage(){
        Intent intent = new Intent(this,quadrix.class);
        startActivity(intent);
    }
    public void openVandAPage(){
        Intent intent = new Intent(this,Getting_Area_Volume.class);
        startActivity(intent);
    }
    public void openGraphPage(){
        Intent intent = new Intent(this,Maths_Function.class);
        startActivity(intent);
    }
    public void opendifferentiatepage(){
        Intent intent = new Intent(this,differentiation.class);
        startActivity(intent);
    }
}
