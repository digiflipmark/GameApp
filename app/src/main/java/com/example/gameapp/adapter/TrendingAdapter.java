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
import com.example.gameapp.activites.TrendingActivity;
import com.example.gameapp.catemodel.TrendingModel;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.Holder> {
    private ArrayList<TrendingModel.ResultDataItem> trendarraylist;
    private LayoutInflater inflater;
    private Context context;

    public TrendingAdapter(ArrayList<TrendingModel.ResultDataItem> trendarraylist, Context context) {
        this.trendarraylist = trendarraylist;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TrendingAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.trending_lay, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.Holder holder, int position) {

        holder.textView.setText(trendarraylist.get(position).title);
        Glide.with(context).load(trendarraylist.get(position).feturedimage.get(0).mediafile).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, TrendingActivity.class);
                intent.putExtra("trendarraylist", trendarraylist);
                intent.putExtra("pos", position);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return trendarraylist.size();
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
