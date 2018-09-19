package com.synertone.dagger2demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.synertone.dagger2demo.App;
import com.synertone.dagger2demo.R;
import com.synertone.dagger2demo.di.component.DaggerActivityComponent;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class Main2Activity extends AppCompatActivity {
    @Inject
    OkHttpClient okHttpClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .build().inject(this);
        System.out.println("Main2Activity    "+okHttpClient.toString());
    }
}
