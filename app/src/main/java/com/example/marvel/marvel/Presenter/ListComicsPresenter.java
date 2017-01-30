package com.example.marvel.marvel.Presenter;

import android.app.Activity;
import android.view.View;

import com.example.marvel.marvel.Adapters.ComicsAdapter;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IListComicsView;
import com.example.marvel.marvel.Model.ComicsInteractor;
import com.example.marvel.marvel.View.Fragments.ListComicsFragments;

import java.util.ArrayList;

import static com.example.marvel.marvel.R.id.recView;

public class ListComicsPresenter {


    private ComicsInteractor interactor;
    private ArrayList<Comic> listComics;
    private IListComicsView listComicsFragments;
    private Activity act;

    public ListComicsPresenter(IListComicsView listComicsFragments, Activity activity) {
        this.listComicsFragments = listComicsFragments;
        this.interactor = new ComicsInteractor();
        this.act = activity;
    }

    public void start(){
        listComics  = interactor.getListComics();

        ComicsAdapter adapter = new ComicsAdapter(listComics,act.getApplicationContext());
        adapter.listener = this;
        listComicsFragments.setListAdapter(adapter);
        listComicsFragments.setLayoutManager();

    }

    public void onItemClick(Comic comic){
        listComicsFragments.goToDetailContact(comic);
    }
}
