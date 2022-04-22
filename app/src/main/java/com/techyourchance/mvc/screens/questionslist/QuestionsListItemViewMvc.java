package com.techyourchance.mvc.screens.questionslist;

import android.view.View;

import com.techyourchance.mvc.questions.Question;

/**
 * Created by David Chhetri on 22,April,2022
 */
public interface QuestionsListItemViewMvc {
    public interface Listener{
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    View getRoot();




}
