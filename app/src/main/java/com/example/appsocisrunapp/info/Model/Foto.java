package com.example.appsocisrunapp.info.Model;

public class Foto {
    private Integer id;
    private String urlFoto;
    private String titolFoto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id == null || id < 0){
            throw new RunAppException("El id es obligatori i ha de ser positiu");
        }
        this.id = id;
    }


    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        if(urlFoto==null){
            throw new RunAppException("La foto es obligatoria");
        }
        this.urlFoto = urlFoto;
    }

    public String getTitolFoto() {
        return titolFoto;
    }

    public void setTitolFoto(String titolFoto) {
        this.titolFoto = titolFoto;
    }

    public Foto() {
    }

    public Foto(String urlFoto, String titolFoto) {
        setUrlFoto(urlFoto);
        setTitolFoto(titolFoto);
    }

    public Foto(Integer id,String urlFoto, String titolFoto) {
        setId(id);
        setUrlFoto(urlFoto);
        setTitolFoto(titolFoto);
    }

    @Override
    public String toString() {
        return "Foto{" +
                "id=" + id +
                ", urlFoto='" + urlFoto + '\'' +
                ", titolFoto='" + titolFoto + '\'' +
                '}';
    }
}
