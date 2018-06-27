package org.bits_waves.waves2017.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.bits_waves.waves2017.listitems.WinnerItem;
import org.bits_waves.waves2017.R;

import java.util.List;

/**
 * Created by aryan on 11/7/17.
 */

public class NewWinnerAdapter extends RecyclerView.Adapter<NewWinnerAdapter.ViewHolder> {

    private List<WinnerItem> listItems;
    private Context context;

    public NewWinnerAdapter(List<WinnerItem> listItem, Context context) {
        this.listItems = listItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.winner_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WinnerItem listItem = listItems.get(position);
        holder.winner_name.setText(listItem.getWin_name());
        holder.event_name.setText(listItem.getEvent_Name());
        holder.win2.setText(listItem.getWin_name2());
        holder.win3.setText(listItem.getWin_name3());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView winner_name,win2,win3;
        public TextView event_name;
        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            event_name = itemView.findViewById(R.id.event_name);
            winner_name = itemView.findViewById(R.id.winner_name);
            win2= itemView.findViewById(R.id.winner_name1);
            win3 =  itemView.findViewById(R.id.winner_name2);
            linearLayout =  itemView.findViewById(R.id.linear_lay);
        }
    }
}
