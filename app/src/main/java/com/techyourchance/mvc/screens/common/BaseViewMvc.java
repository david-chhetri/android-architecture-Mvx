package com.techyourchance.mvc.screens.common;

import android.content.Context;
import android.view.View;

/**
 * Created by David Chhetri on 23,April,2022
 */
public abstract class BaseViewMvc {

    private View mRootView;

    public View getRootView(){
        return mRootView;
    }

    public <T extends View>T findViewById(int id){
        return getRootView().findViewById(id);
    }

    public Context getContext(){
        return getRootView().getContext();
    }



}
