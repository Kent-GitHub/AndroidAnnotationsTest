package com.example.androidannotationstest;

import java.util.ArrayList;
import java.util.List;

import listviewutils.CommomAdapter;
import listviewutils.CommomViewHolder;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.sec_main)
public class CopyOfSecActivity extends Activity {

	@Extra(MainActivity.NAME_KEY)
	String name;

	@Extra(MainActivity.AGE_KEY)
	int age;

	@ViewById(R.id.sec_listView)
	ListView mListView;
	
	private List<String> mDatas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		CommomAdapter< String> adapter=new CommomAdapter<String>(this, mDatas, R.layout.list_item_view) {
			@Override
			public void setDatas(CommomViewHolder holder, String t) {
				((TextView)holder.getView(R.id.item_tv)).setText(t);
			}
		};
		mListView.setAdapter(adapter);
	}

	private void init() {
		mDatas=new ArrayList<String>();
		for (int i = 0; i < 101; i++) {
			mDatas.add("Item : "+i);
		}
	}

	@AfterViews
	void afterViews() {
		Toast.makeText(getApplicationContext(),
				"Name : " + name + " age : " + age, 0).show();
	}
}
