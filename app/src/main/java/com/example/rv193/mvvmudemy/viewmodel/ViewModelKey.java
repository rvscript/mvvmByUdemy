package com.example.rv193.mvvmudemy.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
An annotation that is a MapKey for dagger
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
