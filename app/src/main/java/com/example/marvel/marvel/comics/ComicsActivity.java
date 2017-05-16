package com.example.marvel.marvel.comics;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.example.marvel.marvel.R;
import com.example.marvel.marvel.common.base.BaseActivity;
import com.example.marvel.marvel.common.base.BaseFragment;
import com.example.marvel.marvel.common.dialogs.DialogoWifi;
import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.common.rest.IRestClient;

import com.example.marvel.marvel.common.utils.Constants;
import com.example.marvel.marvel.detailComic.DetailComicsFragments_;
import com.example.marvel.marvel.listComisc.ListComicsFragments;
import com.example.marvel.marvel.detailComic.DetailComicsFragments;
import com.example.marvel.marvel.listComisc.ListComicsFragments_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import retrofit2.Retrofit;

@EActivity(R.layout.activity_main)
public class ComicsActivity extends BaseActivity {

    @ViewById(R.id.contenedor)
    LinearLayout contenedor;


    private ListComicsFragments listComicsFragments;
    private DetailComicsFragments detailComicsFragments;
    public IRestClient interfaces;
    public BaseFragment FRAGMENT_ACTUAL;

    @AfterViews
    protected void ComiccActivityAfterViews() {

        crearRetrofitGson();

        if(isOnline()){
            changeFragment(null, Constants.TAG_LISTACOMICSFR);

        }else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoWifi dialogo = new DialogoWifi();
            dialogo.show(fragmentManager, "tagShowWifi");
        }
    }


    @Override
    public void onBackPressed() {
        if(FRAGMENT_ACTUAL instanceof ListComicsFragments){
            finish();
        }else{
            changeFragment(null, Constants.TAG_LISTACOMICSFR);
        }
    }

    // CAMBIAMOS EL FRAGMENT A MOSTRAR
    public void changeFragment(Comic comic, String framgenCargar) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        switch (framgenCargar) {
            case Constants.TAG_LISTACOMICSFR:
                if (listComicsFragments == null) {
                    listComicsFragments = ListComicsFragments_.builder().build();
                }
                FRAGMENT_ACTUAL = listComicsFragments;
                ft.replace(android.R.id.content, listComicsFragments);
                ft.commit();

                break;
            case Constants.TAG_DETAILCOMICSFR:

                detailComicsFragments = DetailComicsFragments_.builder().comic(comic).build();
                FRAGMENT_ACTUAL = detailComicsFragments;
                ft.replace(android.R.id.content, detailComicsFragments);
                ft.commit();
                break;
        }
    }
}
