package com.example.marvel.marvel.Comics;


import java.io.Serializable;

public class Comic implements Serializable {
    private String id;
    private String imageUrl;
    private String descripcion;
    private String year;

    public Comic(String id, String imageUrl, String descripcion, String year, String titulo) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.descripcion = descripcion;
        this.year = year;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;


}
