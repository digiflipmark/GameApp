package com.example.gameapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.gameapp.Arrowpay;
import com.example.gameapp.Interfaces.ApiInterface;
import com.example.gameapp.Interfaces.ItemclickListener;
import com.example.gameapp.R;
import com.example.gameapp.adapter.OnecAdapter;
import com.example.gameapp.catemodel.CateOneModel;
import com.example.gameapp.databinding.ActivityOneCatogaryBinding;
import com.example.gameapp.model.BannerModel;
import com.example.gameapp.model.CategorylistModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneCatogaryActivity extends AppCompatActivity implements ItemclickListener {

    private ActivityOneCatogaryBinding binding;
    int pos;
    private ArrayList<CategorylistModel.ResultDataItem> arrayList;
    private ArrayList<CateOneModel.ResultDataItem> cateonemodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_one_catogary);
        Intent intent=getIntent();
        arrayList = (ArrayList<CategorylistModel.ResultDataItem>) getIntent().getSerializableExtra("name");
        Log.e("::",""+arrayList.get(pos).catName);

        pos=getIntent().getIntExtra("pos",0);
        tactionbar(arrayList.get(pos).catName);
        callApi();


    }

    private void callApi() {
        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
       /* JsonObject object = new JsonObject();
        object.addProperty("action","gameslist");*/
        JsonObject object = new JsonObject();
        object.addProperty("action","gameslist");
        object.addProperty("catid","1");
        object.addProperty("limit","1");


        Log.e("::",""+object);
        Call<CateOneModel> call = api.getcatone(object);

        call.enqueue(new Callback<CateOneModel>() {
            @Override
            public void onResponse(Call<CateOneModel> call, Response<CateOneModel> response) {

                cateonemodel = new ArrayList<CateOneModel.ResultDataItem>();
                CateOneModel model=response.body();
                if (model!=null){
                    if (model.result!=null){
                        cateonemodel.addAll(model.resultData);
                        if (cateonemodel.size()>0){
                            binding.recy1.setLayoutManager(new GridLayoutManager(OneCatogaryActivity.this,2));
                            binding.recy1.setAdapter(new OnecAdapter(cateonemodel,OneCatogaryActivity.this,OneCatogaryActivity.this));
                        }

                    }else {
                        Toast.makeText(OneCatogaryActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(OneCatogaryActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CateOneModel> call, Throwable t) {
                Toast.makeText(OneCatogaryActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void tactionbar(String titel) {
        ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(titel);


        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void click(int pos) {
        Intent intent=new Intent(this,OneDetailsActivity.class);
        intent.putExtra("model",cateonemodel);
        intent.putExtra("pos",pos);
        startActivity(intent);
    }
}
