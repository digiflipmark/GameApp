package com.example.gameapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class CategorylistModel implements Serializable {

    @SerializedName("ResponseCode")
    public String responseCode;

    @SerializedName("ResultData")
    public List<ResultDataItem> resultData;

    @SerializedName("ResponseMsg")
    public String responseMsg;

    @SerializedName("Result")
    public String result;

    public static class ResultDataItem implements Serializable{

        @SerializedName("CatImage")
        public String catImage;

        @SerializedName("parentItem")
        public List<Object> parentItem;

        @SerializedName("CatID")
        public String catID;

        @SerializedName("CatName")
        public String catName;
    }
}