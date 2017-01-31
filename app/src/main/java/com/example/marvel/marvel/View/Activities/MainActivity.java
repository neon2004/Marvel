package com.example.marvel.marvel.View.Activities;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.example.marvel.marvel.View.Activities.Base.BaseActivity;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Dialogs.DialogoWifi;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.Utils.Constants;
import com.example.marvel.marvel.View.Fragments.DetailComicsFragments;
import com.example.marvel.marvel.View.Fragments.ListComicsFragments;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.contenedor)
    public LinearLayout contenedor;


    private ListComicsFragments listComicsFragments;
    private DetailComicsFragments detailComicsFragments;
    public Fragment FRAGMENT_ACTUAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        if (isOnline) {
            changeFragment(null, Constants.TAG_LISTACOMICSFR);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoWifi dialogo = new DialogoWifi();
            dialogo.show(fragmentManager, "tagShowWifi");
        }
    }

    @Override
    public void onBackPressed() {
        if (FRAGMENT_ACTUAL instanceof ListComicsFragments) {
            finish();
        } else {
            changeFragment(null, Constants.TAG_LISTACOMICSFR);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    // CAMBIAMOS EL FRAGMENT A MOSTRAR
    public void changeFragment(Comic comic, String framgenCargar) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        Bundle arguments = new Bundle();

        switch (framgenCargar) {
            case Constants.TAG_LISTACOMICSFR:

                if (listComicsFragments == null) {
                    listComicsFragments = ListComicsFragments.newInstance(arguments);
                }
                FRAGMENT_ACTUAL = listComicsFragments;
                ft.replace(android.R.id.content, listComicsFragments);
                ft.commit();

                break;
            case Constants.TAG_DETAILCOMICSFR:

                arguments.putSerializable("comic", comic);
                detailComicsFragments = null;
                detailComicsFragments = DetailComicsFragments.newInstance(arguments);
                FRAGMENT_ACTUAL = detailComicsFragments;
                ft.replace(android.R.id.content, detailComicsFragments);
                ft.commit();
                break;

        }
    }
}