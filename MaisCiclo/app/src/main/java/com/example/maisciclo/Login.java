package com.example.maisciclo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText mEmail, mSenha;
    private Button mCadastre, mLogin;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.edtEmail);
        mSenha = findViewById(R.id.edtSenha);
        mLogin = findViewById(R.id.btLogin);
        mCadastre = findViewById(R.id.btCadastro);

        mCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = mEmail.getText().toString();
                String loginSenha = mSenha.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)){
                    mAuth.signInWithEmailAndPassword(loginEmail,loginSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(Login.this, ""+error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

}