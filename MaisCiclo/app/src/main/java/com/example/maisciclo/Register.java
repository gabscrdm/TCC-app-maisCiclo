package com.example.maisciclo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;


public class Register extends AppCompatActivity {


    private EditText mNome, mEmailRegister, mPasswordRegister, mPasswordConfirm, mRG, mCPF, mCidade, mCEP, mEnder, mEndNum;
    private Button mEnviar, mEnviaComprov, mCadastroVoltar;
    private FirebaseAuth fAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNome = findViewById(R.id.edtNome);
        mEmailRegister = findViewById(R.id.edtEmail);
        mPasswordRegister = findViewById(R.id.edtSenhaCad);
        mPasswordConfirm = findViewById(R.id.edtSenhaConfirm);
        mRG = findViewById(R.id.edtRG);
        mCPF = findViewById(R.id.edtCPF);
        mCidade = findViewById(R.id.edtCidade);
        mCEP = findViewById(R.id.edtCEP);
        mEnder = findViewById(R.id.edtEnder);
        mEndNum = findViewById(R.id.edtEndNum);

        mEnviar = findViewById(R.id.btEnviaCadastro);

        fAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.useEmulator("10.0.2.2", 9000);

        progressBar = findViewById(R.id.pbRegister);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        mEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailRegister.getText().toString().trim();
                String senha = mPasswordRegister.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmailRegister.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(senha)) {
                    mPasswordRegister.setError("Password is Required.");
                    return;
                }

                if (senha.length() < 5) {
                    mPasswordRegister.setError("Senha precisa ter mais que 5 caracteres.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // register the user in FIREBASE
                fAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(Register.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Cadastrado.");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        
    }
}