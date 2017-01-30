package com.example.marvel.marvel.View.Activities;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.marvel.marvel.Base.BaseActivity;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.INetwork;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.Utils.Constants;
import com.example.marvel.marvel.View.Fragments.DetailComicsFragments;
import com.example.marvel.marvel.View.Fragments.ListComicsFragments;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {

    @Bind(R.id.contenedor)
    LinearLayout contenedor;


    private ListComicsFragments listComicsFragments;
    private DetailComicsFragments detailComicsFragments;
    public Retrofit retrofit;
    public INetwork interfaces;
    public Fragment FRAGMENT_ACTUAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        if (isOnline()) {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.TAG_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            interfaces = retrofit.create(INetwork.class);

            changeFragment(null, Constants.TAG_LISTACOMICSFR);
        } else {
            showError(getString(R.string.errorNoInternet));
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

    private void showError(String string) {
        Snackbar.make(contenedor, string, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
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
