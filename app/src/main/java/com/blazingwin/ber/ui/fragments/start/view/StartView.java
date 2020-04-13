package com.blazingwin.ber.ui.fragments.start.view;


import com.blazingwin.ber.routers.main.MainActivityRouter;
import com.blazingwin.ber.ui.base.BaseView;

;

public interface StartView extends BaseView {

    void showGame(MainActivityRouter mainActivityRouter);

    void showWeb(MainActivityRouter mainActivityRouter);
}
