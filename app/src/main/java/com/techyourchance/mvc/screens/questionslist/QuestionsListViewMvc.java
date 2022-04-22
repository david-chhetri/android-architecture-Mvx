package com.techyourchance.mvc.screens.questionslist;

import android.view.View;

import com.techyourchance.mvc.questions.Question;

import java.util.List;

/**
 * Created by David Chhetri on 22,April,2022
 */
public interface QuestionsListViewMvc {

    public interface MeroListener {
        void onQuestionClicked(Question question);

    }
    void registerListener(MeroListener listener);

    void unregisterListener(MeroListener listener);

    View getRoot();

    void bindQuestions(List<Question> questions);


}
