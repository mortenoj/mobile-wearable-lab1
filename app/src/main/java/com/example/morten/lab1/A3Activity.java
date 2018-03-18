package com.example.morten.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class A3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3);

        // Add event listener to button
        addListenerOnButton();
    }


    /**
     * addListenerOnButton starts new activity A2 with the value from text view back
     * **/
    private void addListenerOnButton() {


        Button button = findViewById(R.id.button_a3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Find EditText by id
                EditText returnText = findViewById(R.id.textInput_a3);

                // New intent and puts extra
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", returnText.getText().toString());
                // Sets result
                setResult(A2Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}