package com.example.maisciclo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Report extends AppCompatActivity {

    public Button btnEmail;
    public EditText edtMensagem;
    public TextView txEmailContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_report);

        txEmailContato = (TextView)findViewById(R.id.txEmailContato);
        edtMensagem = (EditText)findViewById(R.id.edtCaixaReport);


        btnEmail = (Button)findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    private void sendMail() {

        String mail = txEmailContato.getText().toString().trim();
        String message = edtMensagem.getText().toString().trim();

        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail, message);

        javaMailAPI.execute();
    }
}