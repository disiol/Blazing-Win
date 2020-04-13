package com.blazingwin.ber.di.modules;

import android.content.Context;

import com.blazingwin.ber.manedger.PreferencesManager;
import com.blazingwin.ber.manedger.PreferencesManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagersModule {

    @Provides
    @Singleton
    PreferencesManager providePreferencesManager(Context context){
        return new PreferencesManagerImpl(context);
    }


}
