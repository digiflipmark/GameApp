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
import com.example.gameapp.activites.AllRandomActivity;
import com.example.gameapp.catemodel.RandomModel;

import java.util.ArrayList;

public class Alladapter extends RecyclerView.Adapter<Alladapter.Holder> {

    private ArrayList<RandomModel.ResultDataItem> randomModels;
    private Context context;
    private LayoutInflater inflater;

    public Alladapter(ArrayList<RandomModel.ResultDataItem> randomModels, Context context) {
        this.randomModels = randomModels;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Alladapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.all_lay, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Alladapter.Holder holder, int position) {

        holder.textView.setText(randomModels.get(position).title);
        Glide.with(context).load(randomModels.get(position).feturedimage.get(0).mediafile).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, AllRandomActivity.class);
                intent.putExtra("model",randomModels);
                intent.putExtra("pos",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return randomModels.size();
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
