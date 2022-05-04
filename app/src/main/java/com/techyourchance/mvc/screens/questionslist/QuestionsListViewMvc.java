package com.techyourchance.mvc.screens.questionslist;

import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.navdrawer.NavDrawerViewMvc;
import com.techyourchance.mvc.screens.common.views.ObservableViewMvc;

import java.util.List;

/**
 * Created by David Chhetri on 22,April,2022
 */
public interface QuestionsListViewMvc extends
        ObservableViewMvc<QuestionsListViewMvc.Listener>,
        NavDrawerViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
        void onQuestionsListClicked();

    }


    void bindQuestions(List<Question> questions);


}
