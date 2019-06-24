package com.example.rv193.mvvmudemy.base;

import android.app.Application;
import android.content.Context;

public class MvvmApp extends Application {
/*
we create an app component, then create modules to component
then create a reference of the component in the app class
add MvvmApp as the application .name in manifest
 */
private ApplicationComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
//        get a reference to component by adding Dagger to the object
        component = DaggerApplicationComponent.create();
    }

//    any object can get a reference to this component using just the context
    public static ApplicationComponent getApplicationComponent(Context context) {
        return ((MvvmApp) context.getApplicationContext()).component;
    }
}
