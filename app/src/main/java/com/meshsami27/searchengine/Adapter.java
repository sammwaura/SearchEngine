package com.meshsami27.searchengine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    private Context context;
    private ArrayList<Search> search;


    public Adapter(Context context, ArrayList<Search> search) {
        this.context = context;
        this.search = search;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
