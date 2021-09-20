package com.jovanovic.stefan.droidcell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText pid,fname,dob,address,phone,trustee;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setContentView(R.layout.activity_add2);

        pid = findViewById(R.id.pid);
        fname = findViewById(R.id.fname);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        trustee= findViewById(R.id.trustee);
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
