package com.Group7.formulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class units_page extends AppCompatActivity {

    private Button Base_units_btn;
    private Button SI_units_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units_page);

        Base_units_btn   =  (Button) findViewById(R.id.Base_units_btn);         //declaring buttons
        SI_units_btn = (Button) findViewById(R.id.SI_units_btn);

        Base_units_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openBaseUnits_page();         //function for opening page
            }
        });
        SI_units_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openSIUnits_page();         //function for opening page
            }
        });

    }

    public void openBaseUnits_page(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,Base_Units_page.class);
        startActivity(intent);
    }

    public void openSIUnits_page(){         //Not really sure how this work will have to look into it
        Intent intent = new Intent(this,SI_Units_page.class);
        startActivity(intent);
    }
}
