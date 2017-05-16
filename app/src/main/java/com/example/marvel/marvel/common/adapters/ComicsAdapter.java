package com.example.marvel.marvel.common.adapters;

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
import com.example.marvel.marvel.R;
import com.example.marvel.marvel.common.rest.comics.Comic;
import com.example.marvel.marvel.listComisc.presenter.ListComicsPresenter;

import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by neon2004 on 28/01/2017.
 */


public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>  {


    RelativeLayout activityMain;
    public ListComicsPresenter callback;
    private ArrayList<Comic> datos;
    private static Context ctx;
    private ComicsViewHolder tvh;
    private View.OnClickListener listener;


//    @OnClick(R.id.card)
//    public void onClick() {
//        listener.goDetail(tvh.getComic());
//    }

     public class ComicsViewHolder extends RecyclerView.ViewHolder {

         ImageView imgComicList;
         TextView tvNamelist;
         CardView card;


        public Comic getComic() {
            return comic;
        }

        private  Comic comic;

        public ComicsViewHolder(View itemView) {
            super(itemView);

            imgComicList = (ImageView)itemView.findViewById(R.id.imgComicList);
            tvNamelist = (TextView)itemView.findViewById(R.id.tvNamelist);
            card = (CardView)itemView.findViewById(R.id.card);


        }

        public void bindComic(Comic comic) {
            this.comic = comic;
            tvNamelist.setText(comic.getTitulo());
            Glide.with(ctx).load(comic.getImageUrlOK())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .centerCrop()
                    .animate(android.R.anim.fade_in)
                    .into(imgComicList);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.goDetail(datos.get(getAdapterPosition()));
                }
            });
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
        tvh = new ComicsViewHolder(itemView);

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

}
