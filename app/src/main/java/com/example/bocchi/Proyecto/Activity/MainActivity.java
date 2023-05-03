package com.example.bocchi.Proyecto.Activity;

import android.os.Bundle;

import com.example.bocchi.Proyecto.Adaptador.CategoryAdaptador;
import com.example.bocchi.Proyecto.Adaptador.PopularAdaptador;
import com.example.bocchi.Proyecto.Domain.CategoryDomain;
import com.example.bocchi.Proyecto.Domain.FoodDomain;
import com.example.bocchi.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerViewCategoryList();
            recyclerViewPopular();
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
        private void recyclerViewPopular(){
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            recyclerViewCategoryList=findViewById(R.id.recyclerView2);

            ArrayList<FoodDomain> foodList=new ArrayList<>();
            foodList.add(new FoodDomain("Pepperoni Pizza","pizza1","slices pepperoni,mozzarella cheese,fresh oregano, ground black pepper,pizza sauce",9.76));
            foodList.add(new FoodDomain("Cheese Burger","burger","beef, Gouda Cheese, Special Sauce, Lettuce, tomato",8.79));
            foodList.add(new FoodDomain("Vegetable Pizza","pizza2","olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil",8.50));

            adapter2=new PopularAdaptador(foodList);
            recyclerViewPopularList.setAdapter(adapter2);

        }
}
