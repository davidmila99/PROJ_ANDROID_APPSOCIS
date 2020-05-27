package com.example.appsocisrunapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.appsocisrunapp.Fragments.BannerInfoRuta;
import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Punt;
import com.example.appsocisrunapp.info.Model.Ruta;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class InfoRuta extends AppCompatActivity {
    //*****************************************************************
    public static Ruta rutaSel;
    public static ArrayList<Punt> puntsRuta = new ArrayList<>();
    //*****************************************************************
    public ImageLoader imgLoader;
    //*****************************************************************
    public WebView wbvDescripcio;
    //*****************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_ruta);
        inicialitzerUniversalImageLoader();

        //**************************************************************
        posarBanner();
        //**************************************************************
        wbvDescripcio = findViewById(R.id.wbView);
        //**************************************************************
        //wbvDescripcio.setTextClassifier(rutaSel.getDescMarkDown());

    }

    private void posarBanner() {
        BannerInfoRuta ban = BannerInfoRuta.newInstance(rutaSel);
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.replace(R.id.frgPrinc,ban);
        tran.commit();
    }

    private void inicialitzerUniversalImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
