package com.example.gameapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.example.gameapp.adapter.Alladapter;
import com.example.gameapp.adapter.OneHorizontal;
import com.example.gameapp.adapter.TrendingAdapter;
import com.example.gameapp.adapter.ViewPagerAdapter;
import com.example.gameapp.databinding.ActivityDashboardBinding;
import com.example.gameapp.model.AllModel;
import com.example.gameapp.model.OneModel;
import com.example.gameapp.model.TrendingModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    public ActivityDashboardBinding binding;
    private int dotscount;
    private ImageView[] dots;
    private ArrayList<OneModel> models;
    private ArrayList<TrendingModel> arrayList;
    private ArrayList<AllModel> allModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

        setuprecycler();
        trending();
        All();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        binding.viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            binding.SliderDots.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setuprecycler() {

        int imagearray[] = {R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1};
        String textarray[] = {"Game", "Game", "Game", "Game", "Game"};

        models = new ArrayList<>();

        for (int i = 0; i < imagearray.length; i++) {
            OneModel model = new OneModel();
            model.image = imagearray[i];
            model.text = textarray[i];
            models.add(model);
        }

        binding.recy1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recy1.setAdapter(new OneHorizontal(DashboardActivity.this, models));
    }

    private void trending() {

        int imagearray[] = {R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1};
        String textarray[] = {"Game", "Game", "Game", "Game", "Game"};

        arrayList = new ArrayList<>();

        for (int i = 0; i < imagearray.length; i++) {
            TrendingModel model = new TrendingModel();
            model.image = imagearray[i];
            model.text = textarray[i];
            arrayList.add(model);
        }

        binding.recytrend.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recytrend.setAdapter(new TrendingAdapter(arrayList, DashboardActivity.this));
    }

    private void All() {

        int imagearray[] = {R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1};
        String textarray[] = {"Game", "Game", "Game", "Game", "Game"};

        allModelArrayList = new ArrayList<>();

        for (int i = 0; i < imagearray.length; i++) {
            AllModel model = new AllModel();
            model.image = imagearray[i];
            model.text = textarray[i];
            allModelArrayList.add(model);
        }

        binding.all.setLayoutManager(new GridLayoutManager(DashboardActivity.this, 3));
        binding.all.setAdapter(new Alladapter(allModelArrayList, DashboardActivity.this));
    }


}



