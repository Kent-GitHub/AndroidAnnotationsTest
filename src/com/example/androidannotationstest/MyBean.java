package com.example.androidannotationstest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import android.util.Log;
//(scope=Scope.Default)-->每次都注入、(scope=Scope.Singleton)每次都注入
@EBean(scope=Scope.Default)
public class MyBean {
	
	@AfterInject
	void doSomethingAfterInjection(){
		Log.d("MyBean", "MyBean was Injected");
	}
}
