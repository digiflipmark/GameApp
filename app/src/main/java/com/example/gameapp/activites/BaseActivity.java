package com.example.gameapp.activites;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

public class BaseActivity extends AppCompatActivity {

    /*public CustomProgressDialog progressDialog;*/
    private Random random;
    private int value,preValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // This could be moved into an abstract BaseActivity
    // class for being re-used by several instances
    protected void setFragment(FrameLayout containerId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId.getId(), fragment);
        fragmentTransaction.commit();
    }

    public void openActivity(Context context, Class aClass){
        startActivity(new Intent(context,aClass).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    public void moveNextActivity(Context context, Class aClass){
        startActivity(new Intent(context,aClass));
    }

   /* public void shareApp(String code){
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            String sAux = "Download "+getString(R.string.app_name)+" and Verify with ' "+code+" ' this code to get Some Coin.\nDownload from below link "+SharedPrefs.getString(SharedPrefs.userSharedPrefData.package_name);
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }*/

    public void openPlayStoreApplication(String appPackageName){
        appPackageName = appPackageName.substring(appPackageName.indexOf("=")+1, appPackageName.length());
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public void openAppDirectly(String packageName){
        try {
            Intent i = getPackageManager().getLaunchIntentForPackage(packageName);
            startActivity(i);
        } catch (Exception e) {
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

  /*  public void showProgressDialog(){
        progressDialog= new CustomProgressDialog();
        progressDialog.show(getSupportFragmentManager(), "tag");
    }

    public void hideProgeressDialog(){
        if (progressDialog != null){
            progressDialog.cancel();
        }
    }*/

    public int generateRandomNumber(int max,int min){
        return new Random().nextInt((max - min) + 1) + min;
    }

    public boolean isAllTaskCompleted(){
        return /*SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click1) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click2) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click3) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click4) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click5) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click6) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click7) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click8) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click9) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click10) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click11) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click12) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click13) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click14) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click15) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click16) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click17) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click18) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click19) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click20) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click21) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click22) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click23) == 1
                && SharedPrefs.getInteger(SharedPrefs.userSharedPrefData.is_Click24) == 1*/
                false;
    }

  /*  public void openWebPage(String url) {
        try {
            Uri webpage = Uri.parse(url);
            Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            new MakeToast("Url not available so please try again later");
            e.printStackTrace();
        }
    }*/

    /*public int generateAnswerRandomNumber(int max,int min){
        if (random == null){
            random = new Random();
        }
        value = random.nextInt((max - min) + 1) + min;
        return value;
    }

    public int generateForMultiplicationMax(String type){
        int number = 0;
        if (random == null){
            random = new Random();
        }
        if (type.equalsIgnoreCase(CommonUtils.easy)){
            number = generateAnswerRandomNumber(19,1);
        }else if (type.equalsIgnoreCase(CommonUtils.medium)){
            number = generateAnswerRandomNumber(39,19);
        }else if (type.equalsIgnoreCase(CommonUtils.hard)){
            number = generateAnswerRandomNumber(80,39);
        }
        return number;
    }

    public int generateForDivisionMax(String type){
        *//*if (random == null){
            random = new Random();
        }
        return random.nextInt((24-11) + 1) + 11;*//*
        int number = 0;
        if (random == null){
            random = new Random();
        }
        if (type.equalsIgnoreCase(CommonUtils.easy)){
            number = generateAnswerRandomNumber(24,10);
        }else if (type.equalsIgnoreCase(CommonUtils.medium)){
            number = generateAnswerRandomNumber(39,20);
        }else if (type.equalsIgnoreCase(CommonUtils.hard)){
            number = generateAnswerRandomNumber(80,40);
        }
        return number;
    }

    public int generateForMultiplicationMin(String type){
        int number = 0;
        if (random == null){
            random = new Random();
        }
        if (type.equalsIgnoreCase(CommonUtils.easy)){
            number = generateAnswerRandomNumber(9,1);
        }else if (type.equalsIgnoreCase(CommonUtils.medium)){
            number = generateAnswerRandomNumber(19,3);
        }else if (type.equalsIgnoreCase(CommonUtils.hard)){
            number = generateAnswerRandomNumber(80,20);
        }
        return  number;
    }

    public int generateForDivisionMin(String type){
        int number = 0;
        if (random == null){
            random = new Random();
        }
        if (type.equalsIgnoreCase(CommonUtils.easy)){
            number = generateAnswerRandomNumber(9,2);
        }else if (type.equalsIgnoreCase(CommonUtils.medium)){
            number = generateAnswerRandomNumber(19,10);
        }else if (type.equalsIgnoreCase(CommonUtils.hard)){
            number = generateAnswerRandomNumber(79,20);
        }
        return  number;
    }

    public int generateRandomNumber(String type){
        int number = 0;
        if (random == null){
            random = new Random();
        }
        if (type.equalsIgnoreCase(CommonUtils.easy)){
            number = random.nextInt((50-10) + 1) + 10;
        }else if (type.equalsIgnoreCase(CommonUtils.medium)){
            number = random.nextInt((150-50) + 1) + 50;
        }else if (type.equalsIgnoreCase(CommonUtils.hard)){
            number = random.nextInt((999-150) + 1) + 150;
        }
        return number;
    }

    public ArrayList<String> getInstalledApp(){
        ArrayList<String> arrayList = new ArrayList<>();
        final PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo packageInfo : packages) {
            arrayList.add(packageInfo.packageName);
        }
        return arrayList;
    }

    public int getDiamondImage() {
        int number = generateRandomNumber(40, 1);
        int value = 0;
        switch (number) {
            case 1:
                value = R.drawable.image1;
                break;
            case 2:
                value = R.drawable.image2;
                break;
            case 3:
                value = R.drawable.image4;
                break;
            case 4:
                value = R.drawable.image3;
                break;
            case 5:
                value = R.drawable.image5;
                break;
            case 6:
                value = R.drawable.image6;
                break;
            case 7:
                value = R.drawable.image7;
                break;
            case 8:
                value = R.drawable.image8;
                break;
            case 9:
                value = R.drawable.image9;
                break;
            case 10:
                value = R.drawable.image10;
                break;
            case 11:
                value = R.drawable.image11;
                break;
            case 12:
                value = R.drawable.image12;
                break;
            case 13:
                value = R.drawable.image13;
                break;
            case 14:
                value = R.drawable.image14;
                break;
            case 15:
                value = R.drawable.image15;
                break;
            case 16:
                value = R.drawable.image16;
                break;
            case 17:
                value = R.drawable.image17;
                break;
            case 18:
                value = R.drawable.image18;
                break;
            case 19:
                value = R.drawable.image19;
                break;
            case 20:
                value = R.drawable.image20;
                break;
            case 21:
                value = R.drawable.image21;
                break;
            case 22:
                value = R.drawable.image22;
                break;
            case 23:
                value = R.drawable.image23;
                break;
            case 24:
                value = R.drawable.image24;
                break;
            case 25:
                value = R.drawable.image25;
                break;
            case 26:
                value = R.drawable.image26;
                break;
            case 27:
                value = R.drawable.image27;
                break;
            case 28:
                value = R.drawable.image28;
                break;
            case 29:
                value = R.drawable.image29;
                break;
            case 30:
                value = R.drawable.image30;
                break;
            case 31:
                value = R.drawable.image31;
                break;
            case 32:
                value = R.drawable.image32;
                break;
            case 33:
                value = R.drawable.image33;
                break;
            case 34:
                value = R.drawable.image34;
                break;
            case 35:
                value = R.drawable.image35;
                break;
            case 36:
                value = R.drawable.image36;
                break;
            case 37:
                value = R.drawable.image37;
                break;
            case 38:
                value = R.drawable.image38;
                break;
            case 39:
                value = R.drawable.image39;
                break;
            case 40:
                value = R.drawable.image40;
                break;
            default:
                value = R.drawable.image25;
                break;
        }
        return value;
    }

    *//**
     * Change value in dp to pixels
     * @param dp
     * @param context
     * @return
     *//*
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }*/

}
