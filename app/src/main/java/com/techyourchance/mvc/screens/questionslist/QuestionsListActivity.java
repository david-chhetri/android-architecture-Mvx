package com.techyourchance.mvc.screens.questionslist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.controllers.BaseActivity;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsActivity;

import java.util.List;

public class QuestionsListActivity extends BaseActivity {

    public static void startClearTop(Context context) {
        Intent intent = new Intent(context, QuestionsListActivity.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);

    }


    private QuestionsListController mQuestionsListController;
    private QuestionsListViewMvc mViewMvc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        mQuestionsListController = getCompositionRoot().getQuestionsListController();
        mQuestionsListController.bindView(mViewMvc);

        setContentView(mViewMvc.getRootView());

    }


    @Override
    protected void onStart() {
        super.onStart();
        mQuestionsListController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mQuestionsListController.onStop();
    }

    @Override
    public void onBackPressed() {
        if(!mQuestionsListController.onBackPressed()){
            super.onBackPressed();
        }
    }

}
