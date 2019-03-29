package com.Group7.formulapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.LegendRenderer;
import org.nfunk.jep.JEP;
import java.util.Random;


public class Maths_Graph extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Intent intent = getIntent();
        String[] fctList = intent.getStringArrayExtra("fct");

        //We create the parser with a call to the library JEP
        JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();

        double x, y;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>();

        //Define the number of data point we use to build the graph
        int numPoints = 10000;
        for (int j = 0; j < fctList.length -1; j++) {
            if (fctList[j] != null) {
                x = -500;
                series = new LineGraphSeries<>();
                for (int i = 0; i < numPoints; i++) {

                    x = x + 0.1; //We increase the value of x of 0.1, to have a continue graph
                    myParser.addVariable("x", x);
                    myParser.parseExpression(fctList[j]);
                    y = myParser.getValue();

                    series.appendData(new DataPoint(x, y), true, 10000); // We add the point to the series


                }
                //Now we add the serie to the graph
                graph.addSeries(series);
                //Add a title to each function
               series.setTitle(fctList[j]);
                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

                //Change color for each function
                Random rand = new Random();
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();

                int color = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                series.setColor(color);


            }
        }
        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-100);
        graph.getViewport().setMaxY(100);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-100);
        graph.getViewport().setMaxX(100);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);



    }
}
