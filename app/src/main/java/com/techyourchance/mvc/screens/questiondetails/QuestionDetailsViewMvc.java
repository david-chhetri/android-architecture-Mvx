package com.techyourchance.mvc.screens.questiondetails;

import android.view.View;

import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.ViewMvc;

/**
 * Created by David Chhetri on 24,April,2022
 */
public interface QuestionDetailsViewMvc extends ViewMvc {

    void showProgressIndication();
    void hideProgressIndication();

    void bindQuestion(QuestionDetails questionDetails);

}
