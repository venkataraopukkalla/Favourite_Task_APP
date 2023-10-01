package com.vikas.favouriteapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CategoryManger {
    Context context;

    public CategoryManger(Context context) {
        this.context = context;
    }

    public void saveCategoryDetails(Model model){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor  edit = sharedPreferences.edit();
        Set<String> set=new HashSet(model.getListOfCategoryNames());
        edit.putStringSet(model.getCategoryName(),set);
        edit.apply();
    }
    public ArrayList<Model> retrieveData(){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        Map<String, ?> item = sharedPreferences.getAll();
        ArrayList<Model> list=new ArrayList<>();
        for(Map.Entry<String ,?> entry:item.entrySet() ){
          Model model=  new Model(entry.getKey(),new ArrayList<String>((Set) entry.getValue()));
           list.add(model);
        }
        return  list;
    }
}
