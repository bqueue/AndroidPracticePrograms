package com.quockworks.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText operandOne;
    private EditText operandTwo;

    private Button buttonAddition;
    private Button buttonSubtraction;
    private Button buttonDivision;
    private Button buttonMultiplication;
    private Button buttonClear;

    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Declare Views
        operandOne = (EditText) findViewById(R.id.editOperandOne);
        operandTwo = (EditText) findViewById(R.id.editOperandTwo);

        buttonAddition = (Button) findViewById(R.id.btnPlus);
        buttonSubtraction = (Button) findViewById(R.id.btnMinus);
        buttonDivision = (Button) findViewById(R.id.btnDiv);
        buttonMultiplication = (Button) findViewById(R.id.btnMult);
        buttonClear = (Button) findViewById(R.id.btnClear);

        textResult = (TextView) findViewById(R.id.txtResult);


        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operandOne.getText().length() > 0 && operandTwo.getText().length() > 0 && !operandOne.getText().toString().equals(".") && !operandTwo.getText().toString().equals(".")){
                    double oper1 = Double.parseDouble(operandOne.getText().toString());
                    double oper2 = Double.parseDouble(operandTwo.getText().toString());
                    double result = oper1 + oper2;

                    textResult.setText(Double.toString(result));
                }
                else{
                    Toast.makeText(MainActivity.this,"Please enter numbers in both operand fields",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operandOne.getText().length() > 0 && operandTwo.getText().length() > 0 && !operandOne.getText().toString().equals(".") && !operandTwo.getText().toString().equals(".")){
                    double oper1 = Double.parseDouble(operandOne.getText().toString());
                    double oper2 = Double.parseDouble(operandTwo.getText().toString());
                    double result = oper1 - oper2;

                    textResult.setText(Double.toString(result));
                }
                else{
                    Toast.makeText(MainActivity.this,"Please enter numbers in both operand fields",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operandOne.getText().length() > 0 && operandTwo.getText().length() > 0 && !operandOne.getText().toString().equals(".") && !operandTwo.getText().toString().equals(".")){
                    double oper1 = Double.parseDouble(operandOne.getText().toString());
                    double oper2 = Double.parseDouble(operandTwo.getText().toString());
                    double result = oper1 / oper2;

                    textResult.setText(Double.toString(result));
                }
                else{
                    Toast.makeText(MainActivity.this,"Please enter numbers in both operand fields",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operandOne.getText().length() > 0 && operandTwo.getText().length() > 0 && !operandOne.getText().toString().equals(".") && !operandTwo.getText().toString().equals(".")){
                    double oper1 = Double.parseDouble(operandOne.getText().toString());
                    double oper2 = Double.parseDouble(operandTwo.getText().toString());
                    double result = oper1 * oper2;

                    textResult.setText(Double.toString(result));
                }
                else{
                    Toast.makeText(MainActivity.this,"Please enter numbers in both operand fields",Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operandOne.setText("");
                operandTwo.setText("");
                textResult.setText("0.00");
                operandOne.requestFocus();
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
