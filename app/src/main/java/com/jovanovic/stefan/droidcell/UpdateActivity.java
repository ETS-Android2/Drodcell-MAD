package com.jovanovic.stefan.droidcell;

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

    EditText pid_input,fname_input,dob_input,address_input,phone_input,trustee_input;
    Button update_button, delete_button;

    String id,pid,fname,dob,address,phone,trustee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        pid_input = findViewById(R.id.pid_input2);
        fname_input = findViewById(R.id.fname_input2);
        dob_input = findViewById(R.id.dob_input2);
        address_input = findViewById(R.id.address_input2);
        phone_input = findViewById(R.id.phone_input2);
        trustee_input = findViewById(R.id.trustee_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(pid);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                pid = pid_input.getText().toString().trim();
                fname = fname_input.getText().toString().trim();
                dob = dob_input.getText().toString().trim();
                address = address_input.getText().toString().trim();
                phone = phone_input.getText().toString().trim();
                trustee = trustee_input.getText().toString().trim();
                myDB.updateData(id,pid,fname,dob,address,phone,trustee);
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
        if(getIntent().hasExtra("id") && getIntent().hasExtra("fname") &&
                getIntent().hasExtra("dob") && getIntent().hasExtra("address") &&
                getIntent().hasExtra("phone")&& getIntent().hasExtra("trustee") ){
            //Getting Data from Intent
            pid = getIntent().getStringExtra("pid");
            fname= getIntent().getStringExtra("fname");
            dob = getIntent().getStringExtra("dob");
            address = getIntent().getStringExtra("address");
            phone = getIntent().getStringExtra("phone");
            trustee = getIntent().getStringExtra("trustee");

            //Setting Intent Data
            pid_input.setText(pid);
            fname_input.setText(fname);
            dob_input.setText(dob);
            address_input.setText(address);
            phone_input.setText(phone);
            trustee_input.setText(trustee);
            Log.d("stev", pid+" "+fname+" "+dob+" "+address+""+phone+""+trustee);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + pid + " ?");
        builder.setMessage("Are you sure you want to delete " + pid + " ?");
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
