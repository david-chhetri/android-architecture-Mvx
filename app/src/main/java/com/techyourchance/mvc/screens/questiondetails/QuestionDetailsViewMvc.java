package com.techyourchance.mvc.screens.questiondetails;

import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.views.ObservableViewMvc;
import com.techyourchance.mvc.screens.common.views.ViewMvc;

/**
 * Created by David Chhetri on 24,April,2022
 */
public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener> {
    public interface Listener{
        void onNavigateUpClicked();
    }

    void showProgressIndication();
    void hideProgressIndication();

    void bindQuestion(QuestionDetails questionDetails);

}
