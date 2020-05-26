package com.example.appsocisrunapp.info.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Categoria {
    private Integer id;
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id < 0 ||id == null){
            throw new RunAppException("El id ha de ser positiu");
        }
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom==null){
            throw new RunAppException("El nom es obligatori");
        }
        this.nom = nom;
    }

    public Categoria(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
