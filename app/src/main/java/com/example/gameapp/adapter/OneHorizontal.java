package com.example.gameapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gameapp.R;
import com.example.gameapp.activites.OneCatogaryActivity;
import com.example.gameapp.activites.TwoCatogaryActivity;
import com.example.gameapp.model.CategorylistModel;

import java.util.ArrayList;

public class OneHorizontal extends RecyclerView.Adapter<OneHorizontal.Holder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<CategorylistModel.ResultDataItem> arrayList;


    public OneHorizontal(Context context, ArrayList<CategorylistModel.ResultDataItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public OneHorizontal.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lay_row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OneHorizontal.Holder holder, int position) {


        Glide.with(context).load(arrayList.get(position).catImage).into(holder.imageView);
        /*holder.imageView.setImageResource(models.get(position).image);*/
        holder.textView.setText(arrayList.get(position).catName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.getAdapterPosition() == 0) {
                    Intent intent = new Intent(context, OneCatogaryActivity.class);
                    intent.putExtra("name",arrayList);
                    intent.putExtra("pos",position);
                    context.startActivity(intent);
                }

                if (holder.getAdapterPosition() == 1) {
                    Intent intent = new Intent(context, TwoCatogaryActivity.class);
                    intent.putExtra("name",arrayList);
                    intent.putExtra("pos",position);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.im1);
            textView = itemView.findViewById(R.id.tx1);
        }
    }
}
