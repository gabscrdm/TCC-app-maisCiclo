package com.example.maisciclo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddCartao extends AppCompatActivity {

    private Button btEnviarCartao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_cartao);

        btEnviarCartao = findViewById(R.id.btEnviarCart);
        btEnviarCartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Carteira.class));
            }
        });

    }
}