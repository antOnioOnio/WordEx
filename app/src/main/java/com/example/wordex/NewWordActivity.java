package com.example.wordex;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private ArrayList<String> palabras = new ArrayList<>();
    private EditText mEditWordView;
    boolean working = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

        final Button buttonInternet = findViewById(R.id.button_internet);
        buttonInternet.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d("he llegao ","hay palabra");
                Intent replyIntent = new Intent();
                generaPalabras();
                System.out.println("ESTOY AQUI");
                String word =  palabras.get(0);
                mEditWordView.setText(word);
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);

                finish();

            }});
    }
    public void generaPalabras(){

        String json = getJson("https://opentdb.com/api.php?amount=10&type=boolean");

        JSONObject object = null; //Creamos un objeto JSON a partir de la cadena

        try {
            System.out.println("CONSIGO PALABRAS JEJE");
            object = new JSONObject(json);

            JSONArray json_array = object.optJSONArray("results");

            for (int i = 0; i < json_array.length(); i++) {
                try {
                    String palabra = json_array.getJSONObject(i).getString("category");

                    Log.d(palabra,"hay palabra");

                    this.palabras.add(palabra);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            working= true;
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public String getJson(String UrlString){
        StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(UrlString);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert urlConnection != null;
            urlConnection.disconnect();
        }
        return result.toString();

    }




}
