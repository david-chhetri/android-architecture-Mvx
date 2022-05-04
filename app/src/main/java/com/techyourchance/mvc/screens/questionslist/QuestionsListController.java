package com.techyourchance.mvc.screens.questionslist;

import com.techyourchance.mvc.questions.FetchLastActiveQuestionsUseCase;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.screensnavigator.ScreensNavigator;
import com.techyourchance.mvc.screens.common.toastshelper.ToastsHelper;

import java.util.List;

/**
 * Created by David Chhetri on 04,May,2022
 */
public class QuestionsListController implements
        QuestionsListViewMvc.Listener, FetchLastActiveQuestionsUseCase.Listener {

    private QuestionsListViewMvc mViewMvc;
    private final FetchLastActiveQuestionsUseCase mFetchLastActiveQuestionsUseCase;
    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;

    public QuestionsListController(FetchLastActiveQuestionsUseCase fetchLastActiveQuestionsUseCase, ScreensNavigator screensNavigator, ToastsHelper toastsHelper) {
        mFetchLastActiveQuestionsUseCase = fetchLastActiveQuestionsUseCase;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
    }

    public void bindView(QuestionsListViewMvc viewMvc){
        mViewMvc = viewMvc;
    }

    public void onStart(){
        mViewMvc.registerListener(this);
        mFetchLastActiveQuestionsUseCase.registerListener(this);
        mFetchLastActiveQuestionsUseCase.fetchQuestionsAndNotify();

    }

    public void onStop(){
        mViewMvc.unregisterListener(this);
        mFetchLastActiveQuestionsUseCase.unregisterListener(this);

    }

    @Override
    public void onQuestionsListFetchedSuccess(List<Question> questions) {
        mViewMvc.bindQuestions(questions);

    }

    @Override
    public void onQuestionsListFetchedFailure() {
        mToastsHelper.showUseCaseError();

    }

    @Override
    public void onQuestionClicked(Question question) {
        mScreensNavigator.toDialogDetails(question.getId());

    }

    @Override
    public void onQuestionsListClicked() {
        //this is the QuestionsList screen no op
    }

    public Boolean onBackPressed() {
        if(mViewMvc.isDrawerOpen()){
            mViewMvc.closeDrawer();
            return true;
        }else {
            return false;
        }
    }

}

