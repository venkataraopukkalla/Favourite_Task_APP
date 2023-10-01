package com.vikas.favouriteapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable {
    private  String categoryName;
    private ArrayList<String>listOfCategoryNames;

    public Model(String categoryName) {
        this.categoryName = categoryName;
    }

    public Model(String categoryName, ArrayList<String> listOfCategoryNames) {
        this.categoryName = categoryName;
        this.listOfCategoryNames = listOfCategoryNames;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<String> getListOfCategoryNames() {
        return listOfCategoryNames;
    }
}
