package com.example.gameapp.catemodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class RandomModel implements Serializable {

    @SerializedName("ResponseCode")
    public String responseCode;

    @SerializedName("ResultData")
    public List<ResultDataItem> resultData;

    @SerializedName("ResponseMsg")
    public String responseMsg;

    @SerializedName("Result")
    public String result;

    public static class ResultDataItem implements Serializable{

        @SerializedName("feturedimage")
        public List<FeturedimageItem> feturedimage;

        @SerializedName("ordernumber")
        public String ordernumber;

        @SerializedName("description")
        public String description;

        @SerializedName("pID")
        public String pID;

        @SerializedName("gameurl")
        public Object gameurl;

        @SerializedName("title")
        public String title;

        @SerializedName("categoryid")
        public String categoryid;

        @SerializedName("bannerimage")
        public List<BannerimageItem> bannerimage;

        public static class BannerimageItem implements Serializable{

            @SerializedName("mediafile")
            public String mediafile;

        }

        public static class FeturedimageItem implements Serializable{

            @SerializedName("imgid")
            public String imgid;

            @SerializedName("post_type")
            public String postType;

            @SerializedName("mediafile")
            public String mediafile;


        }
    }

}