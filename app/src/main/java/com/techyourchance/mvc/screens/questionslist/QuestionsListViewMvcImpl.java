package com.techyourchance.mvc.screens.questionslist;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseObservableViewMvc;

import java.util.ArrayList;
import java.util.List;


public class QuestionsListViewMvcImpl
        extends BaseObservableViewMvc<QuestionsListViewMvc.Listener>
        implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {

    private RecyclerView mRecyclerView;
    private QuestionsRecyclerAdapter mAdapter;

    public QuestionsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerView = findViewById(R.id.recycler_questions);
        mAdapter = new QuestionsRecyclerAdapter(inflater, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);

    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
        }

    }

}
