package com.example.marvel.marvel.listComisc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.marvel.marvel.R;
import com.example.marvel.marvel.common.adapters.ComicsAdapter;
import com.example.marvel.marvel.common.base.BaseFragment;
import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.listComisc.contract.ListComicsContract;
import com.example.marvel.marvel.listComisc.presenter.ListComicsPresenter;
import com.example.marvel.marvel.common.utils.Constants;
import com.example.marvel.marvel.comics.ComicsActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * A placeholder fragment containing a simple view.
 */

@EFragment(R.layout.list_comic_fragment)
public class ListComicsFragments extends BaseFragment implements ListComicsContract.View {

    @ViewById(R.id.recView)
    RecyclerView recView;
    @ViewById(R.id.activity_main)
    LinearLayout activityMain;
    @ViewById(R.id.appbar)
    Toolbar appbar;
    @ViewById(R.id.imageView)
    ImageView imageView;
    private ListComicsPresenter comicsListPresenter;

    @AfterViews
    protected void listComicsFragmentsAfterViews() {

        this.comicsListPresenter = new ListComicsPresenter(this, getActivity());
        this.comicsListPresenter.start();
        appbar.setTitle(R.string.app_name);

    }

    @Override
    public void setListAdapter(ComicsAdapter adapter) {
        recView.setAdapter(adapter);
    }

    @Override
    public void setLayoutManager() {
        recView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public RecyclerView getListView() {
        return recView;
    }

    @Override
    public void showImageFondo(boolean mostrar) {
        if (mostrar){
            imageView.setVisibility(View.VISIBLE);
            recView.setVisibility(View.GONE);
        }else{
            imageView.setVisibility(View.GONE);
            recView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void goToDetailContact(Comic comic) {
        ComicsActivity act = (ComicsActivity) getActivity();
        act.changeFragment(comic, Constants.TAG_DETAILCOMICSFR);
    }

}
