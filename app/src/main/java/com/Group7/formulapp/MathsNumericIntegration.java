package com.Group7.formulapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.RombergIntegrator;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.nfunk.jep.JEP;


public class MathsNumericIntegration extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO make lay out and integrate it with onIntegrate

    }

    protected void onIntegrate(){
        //initialize jep parser
        final JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();
        //TODO get the string from user input, atm it's a dummy
        final String fct = "x^3 + 4*x^2+3*x";
        //parse function for fast evaluation
        myParser.addVariable("x",0);
        myParser.parseExpression(fct);
        //Initialize Univariate function to pass to the integrator
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double x) {
                // this implements the value() function of the UnivariateFunction interface
                myParser.addVariable("x", x);
                double eval = myParser.getValue();
                return eval;
            }
        };
        //initialize integrator, using Romberg integrator since it seemed the quickest to converge
        RombergIntegrator solver = new RombergIntegrator();
        // amount of initial iterations
        int iterations = 100;
        // check how many attempts have been made
        int attempts = 0;
        // tag
        boolean converged = false;
        while (!converged) {
            try {
                //TODO get bounds from user input
                double eval = solver.integrate(iterations, f, 0, 3);
                //TODO put answer in appropriate text box
                System.out.println("ESTIMATE: " + eval);
                converged = true;
            } catch (TooManyEvaluationsException e){
                //Error handling for when the function passed doesn't converge
                if (attempts > 3) {
                    //TODO pass on the resulting ERROR in an appropriate way to the user
                    System.out.println("The integration didn't converge, make sure that the function is univariate and real");
                    System.out.println("ITERATIONS USED: " + iterations);
                    System.err.println(e);
                    System.exit(-1);
                }
                // If the number of attempts doesn't exceed max, multiply iterations by 10 and try again
                attempts +=1;
                //System.out.println(iterations + " iterations wasn't enough to find converging point");
                iterations *= 10;
                //System.out.println("Trying to find converging point with " + iterations + " of iterations");
            }
        }
    }
}
