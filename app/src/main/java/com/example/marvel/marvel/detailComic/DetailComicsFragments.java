package com.example.marvel.marvel.detailComic;

import android.app.Fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.common.base.BaseFragment;
import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.detailComic.contract.DetailComicContract;
import com.example.marvel.marvel.detailComic.prsenter.DetailComicsPresenter;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;


/**
 * A placeholder fragment containing a simple view.
 */
@EFragment(R.layout.detail_comic_fragment)
public class DetailComicsFragments extends BaseFragment implements DetailComicContract.View {

    @ViewById(R.id.scroll)
    NestedScrollView scroll;
    @ViewById(R.id.image_paralax)
    ImageView imageParalax;
    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.collapser)
    CollapsingToolbarLayout collapser;
    @ViewById(R.id.app_bar)
    AppBarLayout appBar;
    @ViewById(R.id.coordinator)
    CoordinatorLayout coordinator;
    @ViewById(R.id.tvDescripcion)
    TextView tvDescripcion;
    @ViewById(R.id.tvAutor)
    TextView tvAutor;

    @FragmentArg
    Comic comic;

    private DetailComicsPresenter comicsDetailPresenter;

    @AfterViews
    protected void listComicsFragmentsAfterViews() {
        this.comicsDetailPresenter = new DetailComicsPresenter(this, getActivity(), comic);
        this.comicsDetailPresenter.start();
    }

    @Override
    public void setImage(String url) {
        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(imageParalax);
    }

    @Override
    public void setTitle(String titulo) {
        collapser.setTitle(titulo);

    }

    @Override
    public void setDescription(String Descripcion) {
        tvDescripcion.setText(Descripcion);
    }

    @Override
    public void setAutor(String autor) {
        tvAutor.setText(autor);
    }

}
