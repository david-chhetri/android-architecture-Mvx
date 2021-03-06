package com.techyourchance.mvc.screens.questionslist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.techyourchance.mvc.questions.Question;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;

import java.util.ArrayList;
import java.util.List;


public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.MyViewHolder>
                implements  QuestionsListItemViewMvc.Listener{


    public interface Listener{
        void onQuestionClicked(Question question);
    }

    private  QuestionsListItemViewMvc mViewMvc;

    private final Listener mListener;
    private final ViewMvcFactory mFactory;
    private List<Question> mQuestions = new ArrayList<>();

    public QuestionsRecyclerAdapter( Listener listener, ViewMvcFactory factory) {
        mListener = listener;
        mFactory = factory;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        mViewMvc = mFactory.getQuestionListItemViewMvc(parent);
        mViewMvc.registerListener(this);
        return new MyViewHolder(mViewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mViewMvc.bindQuestion(mQuestions.get(i));

    }

    public void bindQuestions(List<Question> questions) {
        mQuestions = new ArrayList<>(questions);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    @Override
    public void onQuestionClicked(Question question) {
        //comes from itemlist listener
        mListener.onQuestionClicked(question);

    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        private final  QuestionsListItemViewMvc mViewMvc;

        public MyViewHolder(QuestionsListItemViewMvc itemView) {
            super(itemView.getRootView());
            mViewMvc = itemView;
        }

    }

}