package com.example.maisciclo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Aluguel extends AppCompatActivity {

    public Button mFormaPgto, mReport, mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aluguel);

        mFormaPgto = (Button)findViewById(R.id.btCarteiraAluguel);

        mFormaPgto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Carteira.class));
            }
        });

        mReport = (Button)findViewById(R.id.btReport);

        mReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Report.class));
            }
        });

    }
}