package com.segurityapp.igom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Class_Login extends AppCompatActivity {

    public void indoParaDeCadastro(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Cadastrar.class);
        startActivity(intentl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class__login);

    }
}
