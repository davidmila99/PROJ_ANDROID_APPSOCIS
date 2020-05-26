package com.example.appsocisrunapp.ConnecxioServer;

import android.content.Context;
import android.util.Log;

import com.example.appsocisrunapp.info.Model.Categoria;
import com.example.appsocisrunapp.info.Model.Foto;
import com.example.appsocisrunapp.info.Model.Punt;
import com.example.appsocisrunapp.info.Model.Ruta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class Connecxio {
    private Socket sk;
    private DataOutputStream dos;
    private DataInputStream dis;
    private ObjectInputStream rebreObjecte;
    private int id;
    final int PORT = 15000;

    public Connecxio(int id) {
        Log.d("SERVER","ARRIBO AQUI");
        this.id = id;
        //--------------------------------------------------------------------------------
        try {
            sk = new Socket("192.168.1.76", PORT);
            Log.d("SERVER","ARRIBO AQUI TAMBNE");
            //**********************************************************
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            rebreObjecte = new ObjectInputStream(sk.getInputStream());
            //***********************************************************
            Log.d("SERVER","ARRIBO AQUI TAMBNE I AQUI UN ALTRE COP");
            Log.d("SERVER",id + " envía saludo");
            //dos.writeUTF("hola");

            //Rebre ruta (dos parametres)****************************************************
            /*Ruta rutaRebuda;

            Integer idRuta = null;
            String titolRuta;
            try {
                idRuta = (Integer) rebreObjecte.readObject();
                titolRuta = (String) rebreObjecte.readObject();
                rutaRebuda = new Ruta(idRuta,titolRuta);
                Log.d("SERVER","RUTA REBUDA ----> "+rutaRebuda.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //******************************************************************************

            /*
            String respuesta="";
            respuesta = dis.readUTF();
            Log.d("SERVER",id + " Servidor devuelve saludo: " + respuesta);*/

        } catch (IOException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            Log.d("SERVER","PETA"+ex.getCause()+ex.getMessage());
            ex.printStackTrace();
        }

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

    public ArrayList<Ruta> getRutes(){
        ArrayList<Ruta> ruts = new ArrayList<>();
        Ruta aux;
        try {
            dos.writeInt(1);
            int numRutes = this.dis.readInt();
            for(int i = 0;i<numRutes;i++){
                aux = rebreRuta();
                ruts.add(aux);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ruts;
    }

    public ArrayList<Punt> getPuntsDeRutes(Ruta r){
        ArrayList<Punt> punts = new ArrayList<>();
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

        return punts;
    }

    private Punt rebrePunt() {
        Punt auxP = null;
        Foto auxFoto = rebreFoto();
        try {
            auxP = new Punt((Integer) rebreObjecte.readObject(),
                    (Integer) rebreObjecte.readObject(),
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

    private Ruta rebreRuta() {
        Ruta auxR = null;
        Foto auxFoto = rebreFoto();
        Categoria auxCat = rebreCat();
        try {
            auxR = new Ruta((Integer) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject(),
                    (Float) rebreObjecte.readObject(),
                    (Float) rebreObjecte.readObject(),
                    (Float) rebreObjecte.readObject(),
                    (Float) rebreObjecte.readObject(),
                    //(Date) rebreObjecte.readObject(),
                    (Boolean) rebreObjecte.readObject(),
                    (Float) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject(),
                    auxCat,
                    auxFoto);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  auxR;
    }

    private Categoria rebreCat() {
        Categoria auxC = null;
        try {
            auxC = new Categoria((Integer) rebreObjecte.readObject(),
                    (String) rebreObjecte.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxC;
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
}
