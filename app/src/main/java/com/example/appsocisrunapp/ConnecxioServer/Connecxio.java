package com.example.appsocisrunapp.ConnecxioServer;

import android.util.Log;

import com.example.appsocisrunapp.info.Model.Ruta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Connecxio {
    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    protected ObjectInputStream rebreObjecte;
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
            dos.writeUTF("hola");



            //Rebre ruta (dos parametres)****************************************************
            Ruta rutaRebuda;

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
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            //Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            Log.d("SERVER","PETA"+ex.getCause()+ex.getMessage());
            ex.printStackTrace();
        }

    }
}
