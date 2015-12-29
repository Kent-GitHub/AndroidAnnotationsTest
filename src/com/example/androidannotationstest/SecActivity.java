package com.example.androidannotationstest;

import java.util.ArrayList;
import java.util.List;

import listviewutils.CommomAdapter;
import listviewutils.CommomViewHolder;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.sec_main)
public class SecActivity extends ParentActy {

	@Extra(MainActivity.NAME_KEY)
	String name;

	@Extra(MainActivity.AGE_KEY)
	int age;

	@ViewById(R.id.sec_listView)
	ListView mListView;
	
	@ItemClick(R.id.sec_listView)
	void listViewItemClick(int position){
		Toast.makeText(getApplicationContext(),
				"Click on position : " + position, 0).show();
	}
	
	@ItemLongClick(R.id.sec_listView)
	void listViewItemLongClick(int position){
		Toast.makeText(getApplicationContext(),
				"LongClick on position : " + position, 0).show();
	}
	
	private List<String> mdatas;
	private CommomAdapter< String> mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		mAdapter=new CommomAdapter<String>(this, mdatas, R.layout.list_item_view) {
			@Override
			public void setDatas(CommomViewHolder holder, String t) {
				((TextView)holder.getView(R.id.item_tv)).setText(t);
			}
		};
		
	}
		
	private void init() {
		mdatas=new ArrayList<String>();
		for (int i = 0; i < 101; i++) {
			mdatas.add("Item : "+i);
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		mListView.setAdapter(mAdapter);
	}
	
	@Override //No@AfterViews
	protected  void afterViews() {
		super.afterViews();
		Log.d("SecActivity", "afterViews");
		Toast.makeText(getApplicationContext(),
				"Name : " + name + " age : " + age, 0).show();
		
	}
	
	@Bean
	MyBean mBean;
	
}
