package com.example.lenovo.yk_moni_ljq.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtil { //Dialog

    public static ProgressDialog getProgressDialog(Context context) {

        ProgressDialog progressDialog = new ProgressDialog(context);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialog.setMessage("正在加载...");

        progressDialog.setCancelable(false);

        return progressDialog;
    }

}
