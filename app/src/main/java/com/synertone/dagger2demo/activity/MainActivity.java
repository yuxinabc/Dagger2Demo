package com.synertone.dagger2demo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.synertone.dagger2demo.App;
import com.synertone.dagger2demo.R;
import com.synertone.dagger2demo.bean.FactoryProduct;
import com.synertone.dagger2demo.bean.MyOkHttpClient;
import com.synertone.dagger2demo.bean.Product;
import com.synertone.dagger2demo.di.component.DaggerActivityComponent;


import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    /**
     * Product,FactoryProduct对象是自己写的类，在构造方法上加入@Inject实现注入
     * OkHttpClient 为第三方类，利用AppModule通过@Provides实现注入
     * 这二种注入方式可以配合使用,参考MyOkHttpClient
     * Module并不是必需的，但Component是必不可少的；
     * 1、定义的Component和Module的名字是无所谓的，但是一般遵照以Component或Module结尾的名称；
     * 2、Module中用@Provides标注的方法的方法名是无所谓的，返回值是最重要的，但是一般遵照以provide开头的方法名；
     * 3、Component中返回值为void且有参的方法，方法名是无所谓的，参数是最重要的代表的是要注入的目标位置，但是方法名一般为inject；
     * 4、Component中返回值不为void且无参的方法，方法名是无所谓的，返回值是最重要的代表的是暴露给子Component使用的依赖或者是获取的子Component的类型。
     */
    @Inject
    Product mProduct;
    @Inject
    FactoryProduct factoryProduct;
    @Inject
    OkHttpClient okHttpClient;
    @Inject
    MyOkHttpClient myOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .build().inject(this);
        System.out.println(mProduct.toString());
        System.out.println(factoryProduct.toString() + "-------------" + factoryProduct.getProduct());
        System.out.println(okHttpClient.toString());
        System.out.println("myOkHttpClient  " + myOkHttpClient.toString() + "     realOkHttpClient" + myOkHttpClient.getOkHttpClient());

    }

    public void next(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
