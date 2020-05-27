package com.example.appsocisrunapp.ConnecxioServer;

import android.os.AsyncTask;
import android.util.Log;

import com.example.appsocisrunapp.Activitys.ActCatRut;
import com.example.appsocisrunapp.Activitys.MainActivity;
import com.example.appsocisrunapp.info.Model.Foto;
import com.example.appsocisrunapp.info.Model.Punt;
import com.example.appsocisrunapp.info.Model.Ruta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ConnecxioLlistaPunts extends AsyncTask<Void, Void, ArrayList<Punt>> {
    private Socket sk;
    private DataOutputStream dos;
    private DataInputStream dis;
    private ObjectInputStream rebreObjecte;
    final int PORT = 15000;
    final String IP = "192.168.1.76";
    private ActCatRut act;
    private Ruta rSeleccionada;
    private ArrayList<Punt> punts = new ArrayList<>();

    public ConnecxioLlistaPunts(ActCatRut act, Ruta rSeleccionada) {
        this.act = act;
        this.rSeleccionada = rSeleccionada;
    }

    private void desconetcar(){
        try {
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPuntsDeRutes(Ruta r){
        Punt aux;
        try {
            dos.writeInt(2);
            dos.writeInt(r.getId());
            int numPunts = this.dis.readInt();
            for(int i = 0;i<numPunts;i++){
                aux = rebrePunt();
                punts.add(aux);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Foto rebreFoto() {
        Foto auxF = null;
        try {
            auxF = new Foto((Integer) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxF;
    }

    private Punt rebrePunt() {
        Punt auxP = null;
        Foto auxFoto = rebreFoto();
        try {
            auxP = new Punt((Integer) rebreObjecte.readObject(),
                    //(Integer) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject(),
                    //(Date) rebreObjecte.readObject(),
                    (Double) rebreObjecte.readObject(),
                    (Double) rebreObjecte.readObject(),
                    (Double) rebreObjecte.readObject(),
                    auxFoto);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxP;
    }



    @Override
    protected void onPostExecute(ArrayList<Punt> punts) {
        super.onPostExecute(punts);
        Log.d("SERVER","LLISTA DEPUUNTS ------> " + punts.toString());
        act.descargaPuntsCompleta(punts,rSeleccionada);
    }

    @Override
    protected ArrayList<Punt> doInBackground(Void... voids) {
        try {
            sk = new Socket(IP, PORT);
            Log.d("SERVER","ARRIBO AQUI TAMBNE");
            //**********************************************************
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            rebreObjecte = new ObjectInputStream(sk.getInputStream());
            //***********************************************************
            Log.d("SERVER","ARRIBO AQUI TAMBNE I AQUI UN ALTRE COP PUUUUUUUUUUUUUNTS");
            getPuntsDeRutes(rSeleccionada);
        } catch (IOException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            Log.d("SERVER","PETA"+ex.getCause()+ex.getMessage());
            ex.printStackTrace();
        }
        desconetcar();
        return punts;
    }
}
