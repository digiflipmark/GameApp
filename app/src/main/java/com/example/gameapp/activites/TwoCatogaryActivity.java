package com.example.gameapp.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.gameapp.Arrowpay;
import com.example.gameapp.Interfaces.ApiInterface;
import com.example.gameapp.Interfaces.ItemclickListener;
import com.example.gameapp.R;
import com.example.gameapp.adapter.OnecAdapter;
import com.example.gameapp.adapter.TwocAdapter;
import com.example.gameapp.catemodel.CateOneModel;
import com.example.gameapp.catemodel.CateTwoModel;
import com.example.gameapp.databinding.ActivityTwoCatogaryBinding;
import com.example.gameapp.model.CategorylistModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwoCatogaryActivity extends AppCompatActivity implements ItemclickListener {
    private ActivityTwoCatogaryBinding binding;
    private ArrayList<CategorylistModel.ResultDataItem> arrayList;
    private ArrayList<CateTwoModel.ResultDataItem>catetwo;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_catogary);

        Intent intent = getIntent();
        arrayList = (ArrayList<CategorylistModel.ResultDataItem>) getIntent().getSerializableExtra("name");
        Log.e("::", "" + arrayList.get(pos).catName);

        pos = getIntent().getIntExtra("pos", 0);
        tactionbar(arrayList.get(pos).catName);
        callApi();
    }

    private void callApi() {
        ApiInterface api = Arrowpay.getClient().create(ApiInterface.class);
       /* JsonObject object = new JsonObject();
        object.addProperty("action","gameslist");*/
        JsonObject object = new JsonObject();
        object.addProperty("action","gameslist");
        object.addProperty("catid","3");
        object.addProperty("limit","1");


        Log.e("::",""+object);
        Call<CateTwoModel> call = api.getcatetwo(object);

        call.enqueue(new Callback<CateTwoModel>() {
            @Override
            public void onResponse(Call<CateTwoModel> call, Response<CateTwoModel> response) {

                catetwo = new ArrayList<CateTwoModel.ResultDataItem>();
                CateTwoModel model=response.body();
                if (model!=null){
                    if (model.result!=null){
                        catetwo.addAll(model.resultData);
                        if (catetwo.size()>0){
                            binding.recy1.setLayoutManager(new GridLayoutManager(TwoCatogaryActivity.this,2));
                            binding.recy1.setAdapter(new TwocAdapter(catetwo,TwoCatogaryActivity.this,TwoCatogaryActivity.this));
                        }

                    }else {
                        Toast.makeText(TwoCatogaryActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(TwoCatogaryActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CateTwoModel> call, Throwable t) {
                Toast.makeText(TwoCatogaryActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void tactionbar(String titel) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(titel);


        }


    }

    @Override
    public void click(int pos) {
        Intent intent=new Intent(this,SecondDetailsActivity.class);
        intent.putExtra("catetwo",catetwo);
        intent.putExtra("pos",pos);
        startActivity(intent);
    }
}
