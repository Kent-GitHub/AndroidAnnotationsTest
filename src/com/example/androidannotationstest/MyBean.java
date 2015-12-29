package com.example.androidannotationstest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

import android.util.Log;
//(scope=Scope.Default)-->ÿ�ζ�ע�롢(scope=Scope.Singleton)ÿ�ζ�ע��
@EBean(scope=Scope.Default)
public class MyBean {
	
	@AfterInject
	void doSomethingAfterInjection(){
		Log.d("MyBean", "MyBean was Injected");
	}
}
