package com.example.morten.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class A2Activity extends AppCompatActivity {
    static final int REQUEST_CODE = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            final String value = bundle.getString("text_a1");
            TextView t2 = findViewById(R.id.textView1_a2);
            String output = "Hello " + value;
            t2.setText(output);
        }

        addListenerOnButton();

    }

    private void addListenerOnButton() {


        Button button = findViewById(R.id.button_a2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(A2Activity.this, A3Activity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("result");
                TextView t2 = findViewById(R.id.textView2_a2);
                String output = "From A3: " + result;
                t2.setText(output);
            }
        }
    }
}