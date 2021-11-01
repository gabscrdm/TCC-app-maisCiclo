package com.example.maisciclo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.google.android.material.internal.NavigationMenu;

public class Estacao extends AppCompatActivity {

    private Button mBairro1, mBairro2, mBairro3, mBairro4, mBairro5;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_estacao);

        mBairro1 = findViewById(R.id.btBairro1);
        mBairro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Bairro1.class));
            }
        });

        mBairro2 = findViewById(R.id.btBairro2);
        mBairro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Bairro2.class));
            }
        });

        mBairro3 = findViewById(R.id.btBairro3);
        mBairro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Bairro3.class));
            }
        });
    }
}
