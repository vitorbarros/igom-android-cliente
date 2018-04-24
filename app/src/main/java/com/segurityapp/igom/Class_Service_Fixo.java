package com.segurityapp.igom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Class_Service_Fixo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class__service__fixo);
    }


    public void indoParaAcompanhante(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Home_Services.class);
        startActivity(intentl);
    }

    public void indoParadetalhes(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Solicitacao_service_fixo.class);
        startActivity(intentl);
    }
}
