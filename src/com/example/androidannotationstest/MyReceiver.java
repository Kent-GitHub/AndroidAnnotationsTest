package com.example.androidannotationstest;

import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.ReceiverAction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

@EReceiver
public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@ReceiverAction
	void myAction(@ReceiverAction.Extra String valueString, Context context) {  
		Log.d("MyReceiver", "myAction : "+ valueString);
    }  
	
	@ReceiverAction  
    void anotherAction(Context context, @ReceiverAction.Extra("name") String valueString, @ReceiverAction.Extra long valueLong) {  
		Log.d("MyReceiver", "anotherAction : "+ valueString);
    } 
	
}
