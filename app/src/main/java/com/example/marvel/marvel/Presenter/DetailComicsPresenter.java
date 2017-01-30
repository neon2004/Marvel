package com.example.marvel.marvel.Presenter;

import android.app.Activity;

import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IDetailComicsView;
import com.example.marvel.marvel.Model.ComicsInteractor;
import com.example.marvel.marvel.View.Fragments.DetailComicsFragments;


public class DetailComicsPresenter {

    private final Activity act;
    private final Comic comic;
    private IDetailComicsView detailComicsFragments;

    public DetailComicsPresenter(DetailComicsFragments detailComicsFragments, Activity activity, Comic comic) {
        this.detailComicsFragments = detailComicsFragments;
        this.act = activity;
        this.comic = comic;
    }

    public void start(){

        detailComicsFragments.setImage(comic.getImageUrlOK());
        detailComicsFragments.setTitle(comic.getTitulo());
        detailComicsFragments.setAutor(comic.getAutor());
        detailComicsFragments.setDescription(comic.getDescripcion());
    }
}
