package com.techyourchance.mvc.common.dependencyinjection;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.techyourchance.mvc.CustomApplication;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.questions.FetchLastActiveQuestionsUseCase;
import com.techyourchance.mvc.questions.FetchQuestionDetailsUsecase;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.common.screensnavigator.ScreensNavigator;
import com.techyourchance.mvc.screens.common.toastshelper.ToastsHelper;
import com.techyourchance.mvc.screens.questionslist.QuestionsListController;
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

    private Context getContext() {
        return mActivity;
    }

    public LayoutInflater getLayoutInflater(){
        return LayoutInflater.from(getContext());
    }

    public ViewMvcFactory getViewMvcFactory(){
        return new ViewMvcFactory(getLayoutInflater());
    }


    public FetchQuestionDetailsUsecase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUsecase(getStackoverflowApi());
    }

    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase() {
        return  new FetchLastActiveQuestionsUseCase(getStackoverflowApi());
    }

    public QuestionsListController getQuestionsListController() {
        return new QuestionsListController(
                getFetchLastActiveQuestionsUseCase(),
                getScreensNavigator(),
                getToastsHelper());
    }

    private ToastsHelper getToastsHelper() {
        return new ToastsHelper(getContext());
    }

    private ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getContext());
    }


}

