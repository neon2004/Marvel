package com.example.marvel.marvel.common.rest;

import android.app.Activity;
import android.util.Log;


import com.example.marvel.marvel.R;
import com.example.marvel.marvel.comics.ComicsActivity;
import com.example.marvel.marvel.common.base.BaseActivity;
import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.common.rest.comics.ComicsResult;
import com.example.marvel.marvel.common.rest.comics.Result;
import com.example.marvel.marvel.listComisc.presenter.ListComicsPresenter;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by neon2004 on 29/01/2017.
 */

public class ComicsInteractor {
    private ComicsActivity act;
    private ListComicsPresenter callback;


    public ComicsInteractor(Activity activity, ListComicsPresenter listComicsPresenter) {
        act = (ComicsActivity) activity;
        callback = listComicsPresenter;
    }

    public ArrayList<Comic> getListComics(String ts, String valueHash){
        final ArrayList<Comic> lisresult = new ArrayList<Comic>();
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("ts",ts);
        params.put("hash",valueHash);

        Call<ComicsResult> call = BaseActivity.interfaces.getSeriesComics(params);
        call.enqueue(new Callback<ComicsResult>() {
            @Override
            public void onResponse(Call<ComicsResult> call, Response<ComicsResult> response) {
                if(response.isSuccessful()){
                    Comic c = null;
                    for ( Result item :response.body().getData().getResults()) {
                        c =  new Comic(item.getId(),item.getThumbnail().getPath(),item.getThumbnail().getExtension(),item.getDescription(),
                                item.getTitle(),item.getCreators().getItems().get(0).getName());

                        lisresult.add(c);
                    }

                    callback.createAdapter(lisresult);
                }else{
                    act.showSnackbar(act.getString(R.string.errorGetDatos));
                }
            }

            @Override
            public void onFailure(Call<ComicsResult> call, Throwable t) {
                act.showSnackbar(act.getString(R.string.errorGetDatos));
            }
        });


        return null;
    }
}
