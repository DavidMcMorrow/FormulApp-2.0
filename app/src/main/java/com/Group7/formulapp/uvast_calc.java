package com.Group7.formulapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class uvast_calc extends AppCompatActivity {
    EditText et_u,et_v,et_a,et_s,et_t;
    Button bt_go,clr;
    TextView tv_result01;
    TextView tv_result02;
    TextView tv_result03;

    double u,vel,a,s,t;
    char req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uvast);

        et_u = (EditText) findViewById(R.id.et_u);
        et_v = (EditText) findViewById(R.id.et_v);
        et_a = (EditText) findViewById(R.id.et_a);
        et_s = (EditText) findViewById(R.id.et_s);
        et_t = (EditText) findViewById(R.id.et_t);
        bt_go = (Button) findViewById(R.id.bt_go);
        tv_result01 = (TextView) findViewById(R.id.tv_result01);
        tv_result02 = (TextView) findViewById(R.id.tv_result02);
        tv_result03 = (TextView) findViewById(R.id.tv_result03);



        bt_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!et_u.getText().toString().equals("") && !et_v.getText().toString().equals("") &&
                        !et_a.getText().toString().equals("") &&
                        !et_s.getText().toString().equals("")&&
                        !et_t.getText().toString().equals("")){
                    u= Double.parseDouble(et_u.getText().toString());
                    vel= Double.parseDouble(et_v.getText().toString());
                    a= Double.parseDouble(et_a.getText().toString());
                    s= Double.parseDouble(et_s.getText().toString());
                    t= Double.parseDouble(et_t.getText().toString());

                }
                    //tv_result.setText("You entered"+"\n u=" + u + " v=" + vel + " a=" + a+ " s=" + s + " t=" + t);
                    if(u == -999){
                        req = 'u';
                    } else if (vel == -999){
                        req = 'v';
                    } else if (a == -999){
                        req = 'a';
                    } else if (s == -999){
                        req = 's';
                    } else if (t == -999){
                        req = 't';
                    }
                    //now req has the value required

                    //v = a + at
                if(req == 'v' && u != -999 && a != -999 && t != -999){
                    vel = u + (a*t);
                    tv_result01.setText("\nUsing formula 'v = u + at'"+"\n v=" + vel);
                } else if (req == 'u' && vel != -999 && a != -999 && t != -999){
                    u = (a*t) - vel;
                    tv_result01.setText("\nUsing formula 'v = u + at'"+"\n u=" + u);
                } else if (req == 'a' && u != -999 && vel != -999 && t != -999){
                    a = (vel-u)/t;
                    tv_result01.setText("\nUsing formula 'v = u + at'"+"\n a=" + a);
                } else if(req == 't' && u != -999 && a != -999 && vel != -999){
                    t = (vel-u)/a;
                    tv_result01.setText("\nUsing formula 'v = u + at'"+"\n t=" + t);
                }

                //s=ut+ 1/2at^2
                if(req == 's' && u != -999 && t != -999 && a != -999){
                    s = (u*t) + (0.5*a*(t*t));
                    tv_result02.setText("\nUsing formula 's = ut + 1/2 at^2'"+"\n s=" + s);
                } else if (req == 'u' && s != -999 && t != -999 && a != -999){
                    u = -(0.5*a*t) + (s/t);
                    tv_result02.setText("\nUsing formula 's = ut + 1/2 at^2'"+"\n u=" + u);
                } else if (req == 'a' && s != -999 && t != -999 && u != -999){
                    a = ((2*s)/(t*t)) - ((2*u)/t);
                    tv_result02.setText("\nUsing formula 's = ut + 1/2 at^2'"+"\n a=" + a);
                }

                //v2 = u2 + 2as
                if (req == 'v' && u != -999 && a != -999 && s != -999){
                    vel = Math.sqrt((u*u) + 2*a*s);
                    tv_result03.setText("\nUsing formula 'v2 = u2 + 2as'"+"\n v=" + vel);
                } else if (req == 'u' && vel != -999 && a != -999 && s != -999){
                    u = Math.sqrt((2*a*s) - (vel*vel));
                    tv_result03.setText("\nUsing formula 'v2 = u2 + 2as'"+"\n u=" + u);
                } else if (req == 'a' && vel != -999 && u != -999 && s != -999){
                    a = ((vel*vel) - (u*u))/(2*s);
                    tv_result03.setText("\nUsing formula 'v2 = u2 + 2as'"+"\n a=" + a);
                } else if (req == 's' && vel != -999 && u != -999 && a != -999){
                    s = ((vel*vel) - (u*u))/(2*a);
                    tv_result03.setText("\nUsing formula 'v2 = u2 + 2as'"+"\n s=" + s);
                }
            }
        });



    }
}
