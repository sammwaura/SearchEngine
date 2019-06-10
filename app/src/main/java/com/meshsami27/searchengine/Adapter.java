package com.meshsami27.searchengine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> implements Filterable {
    private Context context;
    private ArrayList<Search> searcher;
    private ArrayList<Search> searcherFiltered;


    public Adapter(Context context, ArrayList <Search> searcher) {
        this.context = context;
        this.searcher = searcher;
        searcherFiltered = new ArrayList <>(searcher);

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
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_name, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final Search search = searcher.get(position);
        holder.tv_name.setText(searcher.get(position).getName());
//        holder.tv_name.setText(search.getName());
    }

    @Override
    public int getItemCount() {
        return searcher.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()){

                    searcherFiltered = searcher;
                } else {
                    ArrayList<Search> filteredList = new ArrayList <>();

                    for (Search search : searcher){

                        if (search.getName().toLowerCase().contains(charString)){

                            filteredList.add(search);
                        }
                    }

                    searcherFiltered = filteredList;
                }

                FilterResults results = new FilterResults();
                results.values = searcherFiltered;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                searcherFiltered = (ArrayList<Search>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}
