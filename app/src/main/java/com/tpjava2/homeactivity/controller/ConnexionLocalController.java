package com.tpjava2.homeactivity.controller;

import android.content.Context;

import com.tpjava2.homeactivity.dao.BddLocale;

public final class ConnexionLocalController {
    private static BddLocale instance=  null;

    private ConnexionLocalController(){
    }


    public static BddLocale getInstance(Context context){
        if(instance == null){
            instance = new BddLocale(context);
        }
        return   instance;

    }
}
