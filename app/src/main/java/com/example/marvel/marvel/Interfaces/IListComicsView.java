package com.example.marvel.marvel.Interfaces;

import android.widget.Adapter;

import com.example.marvel.marvel.Adapters.ComicsAdapter;
import com.example.marvel.marvel.Comics.Comic;

/**
 * Created by neon2004 on 28/01/2017.
 */

public interface IListComicsView {
    void  setListAdapter(ComicsAdapter adapter);
    void goToDetailContact(Comic comic);
    void setLayoutManager();

}
