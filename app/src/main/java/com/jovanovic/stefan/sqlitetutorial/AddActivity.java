package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText doctor_input, specialization_input, patient_input, pid_input, email_input, channel_input, disease_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        doctor_input = findViewById(R.id.doctor_input);
        specialization_input = findViewById(R.id.specialization_input);
        patient_input = findViewById(R.id.patient_input);
        pid_input=findViewById(R.id.pid_input);
        email_input=findViewById(R.id.email_input);
        channel_input=findViewById(R.id.channel_input);
        disease_input=findViewById(R.id.disease_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook( doctor_input.getText().toString().trim(),
                        specialization_input.getText().toString().trim(),
                        patient_input.getText().toString().trim(),
                        pid_input.getText().toString().trim(),
                        email_input.getText().toString().trim(),
                        channel_input.getText().toString().trim(),
                        disease_input.getText().toString().trim(),;
            }
        });
    }
}















