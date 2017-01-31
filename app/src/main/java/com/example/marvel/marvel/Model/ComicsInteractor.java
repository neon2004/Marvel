package com.example.marvel.marvel.Model;

import android.app.Activity;
import android.util.Log;

import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Comics.ComicsResult;
import com.example.marvel.marvel.Comics.Result;
import com.example.marvel.marvel.Interfaces.IListComicsPresenter;
import com.example.marvel.marvel.Presenter.ListComicsPresenter;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.View.Activities.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by neon2004 on 29/01/2017.
 */

public class ComicsInteractor {
    private MainActivity act;
    private IListComicsPresenter callback;

    public ComicsInteractor(Activity activity, ListComicsPresenter listComicsPresenter) {
        act = (MainActivity) activity;
        callback = listComicsPresenter;
    }

    public ArrayList<Comic> getListComics(String ts, String valueHash){
        final ArrayList<Comic> lisresult = new ArrayList<Comic>();
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("ts",ts);
        params.put("hash",valueHash);

        Call<ComicsResult> call = act.interfaces.getSeriesComics(params);
        call.enqueue(new Callback<ComicsResult>() {
            @Override
            public void onResponse(Call<ComicsResult> call, Response<ComicsResult> response) {
                if(response.isSuccessful()){
                    Comic c = null;
                    for ( Result  item :response.body().getData().getResults()) {
                        c =  new Comic(item.getId(),item.getThumbnail().getPath(),item.getThumbnail().getExtension(),item.getDescription(),
                                item.getTitle(),item.getCreators().getItems().get(0).getName());

                        lisresult.add(c);
                    }

                    callback.createAdapter(lisresult);
                }else{
                    act.showError(act.contenedor,act.getString(R.string.errorGetDatos));
                }
            }

            @Override
            public void onFailure(Call<ComicsResult> call, Throwable t) {
                act.showError(act.contenedor,act.getString(R.string.errorGetDatos));
            }
        });


        return null;
    }
}
