package com.example.marvel.marvel.View.Activities.Base;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.marvel.marvel.Interfaces.INetwork;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.Utils.Constants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseActivity extends AppCompatActivity {

    public boolean isOnline = false;
    public Retrofit retrofit;
    public INetwork interfaces;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.TAG_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        interfaces = retrofit.create(INetwork.class);

        isOnline();
    }

    public abstract int getLayoutId();


    private void isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isOnline = activeNetwork != null && activeNetwork.isConnected();


    }

    public void showError(View vista, String string) {
        Snackbar.make(vista, string, Snackbar.LENGTH_LONG).show();
    }
}


