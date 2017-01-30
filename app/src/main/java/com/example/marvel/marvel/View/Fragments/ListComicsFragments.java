package com.example.marvel.marvel.View.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.RelativeLayout;

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
    RelativeLayout activityMain;
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
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.comicsListPresenter = new ListComicsPresenter(this,getActivity());
        this.comicsListPresenter.start();
    }


    @Override
    public void setListAdapter(ComicsAdapter adapter) {
        recView.setAdapter(adapter);
    }

    @Override
    public void setLayoutManager() {
        recView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
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
