package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText doctor_input, specialization_input, patient_input, pid_input, email_input, channel_input, disease_input;
    Button update_button, delete_button;

    String id, doctor, specialization , patient, pid, email, channel, disease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        doctor_input = findViewById(R.id.doctor_input2);
        specialization_input = findViewById(R.id.specialization_input2);
        patient_input = findViewById(R.id.patient_input2);
        pid_input=findViewById(R.id.pid_input2);
        email_input=findViewById(R.id.email_input2);
        channel_input=findViewById(R.id.channel_input2);
        disease_input=findViewById(R.id.disease_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(doctor);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                doctor = doctor_input.getText().toString().trim();
                specialization = specialization_input.getText().toString().trim();
                patient = patient_input.getText().toString().trim();
                pid = pid_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                channel = channel_input.getText().toString().trim();
                disease = disease_input.getText().toString().trim();
                myDB.updateData(id, doctor, specialization, patient, pid, email, channel, disease);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("doctor") &&
                getIntent().hasExtra("specialization") && getIntent().hasExtra("patient") &&
                getIntent().hasExtra("pid") && getIntent().hasExtra("email")
                && getIntent().hasExtra("channel") && getIntent().hasExtra("disease")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            doctor = getIntent().getStringExtra("doctor");
            specialization = getIntent().getStringExtra("specialization");
            patient = getIntent().getStringExtra("patient");
            pid = getIntent().getStringExtra("pid");
            email = getIntent().getStringExtra("email");
            channel = getIntent().getStringExtra("channel");
            disease= getIntent().getStringExtra("disease");

            //Setting Intent Data
            doctor_input.setText(doctor);
            specialization_input.setText(specialization);
            patient_input.setText(patient);
            pid_input.setText(pid);
            email_input.setText(email);
            channel_input.setText(channel);
            disease_input.setText(disease);
            Log.d("stev", doctor+" "+specialization+" "+patient+" "+pid+" "+email+" "+channel+" "+disease);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + doctor + " ?");
        builder.setMessage("Are you sure you want to delete " + doctor + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
