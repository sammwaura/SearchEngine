package com.meshsami27.searchengine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    private Context context;
    private ArrayList<Search> search;


    public Adapter(Context context, ArrayList<Search> search) {
        this.context = context;
        this.search = search;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        public CardView card_item;
        public RelativeLayout mainCard;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
            card_item = itemView.findViewById(R.id.card_item);
            mainCard = itemView.findViewById(R.id.mainCard);

        }
    }

    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_name, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {
        final Search search1 = search.get(position);
        holder.tv_name.setText(search.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return search.size();
    }


}
