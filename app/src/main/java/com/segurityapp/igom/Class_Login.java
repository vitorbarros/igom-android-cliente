package com.segurityapp.igom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.segurityapp.igom.entity.Entity;
import com.segurityapp.igom.entity.repository.RepositoryInterface;
import com.segurityapp.igom.service.LoginService;

import org.json.JSONException;

import java.util.List;

public class Class_Login extends AppCompatActivity {

    private RepositoryInterface.CallbackHandler callbackHandler;

    public void indoParaDeCadastro(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Cadastrar.class);
        startActivity(intentl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class__login);


        EditText last = findViewById(R.id.editText7);
        last.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

            if(i == KeyEvent.KEYCODE_ENTER){



                return true;
            }
            return true;
            }
        });

    }

    public void loginAction(View view)
    {
        EditText usernameField = findViewById(R.id.editText6);
        String username = usernameField.getText().toString().trim();

        EditText passwordField = findViewById(R.id.editText7);
        String password = passwordField.getText().toString().trim();

        LoginService loginService = new LoginService();



        try {
            if(loginService.login(username, password)){
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
