package com.synertone.dagger2demo.bean;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class MyOkHttpClient {
    private OkHttpClient okHttpClient;
    @Inject
    public MyOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
