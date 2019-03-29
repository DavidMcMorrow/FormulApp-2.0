package com.Group7.formulapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.ActionBar.*;



import io.github.kexanie.library.MathView;


public class Maths_Function extends AppCompatActivity {

    protected String fct;
    private  String[] fctList;
    private MathView formula;
    private RelativeLayout mLayout;
    private Button submitButton;
    private Button newFctButton;
    private EditText currentEdit;
    private EditText parentEdit;
    private int nbFct;

   /* String tex = "This come from string. You can insert inline formula:" +
            " $$cos^2$$ " + "test" +
            "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths__function);

        //initialisation
        submitButton = (Button) findViewById(R.id.submit_fct);
        newFctButton = (Button) findViewById(R.id.new_fct);
        mLayout = (RelativeLayout) findViewById(R.id.relative);
        currentEdit = (EditText) findViewById(R.id.init_fct);
        formula = (MathView) findViewById(R.id.formula);
        nbFct = 0;
        fctList=new String[100];

        //Action when we click on the submit button : display the Math View of the fct
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                formula.setText("$$" + currentEdit.getText().toString() + "$$");
                fct = currentEdit.getText().toString();


            }
        });

        //Action when we click ont the button new function : add a new EditText
        newFctButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nbFct++;
                mLayout.addView(createNewEditText(nbFct));
                String nameCurrent = "" + nbFct;
                //We change the current EditText
                currentEdit = (EditText)findViewById(getResources().getIdentifier(nameCurrent, "id", getPackageName()));


            }
        });
    }

    //Method to create a new EditText
    protected EditText createNewEditText(int i) {
        final EditText editText = new EditText(this);

        //we define an id for each new Edit Text
        editText.setId(i);
        editText.setHint("Enter your function");

       //We need to move the submit fct according to the creation of new editText
        RelativeLayout.LayoutParams mLayout2=(RelativeLayout.LayoutParams)submitButton.getLayoutParams();
        mLayout2.addRule(RelativeLayout.BELOW,editText.getId());


        //We create a new relative layout to be able to display the new edit text below the others
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        if(i==1 || i==0){
        p.addRule(RelativeLayout.BELOW, R.id.init_fct);


        }
        else{
            int previous = i--;
            String name = "" + i;
            parentEdit = (EditText)findViewById(getResources().getIdentifier(name, "id", getPackageName()));
            p.addRule(RelativeLayout.BELOW,  parentEdit.getId());
        }

        editText.setLayoutParams(p);

        return editText;


    }


    //Action to go to the Graph view
    protected void goToGraph(View view) {
        EditText et;

            ViewGroup editTextsContainer = (ViewGroup) findViewById(R.id.relative);
            int sum = 0;
            int i = editTextsContainer.getChildCount();
            int countTab =0;

            for(int j=0;j<i;j++) { // Parcours des fils
                View child = editTextsContainer.getChildAt(j); // We gather all the child of the view
                if(child instanceof EditText) { // if its an editText, we collect his contents and add it into the array
                   fctList[countTab]= ((EditText) child).getText().toString();
                   countTab++;
                    //currentEdit.setText(fctList[j] + currentEdit.getText().toString() );

                }
            }


        Intent intent = new Intent(this, Maths_Graph.class);
        intent.putExtra("fct", fctList);

        startActivity(intent);
    }
}




