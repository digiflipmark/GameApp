package com.example.gameapp.catemodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class VersionModel {

    @SerializedName("ResponseCode")
    public String responseCode;

    @SerializedName("ResultData")
    public List<ResultDataItem> resultData;

    @SerializedName("ResponseMsg")
    public String responseMsg;

    @SerializedName("Result")
    public String result;

    public class ResultDataItem {

        @SerializedName("version")
        public String version;


    }
}