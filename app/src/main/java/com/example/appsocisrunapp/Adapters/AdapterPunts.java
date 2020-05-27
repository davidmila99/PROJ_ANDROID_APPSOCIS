package com.example.appsocisrunapp.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Punt;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class AdapterPunts extends RecyclerView.Adapter<AdapterPunts.MyViewHolder>{
    private ArrayList<Punt> puntsXmostrar = new ArrayList<>();
    private ImageLoader imageLoader;

    public AdapterPunts(ArrayList<Punt> puntsXmostrar) {
        this.puntsXmostrar = puntsXmostrar;
        imageLoader = ImageLoader.getInstance();
    }

    @NonNull
    @Override
    public AdapterPunts.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_punts,
                null,
                false);
        v.setSelected(true);
        return new AdapterPunts.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPunts.MyViewHolder holder, int position) {
        Punt pM = puntsXmostrar.get(position);
        ImageLoader.getInstance().displayImage(pM.getPuntFoto().getUrlFoto(),holder.imv);
        holder.txv.setText(pM.getNumero() + ".-" + pM.getNom());
        holder.txvLon.setText(holder.txvLon.getText()+String.format("%.1f",pM.getLongitud()));
        holder.txvLat.setText(holder.txvLat.getText()+String.format("%.1f",pM.getLat()));;
        holder.txvEle.setText(holder.txvEle.getText()+String.format("%.1f",pM.getElevacio()));;
    }

    @Override
    public int getItemCount() {
        return puntsXmostrar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imv;
        TextView txv;
        TextView txvLon;
        TextView txvLat;
        TextView txvEle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.imvPuntFons);
            txv = itemView.findViewById(R.id.txvNomPunt);
            txvLon = itemView.findViewById(R.id.txvLonPunt);
            txvLat = itemView.findViewById(R.id.txvLatPunt);
            txvEle = itemView.findViewById(R.id.txvElPunt);
        }
    }
}
