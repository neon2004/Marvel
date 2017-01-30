package com.example.marvel.marvel.Presenter;

import android.app.Activity;
import android.view.View;

import com.example.marvel.marvel.Adapters.ComicsAdapter;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IListComicsPresenter;
import com.example.marvel.marvel.Interfaces.IListComicsView;
import com.example.marvel.marvel.Model.ComicsInteractor;
import com.example.marvel.marvel.Utils.Constants;
import com.example.marvel.marvel.View.Activities.MainActivity;
import com.example.marvel.marvel.View.Fragments.ListComicsFragments;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.marvel.marvel.R.id.recView;

public class ListComicsPresenter implements IListComicsPresenter {


    private ComicsInteractor interactor;
    private ArrayList<Comic> listComics;
    private IListComicsView listComicsFragments;
    private Activity act;

    public ListComicsPresenter(IListComicsView listComicsFragments, Activity activity) {
        this.listComicsFragments = listComicsFragments;
        this.interactor = new ComicsInteractor(activity,this);
        this.act = activity;
    }
//    md5(ts+privateKey+publicKey)
    public void start(){
        Date d  = new Date();
        String ts = String.valueOf(d.getTime());
        ts = "1";
        String cadHashMD5 = ts+ Constants.TAG_APIKEY_PRIVATE+Constants.TAG_APIKEY_PUBLIC;
        String valueHash = md5(cadHashMD5);
        listComics  = interactor.getListComics(ts,valueHash);

//        ComicsAdapter adapter = new ComicsAdapter(listComics,act.getApplicationContext());
//        adapter.listener = this;
//        listComicsFragments.setListAdapter(adapter);
//        listComicsFragments.setLayoutManager();

    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void onItemClick(Comic comic){
        listComicsFragments.goToDetailContact(comic);
    }

    @Override
    public void createAdapter(ArrayList<Comic> listComics) {
        ComicsAdapter adapter = new ComicsAdapter(listComics,act.getApplicationContext());
        adapter.listener = this;
        listComicsFragments.setListAdapter(adapter);
        listComicsFragments.setLayoutManager();

    }
}
