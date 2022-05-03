package com.techyourchance.mvc.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvc;
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.techyourchance.mvc.screens.questionslist.QuestionsListItemViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListItemViewMvcImpl;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc;
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvcImpl;

/**
 * Created by David Chhetri on 23,April,2022
 */
public class ViewMvcFactory {

    private final LayoutInflater mInflater;

    public ViewMvcFactory(LayoutInflater inflater) {
        mInflater = inflater;
    }

    public QuestionsListViewMvc getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListViewMvcImpl(mInflater, parent, this);
    }

    public QuestionsListItemViewMvc getQuestionListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListItemViewMvcImpl(mInflater, parent);
    }

    public QuestionDetailsViewMvc getQuestionDetailsViewMvc(@Nullable ViewGroup parent) {
        return new QuestionDetailsViewMvcImpl(mInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mInflater, parent);
    }

}

