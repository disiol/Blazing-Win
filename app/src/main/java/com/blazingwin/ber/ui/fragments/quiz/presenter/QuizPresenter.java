package com.blazingwin.ber.ui.fragments.quiz.presenter;


import android.text.TextUtils;

import androidx.databinding.library.baseAdapters.BuildConfig;
import androidx.fragment.app.FragmentActivity;

import com.blazingwin.ber.R;
import com.blazingwin.ber.interactor.DataStore;
import com.blazingwin.ber.routers.main.MainActivityRouter;
import com.blazingwin.ber.ui.base.BasePresenter;
import com.blazingwin.ber.ui.fragments.quiz.view.QuizView;
import com.blazingwin.ber.util.Keys;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class QuizPresenter extends BasePresenter<QuizView> {

    private MainActivityRouter mainActivityRouter;
    @Inject
    QuizPresenter(MainActivityRouter mainActivityRouter, DataStore dataStore) {
        this.mainActivityRouter = mainActivityRouter;
    }


    public void newGame() {
        mainActivityRouter.showGameFragment();
    }
}
