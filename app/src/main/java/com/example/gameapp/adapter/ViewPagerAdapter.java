package com.example.gameapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.gameapp.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.image1, R.drawable.image1, R.drawable.image1};


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if (layoutInflater != null) {

            view = layoutInflater.inflate(R.layout.custome_lay, null);


        }
        ImageView imageView = null;
        if (view != null) {
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
        if (imageView != null) {
            imageView.setImageResource(images[position]);
        }

        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {

                        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 1) {

                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {

                        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
