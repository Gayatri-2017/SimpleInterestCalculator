package com.example.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etPrincipal, etRate, etYears;
    TextView tvPrincipal, tvRate, tvYears, tvInterest;
    Button bCalculate;
    double mPrincipal, mRate, mYears, mInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrincipal = (EditText)findViewById(R.id.et_principal);
        etRate = (EditText)findViewById(R.id.et_rate);
        etYears = (EditText)findViewById(R.id.et_years);

        tvPrincipal = (TextView)findViewById(R.id.tv_principal);
        tvRate = (TextView)findViewById(R.id.tv_rate);
        tvYears = (TextView)findViewById(R.id.tv_years);
        tvInterest = (TextView)findViewById(R.id.tv_interest);

        bCalculate = (Button)findViewById(R.id.b_calculate);

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etPrincipal.length()==0){
                    etPrincipal.requestFocus();
                    etPrincipal.setError("Principal amount cannot be empty!");
                }
                else if(etRate.length()==0){
                    etRate.requestFocus();
                    etRate.setError("Rate of Interest cannot be empty!");
                }
                else if(etYears.length()==0){
                    etYears.requestFocus();
                    etYears.setError("Number of years cannot be empty!");
                }
                else
                {
                    mPrincipal = Double.parseDouble(etPrincipal.getText().toString());
                    mRate = Double.parseDouble(etRate.getText().toString());
                    mYears = Double.parseDouble(etYears.getText().toString());

                    mInterest = 0.01 * mPrincipal * mRate * mYears;

                    tvInterest.setText("The interest for Rs " + mPrincipal + " at a rate of " + mRate + "% for " + mYears + " Years(s) is Rs " + mInterest);
                }

            }
        });


    }
}
