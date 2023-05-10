package com.example.bocchi.Proyecto.Adaptador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bocchi.Proyecto.Activity.ShowDetailActivity;
import com.example.bocchi.Proyecto.Domain.CategoryDomain;
import com.example.bocchi.Proyecto.Domain.FoodDomain;
import com.example.bocchi.R;

import java.util.ArrayList;

public class PopularAdaptador extends RecyclerView.Adapter<PopularAdaptador.ViewHolder> {
    ArrayList<FoodDomain> PopularFood;

    public PopularAdaptador(ArrayList<FoodDomain> categoryDomains) {
        this.PopularFood = PopularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdaptador.ViewHolder holder, int position) {

        holder.title.setText(PopularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(PopularFood.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(PopularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", PopularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return PopularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        TextView addBtn;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}
