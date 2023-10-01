package com.vikas.favouriteapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView mtextView;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        mtextView=itemView.findViewById(R.id.ItemTextView);

    }
}
