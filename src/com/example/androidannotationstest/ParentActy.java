package com.example.androidannotationstest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.util.Log;

@EActivity(R.layout.parent_acty)
public class ParentActy extends Activity{
	@AfterViews
	protected void afterViews(){
		Log.d("ParentActy", "afterViews");
	}
}
