package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DinamicActivity extends AppCompatActivity {
    Button button_t1;
    Button button_t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic);
        button_t1 = (Button) findViewById(R.id.termo1);
        button_t2 = (Button) findViewById(R.id.termo2);

        button_t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Dinamic2 = new Intent(DinamicActivity.this,DinamicActivity2.class);
                startActivity(Dinamic2);

            }
        });
        button_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent Dinamic3 = new Intent(DinamicActivity.this,DinamicActivity3.class);
                startActivity(Dinamic3);

            }
        });

    }


}