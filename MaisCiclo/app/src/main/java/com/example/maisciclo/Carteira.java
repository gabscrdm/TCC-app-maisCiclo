package com.example.maisciclo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Carteira extends AppCompatActivity {
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    public Button mVoltar, mPix, btAdd, btApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_carteira);

        mPix = findViewById(R.id.btRecarga);
        mPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Carteira.this);
                builder.setTitle("CHAVE PIX");
                builder.setMessage(R.string.pix)
                        .setPositiveButton(R.string.copy, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                builder.show();
            }
        });

        radioGroup = findViewById(R.id.radioGroup);

        btAdd = findViewById(R.id.btNovoPgto);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddCartao.class));
            }
        });

        btApply = findViewById(R.id.btApply);
        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
            }
        });

    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selecionado: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}