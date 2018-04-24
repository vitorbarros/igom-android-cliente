package com.segurityapp.igom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Class_Forma_Pagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class__forma__pagamento);
    }

    public void indoParaPorcurandoProtetor(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Procurando_Protetor.class);
        startActivity(intentl);
    }
}
