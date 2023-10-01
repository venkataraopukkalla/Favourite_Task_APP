package com.vikas.favouriteapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
     TextView mIndividualCategory;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        mIndividualCategory=itemView.findViewById(R.id.categoryDesidnTxt);
    }



}
