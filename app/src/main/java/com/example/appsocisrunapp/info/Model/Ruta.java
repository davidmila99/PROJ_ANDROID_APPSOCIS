package com.example.appsocisrunapp.info.Model;

import java.util.Date;

public class Ruta {
    private Integer id;
    private String titol;
    private String descMarkDown;
    private Float desnivell;
    private Float alcadaMax;
    private Float alcadaMin;
    private Float distanciaKm;
    private Date temsAprox;
    private Boolean circular;
    private Float dificultat;
    private String urlGpx;
    private Categoria cat;
    private Foto fotoRuta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id < 0 || id == null){
            throw new RunAppException("El id ha de ser positiu");
        }
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        if(titol == null){
            throw new RunAppException("El titol es oblilgatori");
        }
        this.titol = titol;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        if(cat == null){
            throw new RunAppException("Ruta obligatoria");
        }
        this.cat = cat;
    }

    public String getDescMarkDown() {
        return descMarkDown;
    }

    public void setDescMarkDown(String descMarkDown) {
        if(descMarkDown == null){
            throw new RunAppException("La descripcio es oblilgatoria");
        }
        this.descMarkDown = descMarkDown;
    }

    public Float getDesnivell() {
        return desnivell;
    }

    public void setDesnivell(Float desnivell) {
        if(desnivell == null){
            throw new RunAppException("El desnivell es oblilgatori");
        }
        this.desnivell = desnivell;
    }

    public Float getAlcadaMax() {
        return alcadaMax;
    }

    public void setAlcadaMax(Float alcadaMax) {
        if(alcadaMax == null){
            throw new RunAppException("La alcada maxima es obligatoria");
        }
        this.alcadaMax = alcadaMax;
    }

    public Float getAlcadaMin() {
        return alcadaMin;
    }

    public void setAlcadaMin(Float alcadaMin) {
        if(alcadaMin == null){
            throw new RunAppException("La alcada minima es obligatoria");
        }
        this.alcadaMin = alcadaMin;
    }

    public Float getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(Float distanciaKm) {
        if(distanciaKm < 0 || distanciaKm == null){
            throw new RunAppException("La distancia ha de ser positiva");
        }
        this.distanciaKm = distanciaKm;
    }

    public Date getTemsAprox() {
        return temsAprox;
    }

    public void setTemsAprox(Date temsAprox) {
        if(temsAprox == null){
            throw new RunAppException("El temps aproximat es obligatori");
        }
        this.temsAprox = temsAprox;
    }

    public Boolean isCircular() {
        return circular;
    }

    public void setCircular(Boolean circular) {
        if(circular == null){
            throw new RunAppException("Es obligatori di si es circular o no la ruta");
        }
        this.circular = circular;
    }

    public Float getDificultat() {
        return dificultat;
    }

    public void setDificultat(Float dificultat) {
        if(dificultat < 0 || dificultat > 10 || dificultat == null){
            throw new RunAppException("La dificultat ha de estar entre 0 i 10");
        }
        this.dificultat = dificultat;
    }

    public String getUrlGpx() {
        return urlGpx;
    }

    public void setUrlGpx(String urlGpx) {
        this.urlGpx = urlGpx;
    }

    public Foto getFotoRuta() {
        return fotoRuta;
    }

    public void setFotoRuta(Foto fotoRuta) {
        if(fotoRuta == null){
            throw new RunAppException("La foto de la ruta es obligatoria");
        }
        this.fotoRuta = fotoRuta;
    }


    public Ruta(Integer id, String titol, String descMarkDown, Float desnivell, Float alcadaMax, Float alcadaMin, Float distanciaKm, Boolean circular, Float dificultat, String urlGpx, Categoria cat, Foto fotoRuta) {
        this.id = id;
        this.titol = titol;
        this.descMarkDown = descMarkDown;
        this.desnivell = desnivell;
        this.alcadaMax = alcadaMax;
        this.alcadaMin = alcadaMin;
        this.distanciaKm = distanciaKm;
        this.circular = circular;
        this.dificultat = dificultat;
        this.urlGpx = urlGpx;
        this.cat = cat;
        this.fotoRuta = fotoRuta;
    }

    public Ruta(Integer id, String titol, String descMarkDown, Float desnivell, Float alcadaMax, Float alcadaMin, Float distanciaKm, Date temsAprox, Boolean circular, Float dificultat, String urlGpx, Categoria cat, Foto fotoRuta) {
        this.id = id;
        this.titol = titol;
        this.descMarkDown = descMarkDown;
        this.desnivell = desnivell;
        this.alcadaMax = alcadaMax;
        this.alcadaMin = alcadaMin;
        this.distanciaKm = distanciaKm;
        this.temsAprox = temsAprox;
        this.circular = circular;
        this.dificultat = dificultat;
        this.urlGpx = urlGpx;
        this.cat = cat;
        this.fotoRuta = fotoRuta;
    }

    public Ruta() {
    }

    @Override
    public String toString() {
        return "Ruta{" + "id=" + id + ", titol=" + titol /*+ ", descMarkDown=" + descMarkDown + ", desnivell=" + desnivell + ", alcadaMax=" + alcadaMax + ", alcadaMin=" + alcadaMin + ", distanciaKm=" + distanciaKm + ", temsAprox=" + temsAprox + ", circular=" + circular + ", dificultat=" + dificultat + ", urlGpx=" + urlGpx + ", fotoRuta=" + fotoRuta + ", puntsRuta=" + puntsRuta + '}'*/;
    }

    public Ruta(Integer id, String titol) {
        this.id = id;
        this.titol = titol;
    }
}
