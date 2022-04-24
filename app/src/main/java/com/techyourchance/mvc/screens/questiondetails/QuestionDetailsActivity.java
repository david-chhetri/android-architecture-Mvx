package com.techyourchance.mvc.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.techyourchance.mvc.networking.QuestionDetailsResponseSchema;
import com.techyourchance.mvc.networking.QuestionSchema;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David Chhetri on 24,April,2022
 */
public class QuestionDetailsActivity extends BaseActivity {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";
    private StackoverflowApi mStackoverflowApi;
    private QuestionDetailsViewMvc mViewMvc;

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStackoverflowApi = getCompositionRoot().getStackoverflowApi();
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionDetailsViewMvc(null);
        setContentView(mViewMvc.getRootView());


    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestionDetails();

    }

    private void fetchQuestionDetails() {
        mStackoverflowApi.fetchQuestionDetails(getQuestionId())
                .enqueue(new Callback<QuestionDetailsResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response) {
                        if(response.isSuccessful()){
                            bindQuestionDetails(response.body().getQuestion());
                        }else{
                            networkCallFailed();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t) {
                        networkCallFailed();
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private String getQuestionId(){
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }

    private void bindQuestionDetails(QuestionSchema questionSchema){
        mViewMvc.hideProgressIndication();
        mViewMvc.bindQuestion(
                new QuestionDetails(
                        questionSchema.getId(),
                        questionSchema.getTitle(),
                        questionSchema.getBody()
                )
        );
    }

    private void networkCallFailed(){
        mViewMvc.hideProgressIndication();
        Toast.makeText(this,"network call failed", Toast.LENGTH_SHORT).show();
    }



}

