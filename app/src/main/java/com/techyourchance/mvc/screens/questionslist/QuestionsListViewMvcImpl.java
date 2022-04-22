package com.techyourchance.mvc.screens.questionslist;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Currently Adapter is the point where user initiates
 */
public class QuestionsListViewMvcImpl implements
        QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {


    private List<MeroListener> mListeners = new ArrayList<>(1);
    @Override
    public void registerListener(MeroListener listener){
        mListeners.add(listener);
    }
    @Override
    public void unregisterListener(MeroListener listener){
        mListeners.remove(listener);
    }
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

    private Context getContext() {
        return getRoot().getContext();
    }

    public <T extends View>T findViewById(int id) {
        return getRoot().findViewById(id);
    }

    @Override
    public View getRoot() {
        return mRootView;
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mAdapter.bindQuestions(questions);

    }


    @Override
    public void onQuestionClicked(Question question) {
        for(MeroListener listener : mListeners){
            listener.onQuestionClicked(question);
        }

    }

}
