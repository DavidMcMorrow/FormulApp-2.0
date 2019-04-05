package com.Group7.formulapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.kexanie.library.MathView;

import static org.apache.commons.math3.util.Precision.round;

public class Logs_page extends AppCompatActivity {
    EditText et_a, et_b, et_c;
    Button bt_go;
    TextView tv_result;
    MathView function2;
    String text;

    double a, b, c, d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs_page);
        et_a = (EditText) findViewById(R.id.et_a);
        et_b = (EditText) findViewById(R.id.et_b);
        et_c = (EditText) findViewById(R.id.et_c);
        bt_go = (Button) findViewById(R.id.bt_go);
        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!et_a.getText().toString().equals("") && !et_b.getText().toString().equals("") &&
                        !et_c.getText().toString().equals("")){
                    a = Double.parseDouble(et_a.getText().toString());
                    b = Double.parseDouble(et_b.getText().toString());
                    c = Double.parseDouble(et_c.getText().toString());

                    if(a == 999){
                        c = (1 / c);
                        a = (int) Math.pow(b,c);
                        tv_result.setText("a = "+ a);
                    }

                    else if(b == 999){
                        b = (int) Math.pow(a,c);

                        tv_result.setText("b = " + b);
                    }
                    else if(c == 999){
                        c = (int) (Math.log(b) / Math.log(a));
                        tv_result.setText("c = " + c );
                    }
                }
            }
        });


    }
}
