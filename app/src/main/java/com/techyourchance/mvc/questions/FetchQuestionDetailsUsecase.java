package com.techyourchance.mvc.questions;

import com.techyourchance.mvc.common.BaseObservable;
import com.techyourchance.mvc.networking.QuestionDetailsResponseSchema;
import com.techyourchance.mvc.networking.QuestionSchema;
import com.techyourchance.mvc.networking.StackoverflowApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David Chhetri on 24,April,2022
 */
public class FetchQuestionDetailsUsecase extends BaseObservable<FetchQuestionDetailsUsecase.Listener> {

    public interface Listener{
        void onQuestionDetailsFetched(QuestionDetails questionDetails);
        void onQuestionDetailsFetchFailure();

    }
    private final StackoverflowApi mStackoverflowApi;

    public FetchQuestionDetailsUsecase(StackoverflowApi stackoverflowApi) {
        mStackoverflowApi = stackoverflowApi;
    }



    public void fetchQuestionDetailsAndNotify(String questionId) {
        mStackoverflowApi.fetchQuestionDetails(questionId)
                .enqueue(new Callback<QuestionDetailsResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response) {
                        if(response.isSuccessful()){
                            notifySuccess(response.body().getQuestion());
                        }else{
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t) {
                        notifyFailure();
                    }
                });
    }

    private void notifySuccess(QuestionSchema questionSchema){
        for(Listener listener : getListeners()){
            listener.onQuestionDetailsFetched(
                    new QuestionDetails(
                            questionSchema.getId(),
                            questionSchema.getTitle(),
                            questionSchema.getBody()
                    )
            );
        }

    }

    private void notifyFailure(){
        for(Listener listener : getListeners()){
            listener.onQuestionDetailsFetchFailure();
        }

    }





}

