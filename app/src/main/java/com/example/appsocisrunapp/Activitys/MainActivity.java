package com.example.appsocisrunapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.appsocisrunapp.ConnecxioServer.ConnecxioLlistaRutes;
import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Ruta;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Ruta> ruts = new ArrayList<>();
    private ConnecxioLlistaRutes asyncTaskConnexio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///--------------------------------------
        asyncTaskConnexio = new ConnecxioLlistaRutes(this);
        asyncTaskConnexio.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        ///--------------------------------------
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        //******************************
    }



    private void obrirActCatRuta(){
        Intent inte = new Intent(this,ActCatRut.class);
        startActivity(inte);
    }

    public void finishDownload(ArrayList<Ruta> rutas) {
        Log.d("SERVER","LLISTA ----------------- >" + rutas.toString());
        ActCatRut.ruts = rutas;
        Intent inte = new Intent(this,ActCatRut.class);
        startActivity(inte);

    }
}
