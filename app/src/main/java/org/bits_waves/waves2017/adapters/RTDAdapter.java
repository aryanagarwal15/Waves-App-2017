package org.bits_waves.waves2017.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.bits_waves.waves2017.R;
import org.bits_waves.waves2017.listitems.RTDItem;

import java.util.List;

/**
 * Created by aryan on 3/9/17.
 */

public class RTDAdapter extends RecyclerView.Adapter<RTDAdapter.ViewHolder> {
    private List<RTDItem> listItems;


    public RTDAdapter(List<RTDItem> moviesList, Context context) {
        this.listItems = moviesList;
        Context context1 = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rtd_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RTDItem listItem = listItems.get(position);
        holder.head.setText(listItem.getHead());
        holder.desc.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView head;
        public TextView desc;
        public LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            head = itemView.findViewById(R.id.heading);
            desc = itemView.findViewById(R.id.desc);

            linearLayout =  itemView.findViewById(R.id.linear_lay);
        }
    }
}
