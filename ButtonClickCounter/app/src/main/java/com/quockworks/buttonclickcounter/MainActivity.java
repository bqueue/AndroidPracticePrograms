package com.quockworks.buttonclickcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Create objects corresponding to views added to content_main.xml
    private Button myButton;
    private TextView myMessage;

    // Counter for the number of taps on the button, initialized at 0
    private int numTaps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Instantiate button and textView
        myButton = (Button) findViewById(R.id.button);
        myMessage = (TextView) findViewById(R.id.textView);

        // Create and set OnClickListener for the button
        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                numTaps++;
                setMessage();
            }
        };
        myButton.setOnClickListener(myClickListener);

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
            Toast toastMessage = Toast.makeText(this,"Settings menu tapped! Button taps reset!",Toast.LENGTH_LONG);
            toastMessage.show();
            numTaps = 0;
            setMessage();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setMessage(){
        String result = "Button tapped: " + numTaps + " time";
        if(numTaps != 1){
            result += "s";
        }
        myMessage.setText(result);
    }
}
