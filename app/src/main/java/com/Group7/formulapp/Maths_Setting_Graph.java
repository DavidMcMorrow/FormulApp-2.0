package com.Group7.formulapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.*;

public class Maths_Setting_Graph extends AppCompatActivity {

    private Button okButton;
    private TextView parentText;
    private EditText lowerEdit;
    private EditText upperEdit;
    private String[] fctList;
    private String var;
    private RelativeLayout mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__setting__graph);

        //initialisation
        okButton = (Button) findViewById(R.id.ok_btn);
        mLayout = (RelativeLayout) findViewById(R.id.relative_setting);
        lowerEdit = (EditText) findViewById(R.id.lower_bound);
        upperEdit = (EditText) findViewById(R.id.upper_bound);


        //We gather the information of the previous activity
        Intent intent = getIntent();
        fctList = intent.getStringArrayExtra("fct");
        var = intent.getStringExtra("variable");

        for (int i = 0; i < fctList.length; i++) {
            if (fctList[i] != null) {

                // mLayout.addView(createNewTextView(i,fctList[i]));
            }
        }
    }


    //Method to create a new TextView
    protected TextView createNewTextView(int i, String current) {

        final TextView textView = new TextView(this);

        //we define an id for each new TextView
        textView.setId(i);


        //We need to move the 'ok' fct according to the creation of new textView
        RelativeLayout.LayoutParams mLayout2 = (RelativeLayout.LayoutParams) okButton.getLayoutParams();
        mLayout2.addRule(RelativeLayout.BELOW, textView.getId());


        //We create a new relative layout to be able to display the new text view above the others
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        if (i == 0) {
            p.addRule(RelativeLayout.BELOW, R.id.upper_bound);
            String name = "fct" + i;
            parentText = (TextView) findViewById(getResources().getIdentifier(name, "id", getPackageName()));

        } else {

            String name = "fct" + i;
            parentText = (TextView) findViewById(getResources().getIdentifier(name, "id", getPackageName()));
            p.addRule(RelativeLayout.BELOW, parentText.getId());

        }

        textView.setText(current);
        textView.setLayoutParams(p);

        return textView;


    }


    //Action to go to the Graph view
    protected void goToGraph(View view) {

        Intent intent = new Intent(this, Maths_Graph.class);
        intent.putExtra("fct", fctList);
        intent.putExtra("variable", var);
        intent.putExtra("upper", upperEdit.getText().toString());
        intent.putExtra("lower", lowerEdit.getText().toString());

        if (checkSetting(view, intent)) {

            startActivity(intent);
        }
    }


    //Check if all the information required are presents
    protected boolean checkSetting(final View view, Intent intent) {
        //The user must provide the upper and the lower bound

        if (lowerEdit.getText().toString().equals("")) {
            lowerEdit.setError("Required!");
            return false;

        }

        if (upperEdit.getText().toString().equals("")) {
            upperEdit.setError("Required!");
            return false;

        }
        return true;
    }
}
