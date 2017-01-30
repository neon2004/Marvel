package com.example.marvel.marvel.Comics;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comic implements Serializable {
    private int id;
    private String imageUrl;
    private String extensionImage;
    private String descripcion;
    private String autor;

    public Comic(int id, String imageUrl, String extensionImage, String descripcion, String titulo, String autor) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.extensionImage = extensionImage;
        this.autor = autor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExtensionImage() {
        return extensionImage;
    }

    public void setExtensionImage(String extensionImage) {
        this.extensionImage = extensionImage;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;


}
