package com.segurityapp.igom;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.segurityapp.igom.adapter.HttpClientAdapter;
import com.segurityapp.igom.config.Config;
import com.segurityapp.igom.db.contract.ClientContract;
import com.segurityapp.igom.db.helper.ClientDbHelper;
import com.segurityapp.igom.entity.Client;
import com.segurityapp.igom.entity.OAuth;
import com.segurityapp.igom.entity.repository.OAuthRepository;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Class_Login extends AppCompatActivity {

    private String username;
    private String password;
    private boolean loginResult;
    private Client clientObject;

    public void indoParaDeCadastro(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Cadastrar.class);
        startActivity(intentl);
    }

    public void indoParaEsqueceuASenha(View view) {
        Intent intentl = new Intent(getApplicationContext(), Class_Esqueceu_Senha.class);
        startActivity(intentl);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class__login);
    }

    public void loginAction(View view) {

        EditText usernameField = findViewById(R.id.editText6);
        EditText passwordField = findViewById(R.id.editText7);

        this.username = usernameField.getText().toString().trim();
        this.password = passwordField.getText().toString().trim();

        try {
            this.login();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void login() throws JSONException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("type", "clients");

        OAuthRepository oAuthRepository = new OAuthRepository();

        HttpClientAdapter httpClientAdapter = new HttpClientAdapter(
                OAuth.getJSON(),
                jsonObject.toString(),
                Config.baseApiURI,
                "/api/V1/login/authenticate",
                "POST",
                oAuthRepository.getAccessToken()
        );

        httpClientAdapter.getHttp()
                .newCall(httpClientAdapter.getAdapter())
                .enqueue(new Callback() {

                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        loginResult = false;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (loginResult) {
                                    Intent intent = new Intent(getApplicationContext(), Class_Cadastrar.class);
                                    finish();
                                    startActivity(intent);
                                } else {
                                    Context context = getApplicationContext();
                                    CharSequence text = "Usuário ou senha incorretos";
                                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            }
                        });
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                        if (response.code() != 200) {
                            loginResult = false;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (loginResult) {
                                        Intent intent = new Intent(getApplicationContext(), Class_Cadastrar.class);
                                        finish();
                                        startActivity(intent);
                                    } else {
                                        Context context = getApplicationContext();
                                        CharSequence text = "Usuário ou senha incorretos";
                                        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                }
                            });
                        } else {

                            loginResult = true;

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    if (loginResult) {
                                        Intent intent = new Intent(getApplicationContext(), Class_Cadastrar.class);
                                        finish();
                                        startActivity(intent);
                                    } else {
                                        Context context = getApplicationContext();
                                        CharSequence text = "Usuário ou senha incorretos";
                                        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                }
                            });
                        }
                    }
                });
    }

    private void storeInLocalDatabase() {

        ClientDbHelper dbHelper = new ClientDbHelper(MyApp.getAppContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ClientContract.ClientEntry.COLUMN_NAME_ID, clientObject.get_id());
        values.put(ClientContract.ClientEntry.COLUMN_NAME_NAME, clientObject.getName());
        values.put(ClientContract.ClientEntry.COLUMN_NAME_EMAIL, clientObject.getEmail());
        values.put(ClientContract.ClientEntry.COLUMN_NAME_USERNAME, clientObject.getUsername());
        values.put(ClientContract.ClientEntry.COLUMN_NAME_PASSWORD, clientObject.getPassword());

        db.insert(ClientContract.ClientEntry.TABLE_NAME, null, values);
    }

}
