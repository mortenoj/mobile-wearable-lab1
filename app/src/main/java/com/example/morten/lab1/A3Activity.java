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

        addListenerOnButton();
    }

    private void addListenerOnButton() {


        Button button = findViewById(R.id.button_a3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText returnText = findViewById(R.id.textInput_a3);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", returnText.getText().toString());
                setResult(A2Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}