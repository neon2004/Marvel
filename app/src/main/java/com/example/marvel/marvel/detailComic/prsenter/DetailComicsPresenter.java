package com.example.marvel.marvel.detailComic.prsenter;

import android.app.Activity;

import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.detailComic.contract.DetailComicContract;


public class DetailComicsPresenter implements DetailComicContract.Presenter{

    private final Activity act;
    private final Comic comic;
    private DetailComicContract.View detailComicsFragments;

    public DetailComicsPresenter(DetailComicContract.View detailComicsFragments, Activity activity, Comic comic) {
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
