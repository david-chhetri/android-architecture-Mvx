package com.techyourchance.mvc.screens.questiondetails;

import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.views.BaseViewMvc;

/**
 * Created by David Chhetri on 24,April,2022
 */
public class QuestionDetailsViewMvcImpl extends BaseViewMvc implements QuestionDetailsViewMvc {

    private final TextView mTxtQuestionTitle;
    private final TextView mTxtQuestionBody;
    private final ProgressBar mProgressBar;


    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_details, parent, false));
        mTxtQuestionTitle = findViewById(R.id.txt_question_title);
        mTxtQuestionBody = findViewById(R.id.txt_question_body);
        mProgressBar = findViewById(R.id.progress);

    }

    @Override
    public void showProgressIndication() {
            mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
            mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void bindQuestion(QuestionDetails questionDetails) {
        mTxtQuestionTitle.setText(Html.fromHtml(questionDetails.getTitle()));
        mTxtQuestionBody.setText(Html.fromHtml(questionDetails.getBody()));

    }

}

