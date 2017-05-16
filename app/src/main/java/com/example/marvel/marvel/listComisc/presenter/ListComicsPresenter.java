package com.example.marvel.marvel.listComisc.presenter;

import android.app.Activity;

import com.example.marvel.marvel.common.adapters.ComicsAdapter;
import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.common.rest.ComicsInteractor;
import com.example.marvel.marvel.common.utils.Constants;
import com.example.marvel.marvel.listComisc.contract.ListComicsContract;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;


public class ListComicsPresenter implements ListComicsContract.Presenter {


    private ComicsInteractor interactor;
    private ArrayList<Comic> listComics;
    private ListComicsContract.View listComicsFragments;
    private Activity act;

    public ListComicsPresenter(ListComicsContract.View listComicsFragments, Activity activity) {
        this.listComicsFragments = listComicsFragments;
        this.interactor = new ComicsInteractor(activity,this);
        this.act = activity;
    }
//    md5(ts+privateKey+publicKey)
    public void start(){
        listComicsFragments.showImageFondo(true);
        getDatos();
    }

    public void getDatos(){
        Date d  = new Date();
        String ts = String.valueOf(d.getTime());
        ts = "1";
        String cadHashMD5 = ts+ Constants.TAG_APIKEY_PRIVATE+Constants.TAG_APIKEY_PUBLIC;
        String valueHash = md5(cadHashMD5);
        listComics  = interactor.getListComics(ts,valueHash);
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
        listComicsFragments.showImageFondo(false);
        ComicsAdapter adapter = new ComicsAdapter(listComics,act.getApplicationContext());
        adapter.callback = this;
        listComicsFragments.setListAdapter(adapter);
        listComicsFragments.setLayoutManager();

    }

    @Override
    public void goDetail(Comic comic) {
        listComicsFragments.goToDetailContact(comic);
    }


}
