package com.vikas.favouriteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private  Model model;
      public  ItemAdapter(Model model){
         this.model=model;
      }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.mtextView.setText(String.valueOf(model.getListOfCategoryNames().get(position))+"");
    }

    @Override
    public int getItemCount() {
        return model.getListOfCategoryNames().size();
    }
}
