package com.example.project1301.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project1301.Adapter.FoodListAdapter;
import com.example.project1301.Domain.FoodDomain;
import com.example.project1301.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Hamburguesa La Bocchi","Es una deliciosa creacion que combina ingredientes de alta calidad en una pan suave y esponjoso. Presenta una jugosa y sabrosa carne de res, sazonada a la perfeccion,acompañada de queso derretido que le aporta un toque cremoso.ademas viene con la salsa de la casa La Bocchida","fast_1",20000,30,120,4.1));
        items.add(new FoodDomain("Pizza Peperoni","Se prepara con una base de masa crujiente y esponjosa, cubierta generosamente con salsa de tomate. Sobre esta salsa se distribuyen rodajas delgadas de pepperoni, un tipo de salami picante, que se dora y se vuelve crujiente al hornearse. El queso mozzarella se derrite sobre el pepperoni, creando una capa de cobertura cremosa y deliciosa."
                ,"fast_2",10000,25,200,4.8));
        items.add(new FoodDomain("Pizza Vegana","es una opción deliciosa y saludable para aquellos que siguen una dieta basada en plantas. En lugar de usar ingredientes de origen animal, esta pizza se prepara con una base de masa fina y crujiente, generalmente hecha con harina integral o sin gluten. La salsa de tomate se utiliza como base, ofreciendo un sabor clásico y sabroso."
                ,"fast_3",13000,30,100,3.5));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }
}