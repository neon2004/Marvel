package com.example.marvel.marvel.common.rest;

import com.example.marvel.marvel.common.rest.comics.ComicsResult;
import com.example.marvel.marvel.common.utils.Constants;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by neon2004 on 28/01/2017.
 */

public interface IRestClient {
    @GET(Constants.TAG_PARAM_URL)
    Call<ComicsResult> getSeriesComics(@QueryMap Map<String, String> options);


}
