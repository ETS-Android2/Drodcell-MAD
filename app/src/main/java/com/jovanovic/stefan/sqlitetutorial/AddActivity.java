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

        doctor_input = findViewById(R.id.doctor_input2);
        specialization_input = findViewById(R.id.specialization_input2);
        patient_input = findViewById(R.id.patient_input2);
        pid_input=findViewById(R.id.pid_input2);
        email_input=findViewById(R.id.email_input2);
        channel_input=findViewById(R.id.channel_input2));
        disease_input=findViewById(R.id.disease_input2);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));
            }
        });
    }
}
