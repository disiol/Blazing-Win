package com.blazingwin.ber.ui.base;

import android.widget.ProgressBar;

import com.blazingwin.ber.routers.main.MainActivityRouter;


public interface BaseView {

    void showProgress(ProgressBar progressBar);

    void hideProgress(ProgressBar progressBar);

    void showMessage(int messageResId, String message);

    void showError(Throwable throwable, MainActivityRouter mainActivityRouter);
}
