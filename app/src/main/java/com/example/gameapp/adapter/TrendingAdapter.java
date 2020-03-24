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
import com.example.gameapp.model.TrendingModel;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.Holder> {
    private ArrayList<TrendingModel> arrayList;
    private LayoutInflater inflater;
    private Context context;

    public TrendingAdapter(ArrayList<TrendingModel> arrayList, Context context) {
        this.arrayList = arrayList;
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

        holder.textView.setText(arrayList.get(position).text);
        holder.imageView.setImageResource(arrayList.get(position).image);
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
