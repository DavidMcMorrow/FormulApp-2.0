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
    private Button two_d_btn;
    private Button three_d;


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
        two_d_btn = (Button) findViewById(R.id.two_d_btn);
        three_d = (Button) findViewById(R.id.three_d);



    }

    //Function to open Trig Page

    public void openTrigPage(View v) {         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this, Trig_page.class);
        startActivity(intent);

    }
    public void openTrigPage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Trig_page.class);
        startActivity(intent);
    }

    //Function to open Physics Page
    public void openPhysicsPage(View v) {
        Intent intent = new Intent(this, Physics_page.class);
        startActivity(intent);
    }

    //Function to open Length and Area Page
    public void openLengthandAreaPage(View v) {
        Intent intent = new Intent(this, Length_Area_page.class);
        startActivity(intent);
    }

    //Function to open Quadrix Page
    public void openQuadrixPage(View v) {
        Intent intent = new Intent(this, quadrix.class);
        startActivity(intent);
    }

    //Function to open Volume and Area Page
    public void openVandAPage(View v) {
        Intent intent = new Intent(this, Getting_Area_Volume.class);
        startActivity(intent);
    }
    public void opentwo_d_btnPage(View v){
        Intent intent = new Intent(this,Two_d_page.class);
        startActivity(intent);
    }
    public void openthree_d_btnPage(View v){
        Intent intent = new Intent(this,Three_d_page.class);
        startActivity(intent);
    }

    //Function to open Graph Page
    public void openGraphPage(View v) {
        Intent intent = new Intent(this, Maths_Function.class);
        startActivity(intent);
    }

    //Function to open Differentiate Page
    public void openDifferentiatePage(View v) {
        Intent intent = new Intent(this, differentiation.class);
        startActivity(intent);
    }

    protected void goToNumericalIntegration(View v){
        Intent intent = new Intent(this, MathsNumericIntegration.class);
        startActivity(intent);
    }
}
