package com.jovanovic.stefan.droidcell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText pid_input,fname_input,dob_input,address_input,phone_input,trustee_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        pid_input = findViewById(R.id.pid_input);
        fname_input = findViewById(R.id.fname_input);
        dob_input = findViewById(R.id.dob_input);
        address_input = findViewById(R.id.address_input);
        phone_input = findViewById(R.id.phone_input);
        trustee_input= findViewById(R.id.trustee_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(pid_input.getText().toString().trim(),
                        fname_input.getText().toString().trim(),
                        dob_input.getText().toString().trim(),
                        address_input.getText().toString().trim(),
                        Integer.valueOf(phone_input.getText().toString().trim()),
                                trustee_input.getText().toString().trim());
            }
        });
    }
}
