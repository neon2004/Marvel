package com.example.marvel.marvel.View.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.marvel.marvel.Adapters.ComicsAdapter;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IListComicsView;
import com.example.marvel.marvel.Presenter.ListComicsPresenter;
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.Utils.Constants;
import com.example.marvel.marvel.View.Activities.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListComicsFragments extends Fragment implements IListComicsView {

    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    @Bind(R.id.appbar)
    Toolbar appbar;
    @Bind(R.id.imageView)
    ImageView imageView;
    private ListComicsPresenter comicsListPresenter;


    public ListComicsFragments() {
    }


    public static ListComicsFragments newInstance(Bundle arguments) {
        ListComicsFragments f = new ListComicsFragments();
        if (arguments != null) {
            f.setArguments(arguments);
        }
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.list_comic_fragment, container, false);
        ButterKnife.bind(this, v);

        appbar.setTitle(R.string.app_name);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(this.comicsListPresenter == null){
            this.comicsListPresenter = new ListComicsPresenter(this, getActivity());
        }
        this.comicsListPresenter.start();
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
        MainActivity act = (MainActivity) getActivity();
        act.changeFragment(comic, Constants.TAG_DETAILCOMICSFR);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
