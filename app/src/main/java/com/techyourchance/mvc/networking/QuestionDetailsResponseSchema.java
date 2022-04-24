package com.techyourchance.mvc.networking;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

/**
 * Created by David Chhetri on 24,April,2022
 */
public class QuestionDetailsResponseSchema {
    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionDetailsResponseSchema(QuestionSchema question) {
        mQuestions = Collections.singletonList(question);
    }

    public QuestionSchema getQuestion() {
        return mQuestions.get(0);
    }

}

