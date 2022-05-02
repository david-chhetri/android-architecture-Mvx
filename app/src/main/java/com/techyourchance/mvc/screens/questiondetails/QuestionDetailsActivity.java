package com.techyourchance.mvc.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.FetchQuestionDetailsUsecase;
import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.controllers.BaseActivity;

/**
 * Created by David Chhetri on 24,April,2022
 */
public class QuestionDetailsActivity extends BaseActivity
            implements FetchQuestionDetailsUsecase.Listener{

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";
    private QuestionDetailsViewMvc mViewMvc;

    private FetchQuestionDetailsUsecase mFetchQuestionDetailsUsecase;

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFetchQuestionDetailsUsecase = getCompositionRoot().getFetchQuestionDetailsUseCase();
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionDetailsViewMvc(null);
        setContentView(mViewMvc.getRootView());


    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.showProgressIndication();
        mFetchQuestionDetailsUsecase.registerListener(this);
        mFetchQuestionDetailsUsecase.fetchQuestionDetailsAndNotify(getQuestionId());

    }



    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.hideProgressIndication();
        mFetchQuestionDetailsUsecase.unregisterListener(this);

    }

    private String getQuestionId(){
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }


    @Override
    public void onQuestionDetailsFetched(QuestionDetails questionDetails) {
        mViewMvc.bindQuestion(questionDetails);
        mViewMvc.hideProgressIndication();
    }

    @Override
    public void onQuestionDetailsFetchFailure() {
        mViewMvc.hideProgressIndication();
        Toast.makeText(this, R.string.error_network_call_failed,Toast.LENGTH_SHORT).show();
    }

}

