package com.blazingwin.ber.ui.fragments.quiz;

public class Question {
    private int mTextResId;
    private boolean mIsRightAnswer;

    public Question(int textResId, boolean isRightAnswer) {
        mTextResId = textResId;
        mIsRightAnswer = isRightAnswer;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public boolean ismIsRightAnswer() {
        return mIsRightAnswer;
    }
}