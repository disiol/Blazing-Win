package com.blazingwin.ber.ui.fragments.web.presenter;



import com.blazingwin.ber.ui.base.BasePresenter;
import com.blazingwin.ber.ui.fragments.web.view.WebView;

import javax.inject.Inject;

public class WebPresenter extends BasePresenter<WebView> {

    @Inject
    WebPresenter(){
    }

    public void showSite() {
        getView().showSite();
    }
}
