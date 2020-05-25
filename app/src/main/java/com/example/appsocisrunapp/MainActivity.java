package com.example.appsocisrunapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.appsocisrunapp.ConnecxioServer.Connecxio;

public class MainActivity extends AppCompatActivity {
    private Button con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);


        con = findViewById(R.id.btnConnect);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SERVER","ANEM A INTENTAR CONNECTAR");
                Log.d("SERVER","ANEM A INTENTAR CONNECTAR 2222222222222222");
                Connecxio c = new Connecxio(1);
            }
        });
    }
}
