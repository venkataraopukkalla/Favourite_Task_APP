package com.vikas.favouriteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    Context context;
    ArrayList<Model> box;
    //to create a interface for CategoryItem .if u clicked an categroy
    public interface CategoryClickedInterface{
        public void isCategoryCliked(Model model);
    }
     CategoryClickedInterface categoryClickedInterface;

    public CategoryAdapter( ArrayList<Model> box,CategoryClickedInterface categoryClickedInterface) {
        this.box = box;
        this.categoryClickedInterface=categoryClickedInterface;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cateoryviewholder,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
      holder.mIndividualCategory.setText(box.get(position).getCategoryName());
      //if u click any Category that time call this
      holder.itemView.setOnClickListener(e->{
          categoryClickedInterface.isCategoryCliked(box.get(position));
      });
    }

    @Override
    public int getItemCount() {
        return box.size();
    }
}
