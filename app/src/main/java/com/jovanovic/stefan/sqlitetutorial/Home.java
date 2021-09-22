package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button,add_button1,add_button2;
    ImageView empty_imageview;
    TextView no_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MainActivity2.class);
                startActivity(intent);



            }
        });















    }
}