package com.techyourchance.mvc.screens.questionslist;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.BaseViewMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Currently Adapter is the point where user initiates
 */
public class QuestionsListViewMvcImpl extends BaseViewMvc implements
        QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {

    private List<Listener> mListeners = new ArrayList<>(1);
    private RecyclerView mRecyclerView;
    private QuestionsRecyclerAdapter mAdapter;
    private View mRootView;

    public QuestionsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_questions_list, parent, false);
        mRecyclerView = findViewById(R.id.recycler_questions);
        mAdapter = new QuestionsRecyclerAdapter(inflater, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);

    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : mListeners) {
            listener.onQuestionClicked(question);
        }

    }

}
