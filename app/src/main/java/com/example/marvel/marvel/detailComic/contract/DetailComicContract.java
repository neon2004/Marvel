package com.example.marvel.marvel.detailComic.contract;


/**
 * Created by neon2004 on 30/04/2017.
 */

public class DetailComicContract {
    public interface Presenter{



    }

    public interface View {
        void  setImage(String url);
        void setTitle(String titulo);
        void setDescription(String descripcion);
        void setAutor(String autor);

    }
}
