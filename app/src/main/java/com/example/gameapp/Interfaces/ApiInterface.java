package com.example.gameapp.Interfaces;

import com.example.gameapp.catemodel.CateOneModel;
import com.example.gameapp.catemodel.CateTwoModel;
import com.example.gameapp.catemodel.RandomModel;
import com.example.gameapp.catemodel.TrendingModel;
import com.example.gameapp.catemodel.VersionModel;
import com.example.gameapp.model.BannerModel;
import com.example.gameapp.model.CategorylistModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    /* @GET("v2/top-headlines")
     Call<BussienssModel> getbussiness(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);
 */

/*
    action=trading
    banner
*/

    @POST("api/common.php")
    Call<CategorylistModel> getcatogory(@Body JsonObject action);

    @POST("api/common.php")
    Call<BannerModel> getbanner(@Body JsonObject action);


    @POST("api/gameslist.php")
    Call<CateOneModel> getcatone(@Body JsonObject jsonObject);

    @POST("api/gameslist.php")
    Call<CateTwoModel> getcatetwo(@Body JsonObject jsonObject);

    @POST("api/common.php")
    Call<TrendingModel> getrend(@Body JsonObject action);

    @POST("api/common.php")
    Call<VersionModel> getversion(@Body JsonObject action);

    @POST("api/common.php")
    Call<RandomModel> getrandom(@Body JsonObject action);






}
