package com.Group7.formulapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.LegendRenderer;
import org.nfunk.jep.JEP;
import java.util.Random;
import android.graphics.*;
import android.view.*;
import java.io.*;
import android.net.*;


public class Maths_Graph extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private String[] fctList;
    private String var;
    private String lowerBound;
    private String upperBound;
    private double x;
    private double minX;
    private double maxX;
    private double y;
    private GraphView graph;
    public static final int STORAGE_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //We get back the information of the previous activity
        Intent intent = getIntent();
        fctList = intent.getStringArrayExtra("fct");
        var = intent.getStringExtra("variable");
        lowerBound = intent.getStringExtra("lower");
        upperBound = intent.getStringExtra("upper");

        //We create the parser with a call to the library JEP
        JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();

        //Creation of a new Graph
       graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>();

        //Define the number of data point we use to build the graph
        int numPoints = 100000;
        for (int j = 0; j < fctList.length -1; j++) {

            if (fctList[j]!=null &&!fctList[j].isEmpty()) {


                // returns double primitive
                minX = Double.parseDouble(lowerBound); //min x = lower bound define by user
                maxX = Double.parseDouble(upperBound);

                x=minX;

                series = new LineGraphSeries<>();

                for (int i = 0; i < numPoints; i++) {
                    while(x<maxX){
                    x = x + 0.1; //We increase the value of x of 0.1, to have a continue graph
                    myParser.addVariable(var, x);
                    //We parse each function(string) that the user entered
                    myParser.parseExpression(fctList[j]);
                    y = myParser.getValue();
                    // We add the point to the series
                    series.appendData(new DataPoint(x, y), true, 100000);

                }
                }
                //Now we add the series to the graph
                graph.addSeries(series);
                //Add a title to each function
               series.setTitle(fctList[j]);
                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                graph.getLegendRenderer().setBackgroundColor(Color.LTGRAY);

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
        graph.getViewport().setMinX(minX);
        graph.getViewport().setMaxX(maxX);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);







    }

    // Take a capture of the graph and share it
    public void takeSnap(View view){

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            // directly share it


            // get the bitmap
            Bitmap bitmap = graph.takeSnapshot();

            try {
                File file = new File(this.getExternalCacheDir(),"myImage.png");
                FileOutputStream fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG,80,fOut);
                fOut.flush();
                fOut.close();
                file.setReadable(true,false);
                //Sharinf intent
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(file));
                intent.setType("image/png");
                startActivity(Intent.createChooser(intent,"Share Image via"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            requestStoragePermission();
        }


    }

    // Permission necessary for the API above 23
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed to access to the gallery")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(Maths_Graph.this,
                                    new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }
}
