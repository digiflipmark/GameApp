package com.example.gameapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameapp.R;
import com.example.gameapp.model.OneModel;

import java.util.ArrayList;

public class OneHorizontal extends RecyclerView.Adapter<OneHorizontal.Holder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<OneModel> models;

    public OneHorizontal(Context context, ArrayList<OneModel> models) {
        this.context = context;
        this.models = models;
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

        holder.imageView.setImageResource(models.get(position).image);
        holder.textView.setText(models.get(position).text);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.getAdapterPosition() == 0) {
                    Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
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
