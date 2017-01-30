package com.example.marvel.marvel.View.Activities;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.marvel.marvel.Base.BaseActivity;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.Utils.Constants;
import com.example.marvel.marvel.View.Fragments.DetailComicsFragments;
import com.example.marvel.marvel.View.Fragments.ListComicsFragments;

public class MainActivity extends BaseActivity {

    private ListComicsFragments listComicsFragments;
    private DetailComicsFragments detailComicsFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeFragment(null, Constants.TAG_LISTACOMICSFR);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    // CAMBIAMOS EL FRAGMENT A MOSTRAR
    public void changeFragment(Comic comic, String framgenCargar){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        Bundle arguments = new Bundle();

        switch (framgenCargar) {
            case Constants.TAG_LISTACOMICSFR:
                if(listComicsFragments == null ){
                    listComicsFragments = ListComicsFragments.newInstance(arguments);
                }
                ft.replace(android.R.id.content, listComicsFragments);
                ft.commit();

                break;
            case Constants.TAG_DETAILCOMICSFR:
                arguments.putSerializable("comic",comic);
                if(listComicsFragments == null ){
                    detailComicsFragments = DetailComicsFragments.newInstance(arguments);
                }
                ft.replace(android.R.id.content, listComicsFragments);
                ft.commit();
                break;

        }
    }
}
