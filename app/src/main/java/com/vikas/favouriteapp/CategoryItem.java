package com.vikas.favouriteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//this call is use to CategoryItems of category for example in sport selection : somany sports like cricket,kabadi....like
public class CategoryItem extends AppCompatActivity {
    private RecyclerView itemRecyclerView;
    private FloatingActionButton itemAddFlaotbtn;
    private  Model m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_item);
        // this is use to set tilte of current CategoryItem
        m= (Model) getIntent().getSerializableExtra(MainActivity.KEY_VALUE);
        setTitle(m.getCategoryName());
        itemAddFlaotbtn=findViewById(R.id.adddingItemFlaotBtn);
        itemRecyclerView=findViewById(R.id.itemRecycleview);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRecyclerView.setAdapter(new ItemAdapter(m));

        itemAddFlaotbtn.setOnClickListener(e->displayAlertDialer());
    }

    private void displayAlertDialer() {
        final String positiveBtnName="CREATE";
        EditText editText=new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("please enter "+m.getCategoryName()+" list");
        alertDialog.setView(editText);
        alertDialog.setPositiveButton(positiveBtnName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String value=editText.getText()+"";
                m.getListOfCategoryNames().add(value);
               itemRecyclerView.getAdapter().notifyItemInserted(m.getListOfCategoryNames().size()-1);
               // Toast.makeText(getApplicationContext(),m.getCategoryName()+" tapped",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).create().show();
    }

    @Override
    public void onBackPressed() {
        Bundle bundle=new Bundle();
        bundle.putSerializable(MainActivity.KEY_VALUE,m);
        Intent intent =new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}