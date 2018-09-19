package com.synertone.dagger2demo.di.component;

import com.synertone.dagger2demo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    OkHttpClient getOkHttpClient();
}
