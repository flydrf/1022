package com.example.mcalcpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ca.roumani.i2c.MPro;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked (View v){
        EditText pBox=(EditText) findViewById(R.id.pBox);
        String p=pBox.getText().toString();
        EditText aBox=(EditText) findViewById(R.id.aBox);
        String a=aBox.getText().toString();
        EditText iBox=(EditText) findViewById(R.id.iBox);
        String i=iBox.getText().toString();
        try{
            MPro mp=new MPro();
            mp.setPrinciple(p);
            mp.setAmortization(a);
            mp.setInterest(i);

            String output = "Monthly Payment = " + mp.computePayment("%,.2f");
            output +="\n\n";
            output +="By making this payments monthly for " + a + " years, the mortgage will be paid in full. " +
                    "But if you terminate the mortgage on its nth anniversary, the balance still owing depends on n as shown below:";
            output +="\n\n" + "\n\n";
            output +=String.format("%8s","n") + String.format("%16s","Balance");
            output +="\n\n";
            output += String.format("%8d", 0) + mp.outstandingAfter(0,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 1) + mp.outstandingAfter(1,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 2) + mp.outstandingAfter(2,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 3) + mp.outstandingAfter(3,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 4) + mp.outstandingAfter(4,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 5) + mp.outstandingAfter(5,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 10) + mp.outstandingAfter(10,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 15) + mp.outstandingAfter(15,"%,16.0f");
            output +="\n\n";
            output += String.format("%8d", 20) + mp.outstandingAfter(20,"%,16.0f");

            ((TextView) findViewById(R.id.output)).setText(output);
        }

        catch(Exception e){
            Toast label = Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
            label.show();
        }

    }
}
