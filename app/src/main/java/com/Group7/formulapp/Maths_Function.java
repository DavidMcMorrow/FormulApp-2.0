package com.Group7.formulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;

import org.nfunk.jep.*;




import io.github.kexanie.library.MathView;


public class Maths_Function extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    protected double result;
    protected String fct;
    MathView formula_two;
   /* String tex = "This come from string. You can insert inline formula:" +
            " $$cos^2$$ " + "test" +
            "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";*/



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maths__function);
            Button clickButton = (Button) findViewById(R.id.submit_fct);
            clickButton.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    formula_two = (MathView) findViewById(R.id.formula_two);
                    EditText tex = (EditText) findViewById(R.id.equation);
                    formula_two.setText("$$"+tex.getText().toString()+"$$");
                    fct = tex.getText().toString();


                }
            });
        }



    //Action to go to the Graph view
    protected void goToGraph(View view) {

        Intent intent = new Intent(this, Maths_Graph.class);
        intent.putExtra("fct", fct);

        startActivity(intent);
    }
    }




