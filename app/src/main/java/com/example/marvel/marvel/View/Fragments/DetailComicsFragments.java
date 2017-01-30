package com.example.marvel.marvel.View.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IDetailComicsView;
import com.example.marvel.marvel.Presenter.DetailComicsPresenter;
import com.example.marvel.marvel.Presenter.ListComicsPresenter;
import com.example.marvel.marvel.R;

import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailComicsFragments extends Fragment implements IDetailComicsView{

    private Comic comic;
    private DetailComicsPresenter comicsDetailPresenter;

    public DetailComicsFragments() {
    }

    public static DetailComicsFragments newInstance(Bundle arguments){
        DetailComicsFragments f = new DetailComicsFragments();
        if(arguments != null){
            f.setArguments(arguments);
        }
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         inflater.inflate(R.layout.fragment_main, container, false);
        View v = inflater.inflate(R.layout.list_comic_fragment, container, false);
        ButterKnife.bind(this, v);

        this.comic = (Comic) getArguments().getSerializable("comic");
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.comicsDetailPresenter = new DetailComicsPresenter(this,getActivity(),comic);
    }

    @Override
    public void setImage(String url) {
//        Glide.with(this).load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .placeholder(R.drawable)
//                    .error(R.drawable.loaderror)
//                .into(imgComicList);
    }

    @Override
    public void setTitle(String titulo) {

    }

    @Override
    public void setDescription(String Descripcion) {

    }
}
