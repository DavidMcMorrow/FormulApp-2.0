package com.Group7.formulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;

import org.nfunk.jep.JEP;

public class Maths_Graph extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Intent intent = getIntent();
         String fct = intent.getStringExtra("fct");
        JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();

        double x,y;
        x =0;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series= new LineGraphSeries<>();

        //Define the number of data point we use to build the graph
        int numPoints = 500;
        for(int i = 0; i <numPoints; i++){
            x = x+0.1; //We increase the value of x of 0.1, to have a continue graph
            myParser.addVariable("x", x);
            myParser.parseExpression(fct);
            y = myParser.getValue();

            series.appendData(new DataPoint(x,y),true,100); // We add the point to the series
        }

        // set manual X bounds
        /*graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-100);
        graph.getViewport().setMaxY(100);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-100);
        graph.getViewport().setMaxX(100);*/

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        //Now we add the serie to the graph
        graph.addSeries(series);

    }
}
