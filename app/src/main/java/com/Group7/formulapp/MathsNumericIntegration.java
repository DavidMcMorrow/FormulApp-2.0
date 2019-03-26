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

    }

    protected void onIntegrate(){
        final JEP myParser = new JEP();
        myParser.addStandardFunctions();
        myParser.addStandardConstants();
        final String fct = "x^3 + 4*x^2+3*x";
        myParser.addVariable("x",0);
        myParser.parseExpression(fct);
        UnivariateFunction f = new UnivariateFunction() {
            @Override
            public double value(double x) {
                myParser.addVariable("x", x);
                double eval = myParser.getValue();
                return eval;
            }
        };
        RombergIntegrator solver = new RombergIntegrator();
        int iterations = 100;
        int attempts = 0;
        boolean converged = false;
        while (!converged) {
            try {
                double eval = solver.integrate(iterations, f, 0, 3);
                System.out.println("ESTIMATE: " + eval);
                converged = true;
            } catch (TooManyEvaluationsException e){
                if (attempts > 3) {
                    System.out.println("The integration didn't converge, make sure that the function is univariate and real");
                    System.out.println("ITERATIONS USED: " + iterations);
                    System.err.println(e);
                    System.exit(-1);
                }
                attempts +=1;
                //System.out.println(iterations + " iterations wasn't enough to find converging point");
                iterations *= 10;
                //System.out.println("Trying to find converging point with " + iterations + " of iterations");

            }
        }
    }
}
