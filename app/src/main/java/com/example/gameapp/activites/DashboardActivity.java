package com.example.gameapp.activites;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.example.gameapp.Arrowpay;
import com.example.gameapp.BuildConfig;
import com.example.gameapp.Interfaces.ApiInterface;
import com.example.gameapp.Interfaces.DialogUpdate;
import com.example.gameapp.R;
import com.example.gameapp.adapter.Alladapter;
import com.example.gameapp.adapter.OneHorizontal;
import com.example.gameapp.adapter.TrendingAdapter;
import com.example.gameapp.adapter.ViewPagerAdapter;
import com.example.gameapp.catemodel.RandomModel;
import com.example.gameapp.catemodel.TrendingModel;
import com.example.gameapp.catemodel.VersionModel;
import com.example.gameapp.databinding.ActivityDashboardBinding;
import com.example.gameapp.model.BannerModel;
import com.example.gameapp.model.CategorylistModel;
import com.example.gameapp.model.OneModel;
import com.example.gameapp.utils.CustomProgressDialog;
import com.example.gameapp.utils.DialogUtils;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends BaseActivity implements DialogUpdate {

    public ActivityDashboardBinding binding;
    private int dotscount;
    private ImageView[] dots;
    private ArrayList<OneModel> models;
    private ArrayList<TrendingModel.ResultDataItem> trendarrayList;
    private ArrayList<RandomModel.ResultDataItem> randomModels;
    public ArrayList<CategorylistModel.ResultDataItem> catogory;
    public ArrayList<BannerModel.ResultDataItem> bannerimageItemArrayList;
    public ArrayList<VersionModel.ResultDataItem> versionarrylist;
    private VersionModel model;
    String package_name = "package_name";
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

        setuprecycler();
        trending();
        All();
        slider();
        updateversion();


    }

    private void updateversion() {

        final CustomProgressDialog progressDialog = new CustomProgressDialog();
        progressDialog.show(getSupportFragmentManager(), "tag");

        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
        JsonObject object = new JsonObject();

        object.addProperty("action", "version");
        Log.e("::", "" + object);
        Call<VersionModel> call = api.getversion(object);
        call.enqueue(new Callback<VersionModel>() {
            @Override
            public void onResponse(Call<VersionModel> call, Response<VersionModel> response) {
                progressDialog.cancel();

                versionarrylist = new ArrayList<VersionModel.ResultDataItem>();

                VersionModel bannerModel = response.body();


                if (bannerModel != null) {
                    if (bannerModel.resultData != null) {
                        int version = 1;

                        String versionCode = bannerModel.resultData.get(pos).version;

                        version = Integer.parseInt(versionCode);
                        if (BuildConfig.VERSION_CODE == version) {

                        } else {

                            DialogUtils.showUpdateDialog(DashboardActivity.this, getString(R.string.app_name), getString(R.string.label_download), DashboardActivity.this);
                        }


                    } else {
                        Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<VersionModel> call, Throwable t) {

                progressDialog.cancel();
            }
        });


    }

    private void slider() {
        final CustomProgressDialog progressDialog = new CustomProgressDialog();
        progressDialog.show(getSupportFragmentManager(), "tag");
        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
        JsonObject object = new JsonObject();

        object.addProperty("action", "banner");
        Log.e("::", "" + object);
        Call<BannerModel> call = api.getbanner(object);
        call.enqueue(new Callback<BannerModel>() {
            @Override
            public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                progressDialog.cancel();

                bannerimageItemArrayList = new ArrayList<BannerModel.ResultDataItem>();

                BannerModel bannerModel = response.body();


                if (bannerModel != null) {
                    if (bannerModel.resultData != null) {
                        bannerimageItemArrayList.addAll(bannerModel.resultData);
                        if (bannerimageItemArrayList.size() > 0) {
                            viewpagerset();

                        }


                    } else {
                        Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<BannerModel> call, Throwable t) {

                progressDialog.cancel();
            }
        });


    }

    private void setuprecycler() {

        final CustomProgressDialog progressDialog = new CustomProgressDialog();
        progressDialog.show(getSupportFragmentManager(), "tag");
        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
        JsonObject object = new JsonObject();

        object.addProperty("action", "category");
        Log.e("::", "" + object);
        Call<CategorylistModel> call = api.getcatogory(object);
        call.enqueue(new Callback<CategorylistModel>() {
            @Override
            public void onResponse(@NonNull Call<CategorylistModel> call, @NonNull Response<CategorylistModel> response) {
                progressDialog.cancel();

                catogory = new ArrayList<>();

                CategorylistModel categorylistModel = response.body();


                if (categorylistModel != null) {
                    if (categorylistModel.resultData != null) {
                        catogory.addAll(categorylistModel.resultData);
                        if (catogory.size() > 0) {
                            binding.recy1.setLayoutManager(new LinearLayoutManager(DashboardActivity.this, LinearLayoutManager.HORIZONTAL, false));
                            binding.recy1.setAdapter(new OneHorizontal(DashboardActivity.this, catogory));

                        }


                    } else {
                        Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(@NonNull Call<CategorylistModel> call, @NonNull Throwable t) {

                Log.e("re", "" + t.toString());
                progressDialog.cancel();
            }
        });


    }

    private void trending() {

        final CustomProgressDialog progressDialog = new CustomProgressDialog();
        progressDialog.show(getSupportFragmentManager(), "tag");
        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
        JsonObject object = new JsonObject();

        object.addProperty("action", "trading");
        Log.e("::", "" + object);
        Call<TrendingModel> call = api.getrend(object);
        call.enqueue(new Callback<TrendingModel>() {
            @Override
            public void onResponse(Call<TrendingModel> call, Response<TrendingModel> response) {

                progressDialog.cancel();
                trendarrayList = new ArrayList<TrendingModel.ResultDataItem>();

                TrendingModel bannerModel = response.body();


                if (bannerModel != null) {
                    if (bannerModel.resultData != null) {
                        trendarrayList.addAll(bannerModel.resultData);
                        if (trendarrayList.size() > 0) {
                            binding.recytrend.setLayoutManager(new LinearLayoutManager(DashboardActivity.this, LinearLayoutManager.HORIZONTAL, false));
                            binding.recytrend.setAdapter(new TrendingAdapter(trendarrayList, DashboardActivity.this));


                        }


                    } else {
                        Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, "null", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<TrendingModel> call, Throwable t) {

                progressDialog.cancel();
            }
        });


    }

    private void All() {

        final CustomProgressDialog progressDialog = new CustomProgressDialog();
        progressDialog.show(getSupportFragmentManager(), "tag");
        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
        JsonObject object = new JsonObject();

        object.addProperty("action", "random");
        Log.e("::", "" + object);
        Call<RandomModel> call = api.getrandom(object);
        call.enqueue(new Callback<RandomModel>() {
            @Override
            public void onResponse(Call<RandomModel> call, Response<RandomModel> response) {

                progressDialog.cancel();
                randomModels = new ArrayList<RandomModel.ResultDataItem>();

                RandomModel bannerModel = response.body();
                if (bannerModel != null && bannerModel.resultData != null) {
                    randomModels.addAll(bannerModel.resultData);
                    if (randomModels.size() > 0) {
                        binding.all.setLayoutManager(new GridLayoutManager(DashboardActivity.this, 3));
                        binding.all.setAdapter(new Alladapter(randomModels, DashboardActivity.this));
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<RandomModel> call, Throwable t) {

                Toast.makeText(DashboardActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void viewpagerset() {


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, bannerimageItemArrayList);
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


                String url = bannerimageItemArrayList.get(position).bannerimage.get(0).mediafile;

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


    @Override
    public void dialogUpdate(View v) {
        finish();
        openPlayStoreApplication(package_name);

    }
}



