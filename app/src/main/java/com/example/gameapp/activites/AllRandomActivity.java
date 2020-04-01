package com.example.gameapp.activites;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.example.gameapp.R;
import com.example.gameapp.catemodel.RandomModel;
import com.example.gameapp.databinding.ActivityAllRandomBinding;

import java.util.ArrayList;

public class AllRandomActivity extends AppCompatActivity {

    private ActivityAllRandomBinding binding;
    private ArrayList<RandomModel.ResultDataItem> randomodel;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_random);
        randomodel = (ArrayList<RandomModel.ResultDataItem>) getIntent().getSerializableExtra("model");
        pos = getIntent().getIntExtra("pos", 0);


        binding.title.setText(randomodel.get(pos).title);
        binding.des.setText(randomodel.get(pos).description);
        Glide.with(AllRandomActivity.this)
                .load(randomodel.get(pos).bannerimage.get(0).mediafile)
                .centerCrop()
                .into(binding.image);
        binding.buttonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= String.valueOf(randomodel.get(pos).gameurl);
                Toast.makeText(AllRandomActivity.this, "oho", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
