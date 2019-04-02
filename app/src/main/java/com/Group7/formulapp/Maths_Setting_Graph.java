package com.Group7.formulapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.*;


public class Maths_Setting_Graph extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Button okButton;
    private TextView fctTextInit;
    private TextView parentText;
    private TextView upperText;
    private TextView lowerText;
    private EditText lowerEditx;
    private EditText upperEditx;
    private EditText lowerEdity;
    private EditText upperEdity;
    private String upperx;
    private String lowerx;
    private String uppery;
    private String lowery;

    private TextView txt;
    private String[] fctList;
    private String var;
    private RelativeLayout mLayout;
    private int previous = 0;
    private Double dlowerx;
    private Double dupperx;
    private Double dlowery;
    private Double duppery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__setting__graph);

        //initialisation
        okButton = (Button) findViewById(R.id.ok_btn);
        mLayout = (RelativeLayout) findViewById(R.id.relative_setting);
        lowerEditx = (EditText) findViewById(R.id.lower_bound_x);
        upperEditx = (EditText) findViewById(R.id.upper_bound_x);
        lowerEdity = (EditText) findViewById(R.id.lower_bound_y);
        upperEdity = (EditText) findViewById(R.id.upper_bound_y);
        upperText = (TextView) findViewById(R.id.txt_upper_bound);
        lowerText = (TextView) findViewById(R.id.txt_lower_bound);
        txt = (TextView) findViewById(R.id.txt);


        //We gather the information of the previous activity
        Intent intent = getIntent();
        fctList = intent.getStringArrayExtra("fct");
        var = intent.getStringExtra("variable");

        for (int i = 0; i < fctList.length; i++) {
            if (fctList[i] != null) {
                if (i != 0) {
                    mLayout.addView(createNewTextView(i, fctList[i]));
                }
                mLayout.addView(createNewSpinner(i));


            }
        }
    }


    //Method to create a new TextView
    protected TextView createNewTextView(int i, String currentFct) {

        final TextView textView = new TextView(this);

        //we define an id for each new TextView
        textView.setId(i);


        //We need to move the upper and lower boundaries display according to the creation of new textView
        RelativeLayout.LayoutParams mLayout2 = (RelativeLayout.LayoutParams) lowerText.getLayoutParams();
        mLayout2.addRule(RelativeLayout.BELOW, textView.getId());
        RelativeLayout.LayoutParams mLayout3 = (RelativeLayout.LayoutParams) upperText.getLayoutParams();
        mLayout3.addRule(RelativeLayout.BELOW, textView.getId());


        //We create a new relative layout to be able to display the new text view above the others
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

        if (i == 1) {

            p.addRule(RelativeLayout.BELOW, txt.getId());

        } else {

            p.addRule(RelativeLayout.BELOW, parentText.getId());


        }
        int numFct = i + 1;

        textView.setText("Function" + i + currentFct);
        parentText = textView;
        textView.setLayoutParams(p);
        return textView;


    }

    protected Spinner createNewSpinner(int id) {

        Spinner spin = new Spinner(this);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        RelativeLayout.LayoutParams pbis = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);


        //Dropdown layoutstyle
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching  data adapter to spinner
        spin.setAdapter(dataAdapter);
        spin.setOnItemSelectedListener(this);

        if (id == 0) {


            pbis.addRule(RelativeLayout.ALIGN_BASELINE, txt.getId());
            pbis.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, txt.getId());
            previous = id;


        }

        if (id == 1) {
            pbis.addRule(RelativeLayout.BELOW, txt.getId());
            previous = id;
            pbis.addRule(RelativeLayout.RIGHT_OF, id);

        } else {

            pbis.addRule(RelativeLayout.BELOW, previous);
            previous = id;
            pbis.addRule(RelativeLayout.RIGHT_OF, id);

        }


        spin.setLayoutParams(pbis);

        return spin;

    }


    //Action to go to the Graph view
    protected void goToGraph(View view) {
        upperx = upperEditx.getText().toString();
        lowerx = lowerEditx.getText().toString();
        uppery = upperEdity.getText().toString();
        lowery = lowerEdity.getText().toString();

        Intent intent = new Intent(this, Maths_Graph.class);
        intent.putExtra("fct", fctList);
        intent.putExtra("variable", var);
        intent.putExtra("lowerx", lowerx);
        intent.putExtra("upperx", upperx);
        intent.putExtra("lowery", lowery);
        intent.putExtra("uppery", uppery);

        if (checkSetting(view, intent)) {

            startActivity(intent);
        }
    }


    //Check if all the information required are presents
    protected boolean checkSetting(final View view, Intent intent) {
        //The user must provide the upper and the lower bound

        if (lowerEditx.getText().toString().equals("")) {
            lowerEditx.setError("Required!");
            return false;

        }

        if (upperEditx.getText().toString().equals("")) {
            upperEditx.setError("Required!");
            return false;

        }
        //We need to check that upperboundarie is bigger than lowerboundarie otherwise its not going to work
        dlowerx = Double.valueOf(lowerx);
        dupperx = Double.valueOf(upperx);
        dlowery = Double.valueOf(lowery);
        duppery = Double.valueOf(uppery);

        if (!upperValid(dlowerx, dupperx)) {
            upperEditx.setError("Upper limit needs to be bigger than the lower limit");
            return false;
        }

        if (!upperValid(dlowery, duppery)) {
            upperEdity.setError("Upper limit needs to be bigger than the lower limit");
            return false;
        }

        return true;
    }


    public boolean upperValid(double lower, double upper) {

        return (lower < upper);
    }

    //For the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
// TODO Auto-generated method stub
    }
}
