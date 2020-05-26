package com.example.appsocisrunapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsocisrunapp.R;
import com.example.appsocisrunapp.info.Model.Ruta;

import java.util.ArrayList;

public class AdapterRutes extends RecyclerView.Adapter<AdapterRutes.MyViewHolder>{
    private ArrayList<Ruta> rutesXmostrar = new ArrayList<>();

    public AdapterRutes(ArrayList<Ruta> rutesXmostrar) {
        this.rutesXmostrar = rutesXmostrar;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_rutes,
                null,
                false);
        v.setSelected(true);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Ruta rM = rutesXmostrar.get(position);
        holder.txvNomRuta.setText(rM.getTitol());
    }

    @Override
    public int getItemCount() {
        return rutesXmostrar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txvNomRuta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txvNomRuta = itemView.findViewById(R.id.txvNomRuta);
        }
    }
}
