//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package com.example.androidannotationstest;

import android.content.Context;

public final class MyBean_
    extends MyBean
{

    private Context context_;

    private MyBean_(Context context) {
        context_ = context;
        init_();
    }

    public static MyBean_ getInstance_(Context context) {
        return new MyBean_(context);
    }

    private void init_() {
        doSomethingAfterInjection();
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}