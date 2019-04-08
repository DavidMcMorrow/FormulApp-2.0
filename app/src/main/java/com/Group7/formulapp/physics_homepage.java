package com.Group7.formulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class physics_homepage extends AppCompatActivity {

    private Button Physics_btn1;
    private Button Physics_btn2;
    private Button Physics_btn3;
    private Button Physics_btn4;
    private Button Physics_btn5;
    private Button Physics_btn6;
    private Button Physics_btn7;
    private Button Physics_btn8;
    private Button Physics_btn9;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_homepage);

        Physics_btn1 = (Button) findViewById(R.id.Physics_btn1);         //declaring buttons
        Physics_btn2 = (Button) findViewById(R.id.Physics_btn2);
        Physics_btn3 = (Button) findViewById(R.id.Physics_btn3);
        Physics_btn4 = (Button) findViewById(R.id.Physics_btn4);
        Physics_btn5 = (Button) findViewById(R.id.Physics_btn5);
        Physics_btn6 = (Button) findViewById(R.id.Physics_btn6);
        Physics_btn7 = (Button) findViewById(R.id.Physics_btn7);


        Physics_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openPhysicsPage1();         //function for opening page
            }
        });

        Physics_btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage2();   //function for opening page
            }

        });

        Physics_btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage3(); // function for opening page
            }
        });



        Physics_btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage4(); // function for opening page
            }
        });
        Physics_btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage5(); // function for opening page
            }
        });
        Physics_btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage7(); // function for opening page
            }
        });
        Physics_btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage6(); // function for opening page
            }
        });
        Physics_btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicsPage7(); // function for opening page
            }
        });

    }
    public void openPhysicsPage1(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,mechanics_page.class);
        startActivity(intent);
    }
    public void openPhysicsPage2(){
        Intent intent = new Intent(this,elec_page.class);
        startActivity(intent);
    }
    public void openPhysicsPage3(){
        Intent intent = new Intent(this,light_page.class);
        startActivity(intent);
    }
    public void openPhysicsPage4() {

        Intent intent = new Intent(this, uvast_calc.class);
        startActivity(intent);
    }
    public void openPhysicsPage5() {

        Intent intent = new Intent(this, physics_experiments_homepage.class);
        startActivity(intent);
    }
    public void openPhysicsPage6() {

        Intent intent = new Intent(this, lens_calc.class);
        startActivity(intent);
    }
    public void openPhysicsPage7() {

        Intent intent = new Intent(this, gravity_page.class);
        startActivity(intent);
    }



}

