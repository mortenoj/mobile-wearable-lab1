package com.example.morten.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class A2Activity extends AppCompatActivity {

    // The request code for startActivityForResult
    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);

        // Get data from last activity via intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Get value from extras and set the value of text view
            final String value = bundle.getString("text_a1");
            TextView t2 = findViewById(R.id.textView1_a2);
            String output = "Hello " + value;
            t2.setText(output);
        }

        // Add event listener to button
        addListenerOnButton();

    }


    /**
     * addListenerOnButton starts new activity A3 with no extras but expects A3 to send data back
     * to onActivityResult.
     * **/
    private void addListenerOnButton() {


        Button button = findViewById(R.id.button_a2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // new Intent from A2 to A3
                Intent intent = new Intent(A2Activity.this, A3Activity.class);

                // Start activity expecting data in return
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    /**
     * onActivityResult method is called automatically when you go from A3 to A2
     * sets value of text view to the data it got from A3**/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK){
                // Get extra
                String result=data.getStringExtra("result");
                TextView t2 = findViewById(R.id.textView2_a2);
                String output = "From A3: " + result;
                // set value of t2 to From A3 + the data from A3
                t2.setText(output);
            }
        }
    }
}