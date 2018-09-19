package com.synertone.dagger2demo;
import android.app.Application;
import com.synertone.dagger2demo.di.component.AppComponent;
import com.synertone.dagger2demo.di.component.DaggerAppComponent;
import com.synertone.dagger2demo.di.module.AppModule;

public class App extends Application{
    private static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();


    }
    public static AppComponent getAppComponent(){
        if(appComponent==null){
            synchronized (AppComponent.class){
                if(appComponent==null){
                    appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
                }
            }
        }
       return appComponent;
    }
}
