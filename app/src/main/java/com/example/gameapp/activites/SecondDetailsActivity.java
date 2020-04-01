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
import com.example.gameapp.databinding.ActivitySecondDetailsBinding;

import java.util.ArrayList;

public class SecondDetailsActivity extends AppCompatActivity {

    private ActivitySecondDetailsBinding binding;
    private ArrayList<CateTwoModel.ResultDataItem> catetwo;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_second_details);


        catetwo=(ArrayList<CateTwoModel.ResultDataItem>) getIntent().getSerializableExtra("catetwo");
        pos=getIntent().getIntExtra("pos",0);


        binding.title.setText(catetwo.get(pos).title);
        binding.des.setText(catetwo.get(pos).description);
        Glide.with(SecondDetailsActivity.this).load(catetwo.get(pos).bannerimage.get(0).mediafile).into(binding.image);
        binding.buttonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= String.valueOf(catetwo.get(pos).gameurl);

            }
        });
    }
    }

