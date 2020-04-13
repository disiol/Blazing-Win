package com.blazingwin.ber.routers.main;

import com.blazingwin.ber.R;
import com.blazingwin.ber.routers.base.BaseRouter;
import com.blazingwin.ber.ui.activities.MainActivity;
import com.blazingwin.ber.ui.fragments.quiz.view.QuizFragment;
import com.blazingwin.ber.ui.fragments.start.view.StartFragment;
import com.blazingwin.ber.ui.fragments.web.view.WebFragment;

import javax.inject.Inject;


public class MainActivityRouterImpl extends BaseRouter<MainActivity> implements MainActivityRouter {


    @Inject
    MainActivityRouterImpl(MainActivity activity) {
        super(activity);
    }



    @Override
    public void showLogoFragment() {
        if (!isCurrentFragment(R.id.fragment_container, StartFragment.class)) {
            replaceFragment(R.id.fragment_container, new StartFragment());
        }
    }
    @Override
    public void showWebFragment() {
        if(!isCurrentFragment(R.id.fragment_container, WebFragment.class)) {
            replaceFragment(R.id.fragment_container, new WebFragment());
        }
    }

    @Override
    public void showGameFragment() {
        if(!isCurrentFragment(R.id.fragment_container, QuizFragment.class)) {
            replaceFragment(R.id.fragment_container, new QuizFragment());
        }
    }


}
