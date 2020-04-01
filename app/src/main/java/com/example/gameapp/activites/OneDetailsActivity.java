package com.example.gameapp.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gameapp.R;
import com.example.gameapp.catemodel.CateOneModel;
import com.example.gameapp.catemodel.CateTwoModel;
import com.example.gameapp.databinding.ActivityOneDetailsBinding;

import java.util.ArrayList;

public class OneDetailsActivity extends AppCompatActivity {

    private ActivityOneDetailsBinding binding;
    private ArrayList<CateOneModel.ResultDataItem> cateonemodel;


    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_one_details);

        cateonemodel=(ArrayList<CateOneModel.ResultDataItem>) getIntent().getSerializableExtra("model");
        pos=getIntent().getIntExtra("pos",0);


            binding.title.setText(cateonemodel.get(pos).title);
            binding.des.setText(cateonemodel.get(pos).description);
            Glide.with(OneDetailsActivity.this).load(cateonemodel.get(pos).bannerimage.get(0).mediafile).into(binding.image);
            binding.buttonPanel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url= String.valueOf(cateonemodel.get(pos).gameurl);
                    Toast.makeText(OneDetailsActivity.this, "ok", Toast.LENGTH_SHORT).show();
                }
            });
        }

        }







