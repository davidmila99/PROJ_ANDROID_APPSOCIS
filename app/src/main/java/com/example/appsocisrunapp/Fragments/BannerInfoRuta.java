package com.example.appsocisrunapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Ruta;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BannerInfoRuta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BannerInfoRuta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BannerInfoRuta extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Ruta";

    // TODO: Rename and change types of parameters
    private Ruta rSel;
    private ImageView imvFons;
    private TextView txvValoracio;
    private TextView txvNom;

    public BannerInfoRuta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BannerInfoRuta.
     */
    // TODO: Rename and change types and number of parameters
    public static BannerInfoRuta newInstance(Ruta param1) {
        BannerInfoRuta fragment = new BannerInfoRuta();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            rSel = (Ruta) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_banner_info_ruta, container, false);

        //****************************************************************
        imvFons = v.findViewById(R.id.imvFons);
        txvValoracio = v.findViewById(R.id.txvValoracio);
        txvNom = v.findViewById(R.id.txvNom);
        //****************************************************************
        ImageLoader.getInstance().displayImage(rSel.getFotoRuta().getUrlFoto(),imvFons);
        txvValoracio.setText(String.format("%.1f",rSel.getDificultat()));
        txvNom.setText(rSel.getTitol());
        //****************************************************************
        return v;
    }
}
