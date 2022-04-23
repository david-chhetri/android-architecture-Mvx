package com.techyourchance.mvc.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.techyourchance.mvc.CustomApplication;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvcImpl;

/**
 * Created by David Chhetri on 23,April,2022
 */
public class ControllerCompositionRoot {
    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private CompositionRoot getCompositionRoot(){
        return mCompositionRoot;
    }

    public StackoverflowApi getStackoverflowApi(){
        return getCompositionRoot().getStackoverflowApi();
    }

    public LayoutInflater getLayoutInflater(){
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory(){
        return new ViewMvcFactory(getLayoutInflater());
    }


}

