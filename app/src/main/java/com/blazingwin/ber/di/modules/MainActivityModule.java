package com.blazingwin.ber.di.modules;

import com.blazingwin.ber.di.scopes.ActivityScope;
import com.blazingwin.ber.di.scopes.FragmentScope;
import com.blazingwin.ber.routers.main.MainActivityRouter;
import com.blazingwin.ber.routers.main.MainActivityRouterImpl;
import com.blazingwin.ber.ui.fragments.start.view.StartFragment;
import com.blazingwin.ber.ui.fragments.web.view.WebFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {
    @ActivityScope
    @Binds
    MainActivityRouter mainActivityRouter(MainActivityRouterImpl mainRouter);

    @FragmentScope
    @ContributesAndroidInjector
    WebFragment webFragment();

    @FragmentScope
    @ContributesAndroidInjector
    StartFragment logoFragment();


}
