package com.synertone.dagger2demo.di.component;

import com.synertone.dagger2demo.activity.MainActivity;
import com.synertone.dagger2demo.activity.Main2Activity;
import com.synertone.dagger2demo.di.scope.ActivityScope;


import dagger.Component;
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(Main2Activity activity);
}
