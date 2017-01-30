package com.example.marvel.marvel.Interfaces;

import com.example.marvel.marvel.Comics.ComicsResult;
import com.example.marvel.marvel.Utils.Constants;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by neon2004 on 28/01/2017.
 */

public interface INetwork {
    @GET(Constants.TAG_PARAM_URL)
    Call<ComicsResult> getSeriesComics(@QueryMap Map<String, String> options);


}
