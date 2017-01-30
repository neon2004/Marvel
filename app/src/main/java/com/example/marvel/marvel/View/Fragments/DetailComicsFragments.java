package com.example.marvel.marvel.View.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IDetailComicsView;
import com.example.marvel.marvel.Presenter.DetailComicsPresenter;
import com.example.marvel.marvel.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailComicsFragments extends Fragment implements IDetailComicsView {

    @Bind(R.id.scroll)
    NestedScrollView scroll;
    @Bind(R.id.image_paralax)
    ImageView imageParalax;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapser)
    CollapsingToolbarLayout collapser;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.coordinator)
    CoordinatorLayout coordinator;
    private Comic comic;
    private DetailComicsPresenter comicsDetailPresenter;

    public DetailComicsFragments() {
    }

    public static DetailComicsFragments newInstance(Bundle arguments) {
        DetailComicsFragments f = new DetailComicsFragments();
        if (arguments != null) {
            f.setArguments(arguments);
        }
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.detail_comic_fragment, container, false);
        ButterKnife.bind(this, v);
        this.comic = (Comic) getArguments().getSerializable("comic");
        return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.comicsDetailPresenter = new DetailComicsPresenter(this, getActivity(), comic);
        this.comicsDetailPresenter.start();
    }

    @Override
    public void setImage(String url) {
        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .placeholder(R.drawable)
//                    .error(R.drawable.loaderror)
                .into(imageParalax);
    }

    @Override
    public void setTitle(String titulo) {
        collapser.setTitle(titulo);
    }

    @Override
    public void setDescription(String Descripcion) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
