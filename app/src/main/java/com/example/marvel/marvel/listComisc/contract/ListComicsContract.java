package com.example.marvel.marvel.listComisc.contract;


import android.support.v7.widget.RecyclerView;

import com.example.marvel.marvel.common.adapters.ComicsAdapter;
import com.example.marvel.marvel.common.rest.comics.Comic;

import java.util.ArrayList;


/**
 * Created by neon2004 on 30/04/2017.
 */

public class ListComicsContract {
    public interface Presenter{
        void createAdapter(ArrayList<Comic> listComics);
        void goDetail(Comic comic);


    }

    public interface View {

        void  setListAdapter(ComicsAdapter adapter);
        void goToDetailContact(Comic comic);
        void setLayoutManager();
        RecyclerView getListView();
        void showImageFondo(boolean mostrar);

    }
}
