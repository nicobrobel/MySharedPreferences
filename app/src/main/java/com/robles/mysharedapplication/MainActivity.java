package com.robles.mysharedapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eUser, ePass;
    Button btnSave, btnDisplay;
    SharedPreferences preferences;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eUser = (EditText) findViewById(R.id.eUser);
        ePass = (EditText) findViewById(R.id.ePass);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", eUser.getText().toString());
        editor.putString("password", ePass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadInfo (View view){
        String user = preferences.getString("username","");
        String pass = preferences.getString("password","");
        tvDisplay.setText("The pasword of " + user + " is " + pass);
    }
}