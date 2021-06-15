package com.example.movielist;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class CancelOrderAdapter extends RecyclerView.Adapter<CancelOrderAdapter.ViewHolder> {
    private Activity activity;
    private List<String> cancelOrderReasonSubModelsList;
    private int lastSelectedPosition = -1;

    public CancelOrderAdapter(MainActivity cancelOrderActivity, List<String> cancelOrderReasonSubModelsList) {
        this.activity= cancelOrderActivity;
        this.cancelOrderReasonSubModelsList=cancelOrderReasonSubModelsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return cancelOrderReasonSubModelsList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView new_register_functional_layout1_editext_name;
        private RadioButton new_cancel_order_radio_button;
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
