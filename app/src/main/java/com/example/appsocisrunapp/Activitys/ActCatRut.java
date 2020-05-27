package com.example.appsocisrunapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.appsocisrunapp.Adapters.AdapterRutes;
import com.example.appsocisrunapp.ConnecxioServer.ConnecxioLlistaPunts;
import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Categoria;
import com.example.appsocisrunapp.info.Model.Punt;
import com.example.appsocisrunapp.info.Model.Ruta;

import java.util.ArrayList;

public class ActCatRut extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ArrayList<Categoria> cats = new ArrayList<>();
    public static ArrayList<Ruta> ruts = new ArrayList<>();
    //***************************************************************
    private Spinner spnCats;
    private RecyclerView rcvRutes;
    private AdapterRutes aRutes;
    private Button bFiltrar;
    private Button bNetejar;
    //private ProgressBar progressBar;
    //***************************************************************
    private ConnecxioLlistaPunts con;
    //***************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cat_rut);
        //****************************************************
        iniciarLlistes();
        //****************************************************
        spnCats = findViewById(R.id.spnCats);
        rcvRutes = findViewById(R.id.rcvRutes);
        bFiltrar = findViewById(R.id.btnFiltra);
        bNetejar = findViewById(R.id.btnNetejaFiltre);
        //progressBar = findViewById(R.id.prgrsBar);
        //****************************************************
        posarSpinnerCats();
        //****************************************************
        rcvRutes.setHasFixedSize(true);
        rcvRutes.setLayoutManager(new GridLayoutManager(this, 1));
        aRutes = new AdapterRutes(ruts,this);
        rcvRutes.setAdapter(aRutes);
        //****************************************************
        bFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarRutesFiltrades();
            }
        });
        bNetejar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netejarFiltre();
            }
        });
    }

    private void netejarFiltre() {
        spnCats.setSelection(cats.size()-1);
        posarLesRutesFiltrades(ruts);
    }

    private void mostrarRutesFiltrades() {
        if(spnCats.getSelectedItemPosition() == cats.size()-1){
            posarLesRutesFiltrades(ruts);
        }else{
            ArrayList<Ruta> rutesAuxFiltrades = new ArrayList<>();
            Log.d("SPN"," SELECCIO --- > " + spnCats.getSelectedItem().toString());
            Categoria catSel = (Categoria) spnCats.getSelectedItem();
            emplenarLlistaAmbLesRutesFiltrades(rutesAuxFiltrades,catSel);
            posarLesRutesFiltrades(rutesAuxFiltrades);
        }

    }

    private void posarLesRutesFiltrades(ArrayList<Ruta> rutesAuxFiltrades) {
        rcvRutes.setHasFixedSize(true);
        rcvRutes.setLayoutManager(new GridLayoutManager(this, 1));
        aRutes = new AdapterRutes(rutesAuxFiltrades,this);
        rcvRutes.setAdapter(aRutes);
    }

    private void emplenarLlistaAmbLesRutesFiltrades(ArrayList<Ruta> rs, Categoria c) {
        for(Ruta r:ruts){
            if(r.getCat()==c){
                rs.add(r);
            }
        }
    }

    private void posarSpinnerCats() {
        ArrayAdapter<Categoria> adapterSpiner = new ArrayAdapter<Categoria>(this,android.R.layout.simple_spinner_item,cats);
        spnCats.setAdapter(adapterSpiner);
        spnCats.setOnItemSelectedListener(this);
        spnCats.setSelection(cats.size()-1);
    }

    private void iniciarLlistes() {
        for(Ruta r : ruts){
            if(!cats.contains(r.getCat())){
                cats.add(r.getCat());
            }
        }
        cats.add(new Categoria(cats.size()+1,"TOTES"));
    }

    public void rutaSeleccionada(Ruta r){
        Log.d("RUTASEL","RUTA SEL -> " + r.toString());
        //progressBar.setVisibility(View.VISIBLE);
        con = new ConnecxioLlistaPunts(this,r);
        con.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Log.d("SPN"," SELECCIO --- > " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void descargaPuntsCompleta(ArrayList<Punt> punts, Ruta rSeleccionada) {
        InfoRuta.puntsRuta = punts;
        InfoRuta.rutaSel = rSeleccionada;
        Intent inte = new Intent(this,InfoRuta.class);
        startActivity(inte);
    }
}
