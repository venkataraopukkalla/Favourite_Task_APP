package com.vikas.favouriteapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickedInterface {
     RecyclerView mrecyclerView;
     FloatingActionButton mAdd;
     CategoryManger categoryManger=new CategoryManger(this);
     //final key Value for passing Intent
    public  static  final String KEY_VALUE="VIKAS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrecyclerView=findViewById(R.id.recycleViewBtn);
        mAdd=findViewById(R.id.floatingAddbtn);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Model> Items = categoryManger.retrieveData();
//        ArrayList<Model> names=new ArrayList<>();
//        names.add(new Model("Food"));
//        names.add(new Model("Spots"));
//        names.add(new Model("News"));
//        names.add(new Model("Education"));
        mrecyclerView.setAdapter(new CategoryAdapter(Items,this));
       mAdd.setOnClickListener(e->alertDialogCategoriesList());
    }

    private void alertDialogCategoriesList() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Please enter New Category  ");
        EditText enterCategorieEdt=new EditText(this);
         enterCategorieEdt.setInputType(InputType.TYPE_CLASS_TEXT);
         builder.setView(enterCategorieEdt);
        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              categoryManger.saveCategoryDetails(new Model(enterCategorieEdt.getText()+"",new ArrayList<>()));
                ArrayList<Model> list = categoryManger.retrieveData();
                 mrecyclerView.setAdapter(new CategoryAdapter(list,MainActivity.this));

            }
        });
        builder.create().show();
    }
    // this method is use to when click on Category ..its move in to separe activity
    private  void moveCategoryItems(Model model){
        Intent intent=new Intent(this,CategoryItem.class);
        intent.putExtra(KEY_VALUE,model);
       // startActivity(intent);
        //noinspection deprecation
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==100 && resultCode==RESULT_OK && data!=null){
            categoryManger.saveCategoryDetails((Model) data.getSerializableExtra(KEY_VALUE));
            updateCatecgory();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateCatecgory() {
        ArrayList<Model> list = categoryManger.retrieveData();
        mrecyclerView.setAdapter(new CategoryAdapter(list,this));
    }

    //it is Interface method ----CategoryClickedInterface ---(CategoryAdapter avaible the interface)
    @Override
    public void isCategoryCliked(Model model) {
        moveCategoryItems(model);
    }
}