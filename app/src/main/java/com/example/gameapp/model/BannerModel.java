package com.example.gameapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class BannerModel {

    @SerializedName("ResponseCode")
    public String responseCode;

    @SerializedName("ResultData")
    public List<ResultDataItem> resultData;

    @SerializedName("ResponseMsg")
    public String responseMsg;

    @SerializedName("Result")
    public String result;

    public static class ResultDataItem {

        @SerializedName("ID")
        public String iD;

        @SerializedName("title")
        public String title;

        @SerializedName("bannerimage")
        public List<BannerimageItem> bannerimage;


    }
    public static class BannerimageItem {

        @SerializedName("mediafile")
        public String mediafile;


    }
}