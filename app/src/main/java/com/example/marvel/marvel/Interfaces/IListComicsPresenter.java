package com.example.marvel.marvel.Interfaces;

import com.example.marvel.marvel.Adapters.ComicsAdapter;
import com.example.marvel.marvel.Comics.Comic;

import java.util.ArrayList;

/**
 * Created by neon2004 on 28/01/2017.
 */

public interface IListComicsPresenter {

    void createAdapter(ArrayList<Comic> listComics);
    void goDetail(Comic comic);


}
