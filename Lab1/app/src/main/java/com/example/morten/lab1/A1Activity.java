package com.example.morten.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;

public class A1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);

        addListenerOnSpinner();

        addListenerOnButton();
    }

    private void addListenerOnSpinner() {

        Spinner spinner = findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        getUserPreference();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                SharedPreferences sharedPref = getSharedPreferences("FileName",0);

                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("userChoiceSpinner", position);
                prefEditor.apply();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void getUserPreference() {
        Spinner spinner = findViewById(R.id.spinner);

        SharedPreferences sharedPref = getSharedPreferences("FileName",MODE_PRIVATE);
        int spinnerValue = sharedPref.getInt("userChoiceSpinner",-1);
        if(spinnerValue != -1) {
            // set the selected value of the spinner
            spinner.setSelection(spinnerValue);
        }
    }

    private void addListenerOnButton() {


        Button button = findViewById(R.id.button_a1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text_a1 = findViewById(R.id.textInput_a1);

                Intent intent = new Intent(A1Activity.this, A2Activity.class);
                intent.putExtra("text_a1", text_a1.getText().toString());
                startActivity(intent);
            }
        });
    }

}