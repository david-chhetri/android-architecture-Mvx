package com.techyourchance.mvc.screens.questionslist;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.navdrawer.BaseNavDrawerViewMvc;
import com.techyourchance.mvc.screens.common.navdrawer.DrawerItems;
import com.techyourchance.mvc.screens.common.toolbar.ToolbarViewMvc;
import com.techyourchance.mvc.screens.common.views.BaseObservableViewMvc;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;

import java.util.List;


public class QuestionsListViewMvcImpl
        extends BaseNavDrawerViewMvc<QuestionsListViewMvc.Listener>
        implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {

    private RecyclerView mRecyclerView;
    private QuestionsRecyclerAdapter mAdapter;

    private final Toolbar mToolbar;
    private final ToolbarViewMvc mToolbarViewMvc;
    private final ProgressBar mProgressBar;

    public QuestionsListViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory factory) {
        super(inflater,parent);
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerView = findViewById(R.id.recycler_questions);
        mAdapter = new QuestionsRecyclerAdapter(this, factory);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mProgressBar = findViewById(R.id.progress);
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = factory.getToolbarViewMvc(mToolbar);
        initToolbar();

    }

    private void initToolbar() {
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.setTitle(getContext().getString(R.string.question_list_screen_title));
        mToolbarViewMvc.enableHamburgerBtnAndListen(new ToolbarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                openDrawer();
            }
        });



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

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {
        for(Listener listener : getListeners()){
            switch(item) {
                case QUESTION_LIST:
                listener.onQuestionsListClicked();
            }
        }
    }



}
