package com.Group7.formulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Three_d_page extends AppCompatActivity {

    private Button sph_btn;
    private Button con_btn;
    private Button cyl_btn;
    private Button cub_btn;
    private Button cui_btn;
    private Button fru_btn;
    private Button tet_btn;
    private Button ocz_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_d);



        sph_btn = (Button) findViewById(R.id.sph_btn);         //declaring buttons
        con_btn = (Button) findViewById(R.id.con_btn);
        cyl_btn = (Button) findViewById(R.id.cyl_btn);
        cub_btn = (Button) findViewById(R.id.cub_btn);
        cui_btn = (Button) findViewById(R.id.cui_btn);
        fru_btn = (Button) findViewById(R.id.fru_btn);
        tet_btn = (Button) findViewById(R.id.tet_btn);
        ocz_btn = (Button) findViewById(R.id.ocz_btn);


        sph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                opensph_btnPage();         //function for opening page
            }
        });

        con_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opencon_btnPage();   //function for opening page
            }

        });

        cyl_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opencyl_btnPage(); // function for opening page
            }
        });

        cub_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opencub_btnPage(); // function for opening page
            }
        });
        cui_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opencui_btnPage(); // function for opening page
            }
        });
        fru_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openfru_btnPage(); // function for opening page
            }
        });
        tet_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opentet_btnPage(); // function for opening page
            }
        });
        ocz_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openocz_btnPage(); // function for opening page
            }
        });

    }
    public void opensph_btnPage(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Sphere.class);
        startActivity(intent);
    }
    public void opencon_btnPage(){
        Intent intent = new Intent(this,Cone.class);
        startActivity(intent);
    }
    public void opencyl_btnPage(){
        Intent intent = new Intent(this,Cylinder.class);
        startActivity(intent);
    }
    public void opencub_btnPage(){
        Intent intent = new Intent(this,Cube.class);
        startActivity(intent);
    }
    public void opencui_btnPage(){
        Intent intent = new Intent(this,Cuboid.class);
        startActivity(intent);
    }
    public void openfru_btnPage(){
        Intent intent = new Intent(this,Frustum.class);
        startActivity(intent);
    }
    public void opentet_btnPage(){
        Intent intent = new Intent(this,Tetrahedron.class);
        startActivity(intent);
    }
    public void openocz_btnPage(){
        Intent intent = new Intent(this,Octahedron.class);
        startActivity(intent);
    }
}
