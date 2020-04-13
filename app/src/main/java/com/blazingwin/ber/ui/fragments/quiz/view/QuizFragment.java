package com.blazingwin.ber.ui.fragments.quiz.view;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.blazingwin.ber.R;
import com.blazingwin.ber.databinding.StartBinding;
import com.blazingwin.ber.manedger.PreferencesManager;
import com.blazingwin.ber.routers.main.MainActivityRouter;
import com.blazingwin.ber.ui.base.BaseBindingFragment;
import com.blazingwin.ber.ui.fragments.quiz.Question;
import com.blazingwin.ber.ui.fragments.quiz.presenter.QuizPresenter;

import javax.inject.Inject;

import static com.blazingwin.ber.constants.Constants.MYLOG_TEG;

public class QuizFragment extends BaseBindingFragment<QuizPresenter, StartBinding> implements QuizView {


    private static final String KEY_INDEX = "INDEX";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;

    private TextView mQuestionTextView;

    @Inject
    PreferencesManager preferencesManager;
    private String[] answers;

    @Override
    public int getLayoutResId() {
        return R.layout.acfragment_qviz;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        answers = getResources().getStringArray(R.array.answers);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = getActivity().findViewById(R.id.textViewQuestion);
        setTextQuestion();

        mTrueButton = getActivity().findViewById(R.id.buttonTrue);
        mTrueButton.setOnClickListener(v -> checkAnswer(true));

        mFalseButton = getActivity().findViewById(R.id.buttonFalse);
        mFalseButton.setOnClickListener(v -> checkAnswer(false));


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, mCurrentIndex);
    }


    private void setTextQuestion() {
        int question = mQuestions[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
    }

    private Question[] mQuestions = new Question[]{
            new Question(R.string.question_1, false),
            new Question(R.string.question_2, true),
            new Question(R.string.question_3, false),
            new Question(R.string.question_4, false),
            new Question(R.string.question_5, true),
    };

    private int mCurrentIndex = 0;

    private void checkAnswer(boolean rightAnswer) {
        boolean answerIsTrue = mQuestions[mCurrentIndex].ismIsRightAnswer();
        int messageResId;
        if (rightAnswer == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        showMessage(messageResId, answers[mCurrentIndex]);
    }

    @Override
    public void showMessage(int messageResId, String message) {

        Log.d(MYLOG_TEG, "showMessage:  " + message);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message).setTitle(messageResId)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        (dialog, id) -> {
                            mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                            setTextQuestion();

                            dialog.cancel();
                        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    public void showError(Throwable throwable, MainActivityRouter mainActivityRouter) {

    }
}