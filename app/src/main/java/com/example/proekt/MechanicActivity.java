package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MechanicActivity extends AppCompatActivity {
    Button button_m1;
    Button button_m2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);
        button_m1 = (Button) findViewById(R.id.mehanic1);
        button_m2 = (Button) findViewById(R.id.mehanic2);

        button_m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mehanic2 = new Intent(MechanicActivity.this,MehanicActivity2.class);
                startActivity(Mehanic2);

            }
        });
        button_m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mehanic3 = new Intent(MechanicActivity.this,MehanicActivity3.class);
                startActivity(Mehanic3);
            }
        });
    }


}