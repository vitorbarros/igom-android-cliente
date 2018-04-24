package com.segurityapp.igom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Class_Esqueceu_Senha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class__esqueceu__senha);
    }

    public void indoParaLogin(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Login.class);
        startActivity(intentl);
    }
}
