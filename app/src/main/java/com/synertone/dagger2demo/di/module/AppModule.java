package com.synertone.dagger2demo.di.module;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class AppModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
      return new OkHttpClient();
    }
}
