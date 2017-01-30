package com.example.marvel.marvel.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marvel.marvel.Comics.Comic;
import com.example.marvel.marvel.Interfaces.IListComicsView;
import com.example.marvel.marvel.Presenter.ListComicsPresenter;
import com.example.marvel.marvel.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by neon2004 on 28/01/2017.
 */

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {

    @Bind(R.id.imgComicList)
    static
    ImageView imgComicList;
    @Bind(R.id.tvNamelist)
    static
    TextView tvNamelIST;
    @Bind(R.id.card)
    CardView card2;
    @Bind(R.id.rlCard)
    RelativeLayout activityMain;
    public ListComicsPresenter listener;
    private ArrayList<Comic> datos;
    private static Context ctx;



    @OnClick(R.id.card)
    public void onClick() {
    }

    public  class ComicsViewHolder extends RecyclerView.ViewHolder {

        public ComicsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindComic(Comic comic) {
            tvNamelIST.setText(comic.getTitulo());
            Glide.with(ctx).load(comic.getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .placeholder(R.drawable)
//                    .error(R.drawable.loaderror)
                    .into(imgComicList);
//            listener.goToDetailContact(comic);
            listener.onItemClick(comic);
        }
    }

    public ComicsAdapter(ArrayList<Comic> datos, Context context) {
        this.datos = datos;
        this.ctx = context;
    }

    @Override
    public ComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        ComicsViewHolder tvh = new ComicsViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(ComicsViewHolder viewHolder, int pos) {
        Comic item = datos.get(pos);
        viewHolder.bindComic(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

//    public void setOnClickListener(View.OnClickListener listener) {
//        this.listener = listener;
//    }

//    @Override
//    public void onClick(View view) {
//        if (listener != null)
//            listener.onClick(view);
//    }
}