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

        // Adds event listener on spinner
        addListenerOnSpinner();

        // Adds event listener on button
        addListenerOnButton();
    }


    /**
     * addListenerOnSpinner
     * Function for setting values to drop-down from xml file and adds event listener on
     * the click of the selected item. Also saves and fetches the choice to shared prefs
     **/
    private void addListenerOnSpinner() {

        Spinner spinner = findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Get users choice from shared preferences
        getUserPreference();

        // Sets event listener on dropdown menus item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // Shared preferences
                SharedPreferences sharedPref = getSharedPreferences("FileName",0);

                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("userChoiceSpinner", position);
                prefEditor.apply();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    /**
     * getUserPreference gets value from shared prefs, specifically the users choice
     * in the dropdown menu as a position and sets the selected to the correct value
     **/
    private void getUserPreference() {
        Spinner spinner = findViewById(R.id.spinner);

        SharedPreferences sharedPref = getSharedPreferences("FileName",MODE_PRIVATE);
        int spinnerValue = sharedPref.getInt("userChoiceSpinner",-1);
        if(spinnerValue != -1) {
            // set the selected value of the spinner
            spinner.setSelection(spinnerValue);
        }
    }

    /**
     * addListenerOnButton adds event listener on button.
     * when button is clicked it starts a new activity with a new intent from A1 to A2
     * **/
    private void addListenerOnButton() {
        // Finds button by id
        Button button = findViewById(R.id.button_a1);
        // Sets event listener
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text_a1 = findViewById(R.id.textInput_a1);

                // Create Intent and put text from a1 as extra
                Intent intent = new Intent(A1Activity.this, A2Activity.class);
                intent.putExtra("text_a1", text_a1.getText().toString());
                // Starts activity with intent
                startActivity(intent);
            }
        });
    }

}