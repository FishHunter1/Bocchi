package com.example.bocchi.Proyecto.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bocchi.Proyecto.Adaptador.CategoryAdaptador;
import com.example.bocchi.Proyecto.Domain.CategoryDomain;
import com.example.bocchi.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerViewCategoryList();
        }

        private void recyclerViewCategoryList(){
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            recyclerViewCategoryList=findViewById(R.id.recyclerView);
            recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

            ArrayList<CategoryDomain> category=new ArrayList<>();
            category.add(new CategoryDomain("Pizza","cat_1"));
            category.add(new CategoryDomain("Burger","cat_2"));
            category.add(new CategoryDomain("Hotdog","cat_3"));
            category.add(new CategoryDomain("Drink","cat_4"));
            category.add(new CategoryDomain("Donut","cat_5"));

            adapter=new CategoryAdaptador(category);
            recyclerViewCategoryList.setAdapter(adapter);

        }
}
