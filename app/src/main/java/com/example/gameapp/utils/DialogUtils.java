package com.example.gameapp.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.example.gameapp.Interfaces.DialogUpdate;
import com.example.gameapp.R;
import com.example.gameapp.databinding.DialogAlertBinding;


/**
 * Created by Brijesh on 27-03-2018.
 */

public class DialogUtils {







    public static void showUpdateDialog(Context context, final String title, final String message, final DialogUpdate onClickListener){
        final Dialog dialog = new Dialog(context);
        final DialogAlertBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_alert, null, false);
        dialog.setContentView(binding.getRoot());
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);

        binding.tvTitle.setText(title);
        binding.tvMessage.setText(message);
        binding.btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onClickListener.dialogUpdate(v);
            }
        });
        dialog.show();
    }



}
