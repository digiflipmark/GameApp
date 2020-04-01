package com.example.gameapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gameapp.Interfaces.ItemclickListener;
import com.example.gameapp.R;
import com.example.gameapp.catemodel.CateOneModel;
import com.example.gameapp.catemodel.CateTwoModel;

import java.util.ArrayList;

public class TwocAdapter extends RecyclerView.Adapter<TwocAdapter.Holder> {
    private ArrayList<CateTwoModel.ResultDataItem> catetwo;
    private Context context;
    private LayoutInflater inflater;
    ItemclickListener itemclickListenerl;

    public TwocAdapter(ArrayList<CateTwoModel.ResultDataItem> catetwo, Context context, ItemclickListener itemclickListener1) {
        this.catetwo = catetwo;
        this.context = context;
        this.itemclickListenerl=itemclickListener1;
        inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TwocAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.game_lay,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwocAdapter.Holder holder, int position) {

        holder.textView.setText(catetwo.get(position).title);
        Glide.with(context).load(catetwo.get(position).feturedimage.get(0).mediafile).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemclickListenerl.click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return catetwo.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.im1);
            textView=itemView.findViewById(R.id.tx1);
        }
    }
}
