package com.example.marvel.marvel.common.rest.comics;


import java.io.Serializable;

public class Comic implements Serializable {
    private int id;
    private String imageUrl;
    private String extensionImage;
    private String descripcion;
    private String autor;
    private String imageUrlOK;
    private String titulo;

    public Comic(int id, String imageUrl, String extensionImage, String descripcion, String titulo, String autor) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.extensionImage = extensionImage;
        this.autor = autor;
        this.imageUrlOK = imageUrl+"."+extensionImage;

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


    public String getImageUrlOK() {
        return imageUrlOK;
    }

    public void setImageUrlOK(String imageUrlOK) {
        this.imageUrlOK = imageUrlOK;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
