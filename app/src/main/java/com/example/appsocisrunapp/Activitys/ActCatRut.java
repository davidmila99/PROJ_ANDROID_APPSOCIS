package com.example.appsocisrunapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.appsocisrunapp.Adapters.AdapterRutes;
import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Categoria;
import com.example.appsocisrunapp.info.Model.Ruta;

import java.util.ArrayList;

public class ActCatRut extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ArrayList<Categoria> catsProva = new ArrayList<>();
    public static ArrayList<Ruta> rutsProva = new ArrayList<>();
    //***************************************************************
    private Spinner spnCats;
    private RecyclerView rcvRutes;
    private AdapterRutes aRutes;
    private Button bFiltrar;
    private Button bNetejar;
    //***************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cat_rut);
        //****************************************************
        iniciarCatsProva();
        //****************************************************
        spnCats = findViewById(R.id.spnCats);
        rcvRutes = findViewById(R.id.rcvRutes);
        bFiltrar = findViewById(R.id.btnFiltra);
        bNetejar = findViewById(R.id.btnNetejaFiltre);
        //****************************************************
        posarSpinnerCats();
        //****************************************************
        rcvRutes.setHasFixedSize(true);
        rcvRutes.setLayoutManager(new GridLayoutManager(this, 1));
        aRutes = new AdapterRutes(rutsProva);
        rcvRutes.setAdapter(aRutes);
        //****************************************************
        bFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarRutesFiltrades();
            }
        });
    }

    private void mostrarRutesFiltrades() {
        ArrayList<Ruta> rutesAuxFiltrades = new ArrayList<>();
        Log.d("SPN"," SELECCIO --- > " + spnCats.getSelectedItem().toString());
        Categoria catSel = (Categoria) spnCats.getSelectedItem();

    }

    private void posarSpinnerCats() {
        ArrayAdapter<Categoria> adapterSpiner = new ArrayAdapter<Categoria>(this,android.R.layout.simple_spinner_item,catsProva);
        spnCats.setAdapter(adapterSpiner);
        spnCats.setOnItemSelectedListener(this);
    }

    private void iniciarCatsProva() {
        catsProva.add(new Categoria(1,"CAT 1"));
        catsProva.add(new Categoria(2,"CAT 2"));
        catsProva.add(new Categoria(3,"CAT 3"));
        catsProva.add(new Categoria(4,"CAT 4"));
        catsProva.add(new Categoria(5,"CAT 5"));
        catsProva.add(new Categoria(6,"CAT 6"));
        catsProva.add(new Categoria(7,"CAT 7"));
/*
        rutsProva.add(new Ruta(1,"RUTA 1",catsProva.get(3)));
        rutsProva.add(new Ruta(2,"RUTA 2",catsProva.get(6)));
        rutsProva.add(new Ruta(3,"RUTA 3",catsProva.get(4)));
        rutsProva.add(new Ruta(4,"RUTA 4",catsProva.get(5)));
        rutsProva.add(new Ruta(5,"RUTA 5",catsProva.get(2)));
        rutsProva.add(new Ruta(6,"RUTA 6",catsProva.get(1)));
        rutsProva.add(new Ruta(7,"RUTA 7",catsProva.get(2)));
        rutsProva.add(new Ruta(8,"RUTA 8",catsProva.get(2)));
*/

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Log.d("SPN"," SELECCIO --- > " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
