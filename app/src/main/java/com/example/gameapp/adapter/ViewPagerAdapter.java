package com.example.gameapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.gameapp.R;
import com.example.gameapp.model.BannerModel;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    public ArrayList<BannerModel.ResultDataItem> bannerimageItemArrayList;
   /* private Integer[] images = {R.drawable.image1, R.drawable.image1, R.drawable.image1};*/


    public ViewPagerAdapter(Context context,ArrayList<BannerModel.ResultDataItem> bannerimageItemArrayList) {
        this.context = context;
        this.bannerimageItemArrayList=bannerimageItemArrayList;
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return bannerimageItemArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        View view = layoutInflater.inflate(R.layout.custome_lay, container, false);

        final ImageView imageView = view.findViewById(R.id.img);
        loadImage(context, imageView,bannerimageItemArrayList.get(position).bannerimage.get(0).mediafile);
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){

                    Toast.makeText(context, "0", Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
        /*if (view != null) {
            textView = (textView) view.findViewById(R.id.text);
        }
        if (imageView != null) {
            *//*imageView.setImageResource(images[position]);*//*
            Glide.with(context).load(bannerimageItemArrayList.get(position).bannerimage.get(position).mediafile).into(imageView);
        }*/





    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);

    }

    public static void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }

}
