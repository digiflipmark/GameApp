package com.example.gameapp.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gameapp.R;
import com.example.gameapp.catemodel.CateOneModel;
import com.example.gameapp.catemodel.TrendingModel;
import com.example.gameapp.databinding.ActivityTrendingBinding;

import java.util.ArrayList;

public class TrendingActivity extends AppCompatActivity {

    private ArrayList<TrendingModel.ResultDataItem> trenindgarray;
    private ActivityTrendingBinding binding;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_trending);


        trenindgarray=(ArrayList<TrendingModel.ResultDataItem>) getIntent().getSerializableExtra("trendarraylist");
        pos=getIntent().getIntExtra("pos",0);


        binding.title.setText(trenindgarray.get(pos).title);
        binding.des.setText(trenindgarray.get(pos).description);
        Glide.with(TrendingActivity.this).load(trenindgarray.get(pos).bannerimage.get(0).mediafile).into(binding.image);
        binding.buttonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= String.valueOf(trenindgarray.get(pos).gameurl);
                Toast.makeText(TrendingActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
    }


    }

