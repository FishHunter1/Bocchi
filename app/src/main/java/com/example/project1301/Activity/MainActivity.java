package com.example.project1301.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.project1301.Adapter.FoodListAdapter;
import com.example.project1301.Domain.FoodDomain;
import com.example.project1301.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;

    private ImageView btn_cerrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cerrar = findViewById(R.id.btn_cerrar);
        btn_cerrar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "Sesion Cerrada", Toast.LENGTH_SHORT).show();
            gologing();
          }
        });

        initRecyclerview();
        bottomNavigation();
    }

    private void gologing(){
      Intent i = new Intent(this,LoginActivity.class);
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(i);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        @SuppressLint("WrongViewCast") LinearLayout configBtn=findViewById(R.id.configBtn);

        configBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ConfigActivity.class)));

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Hamburguesa La Bocchi","Es una deliciosa creación que combina ingredientes de alta calidad en una pan suave y esponjoso. Presenta una jugosa y sabrosa carne de res, sazonada a la perfeccion,acompañada de queso derretido que le aporta un toque cremoso. Además viene con la salsa de la casa, La Bocchida.","comida1",20000,30,120,4.1));
        items.add(new FoodDomain("Pizza Peperoni","Se prepara con una base de masa crujiente y esponjosa, cubierta generosamente con salsa de tomate. Sobre esta salsa se distribuyen rodajas delgadas de pepperoni, un tipo de salami picante, que se dora y se vuelve crujiente al hornearse. El queso mozzarella se derrite sobre el pepperoni, creando una capa de cobertura cremosa y deliciosa."
                ,"comida2",10000,25,200,4.8));
        items.add(new FoodDomain("Pizza Vegana","es una opción deliciosa y saludable para aquellos que siguen una dieta basada en plantas. En lugar de usar ingredientes de origen animal, esta pizza se prepara con una base de masa fina y crujiente, generalmente hecha con harina integral o sin gluten. La salsa de tomate se utiliza como base, ofreciendo un sabor clásico y sabroso."
                ,"comida3",13000,30,100,3.5));
        items.add(new FoodDomain("Perro Caliente","Se complementa con una variedad de ingredientes y aderezos. Algunas opciones populares son la salsa de tomate, mostaza, kétchup, mayonesa, cebolla picada, pepinillos encurtidos y chucrut. Estos ingredientes añaden sabores contrastantes y texturas a la experiencia del perro caliente."
                ,"comida4",7000,15,50,4.3));
        items.add(new FoodDomain("Malteada de Fresa","Es una deliciosa bebida dulce y refrescante que combina el sabor dulce y jugoso de las fresas con una base cremosa y suave. Se prepara mezclando fresas frescas o jarabe de fresa con helado de vainilla o crema batida."
                ,"comida5",9000,10,145,4.8));
        items.add(new FoodDomain("Limonada de Coco","Es una refrescante bebida que combina la acidez del limón con la dulzura y el sabor tropical del coco. Para prepararla, se mezcla jugo de limón fresco con agua, azúcar o algún edulcorante natural al gusto y leche de coco."
                ,"comida6",9500,10,140,3.9));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }
}
