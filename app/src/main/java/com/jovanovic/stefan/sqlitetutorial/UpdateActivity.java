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

    EditText pid_input, preid_input,doc_input,name_input,address_input,contact_input, nic_input;
    Button update_button, delete_button;

    String id,pid, preid,doc,name,address,contact, nic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        pid_input = findViewById(R.id.pid_input2);
        preid_input = findViewById(R.id.preid_input2);
        doc_input = findViewById(R.id.doc_input2);
        name_input = findViewById(R.id.name_input2);

        address_input = findViewById(R.id.address_input2);
        contact_input = findViewById(R.id.contact_input2);

        nic_input = findViewById(R.id.nic_input2);
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
                preid = preid_input.getText().toString().trim();
                doc = doc_input.getText().toString().trim();
                name = name_input.getText().toString().trim();
                address = address_input.getText().toString().trim();
                contact = contact_input.getText().toString().trim();

                nic = nic_input.getText().toString().trim();
                myDB.updateData(id, pid, preid, doc,name,address,contact,nic);
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
        if(getIntent().hasExtra("id") && getIntent().hasExtra("pid") &&
                getIntent().hasExtra("preid") &&
                getIntent().hasExtra("doc") &&
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("address") &&
                getIntent().hasExtra("contact") &&
                getIntent().hasExtra("nic")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            pid = getIntent().getStringExtra("pid");
            preid = getIntent().getStringExtra("preid");
            doc = getIntent().getStringExtra("doc");
            name = getIntent().getStringExtra("name");
            address= getIntent().getStringExtra("address");
            contact = getIntent().getStringExtra("contact");
            nic = getIntent().getStringExtra("nic");
            //Setting Intent Data
            pid_input.setText(pid);
            preid_input.setText(preid);
            doc_input.setText(doc);
            name_input.setText(name);
            address_input.setText(address);
            contact_input.setText(contact);
            nic_input.setText(nic);
            Log.d("stev", pid+" "+preid+" "+doc+""+name+""+address+""+contact+""+ nic);
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
