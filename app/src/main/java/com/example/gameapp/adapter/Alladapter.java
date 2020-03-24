package com.example.gameapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameapp.R;
import com.example.gameapp.model.AllModel;

import java.util.ArrayList;

public class Alladapter extends RecyclerView.Adapter<Alladapter.Holder> {

    private ArrayList<AllModel> allModels;
    private Context context;
    private LayoutInflater inflater;

    public Alladapter(ArrayList<AllModel> allModels,Context context) {
        this.allModels = allModels;
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

        holder.textView.setText(allModels.get(position).text);
        holder.imageView.setImageResource(allModels.get(position).image);
    }

    @Override
    public int getItemCount() {
        return allModels.size();
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
