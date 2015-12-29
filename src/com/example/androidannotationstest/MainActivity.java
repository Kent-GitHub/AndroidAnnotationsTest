package com.example.androidannotationstest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.ReceiverAction;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	public static final String NAME_KEY = "name_key";
	public static final String AGE_KEY = "age_key";
	private String LOG_TAG = "MainActivity";

	@ViewById
	Button btn_start_sec, btn_test,btn_brocast;

	@Click({ R.id.btn_start_sec, R.id.btn_test ,R.id.btn_brocast})
	void btnTest(View v) {
		switch (v.getId()) {
		case R.id.btn_start_sec:
//			Log.d("MainActivity", "btn_start_sec");
//			Intent i = new Intent(MainActivity.this, SecActivity_.class);
//			i.putExtra(NAME_KEY, "Nate");
//			i.putExtra(AGE_KEY, 18);
//			startActivity(i);
			SecActivity_.intent(this).extra(NAME_KEY, "Nate").extra(AGE_KEY, 18).start();
			break;
		case R.id.btn_test:
//			Log.d("MainActivity", "btn_test");
			Toast.makeText(
					this,
					"LENGTH_SHORT : " + Toast.LENGTH_SHORT + "  LENGTH_LONG : "
							+ Toast.LENGTH_LONG, 0).show();
			break;
		case R.id.btn_brocast:
//			Log.d("MainActivity", "btn_brocast");
			Intent intent = new Intent("com.mybrocast.receiveraction");    
            intent.putExtra("name", "Nate");    
            sendBroadcast(intent); 
			break;
		}
	}
	
	@LongClick({ R.id.btn_start_sec, R.id.btn_test })
	void longClick(){
		Toast.makeText(this, "You had just LongClick this Buttom.", 0).show();
	}
	
	@AfterViews
	void afterView() {
		MyReceiver receiver=new MyReceiver(){
			@ReceiverAction("com.mybrocast.receiveraction")
			void receiverAction(){
				Log.d("MyReceiver", "@ReceiverAction");
			}
		};
		IntentFilter filter = new IntentFilter();  
        filter.addAction("com.mybrocast.receiveraction");  
		this.registerReceiver(receiver, filter);
//		Log.d(LOG_TAG, "afterView");
	}

	@Receiver(actions="com.mybrocast.receiveraction")
	protected void onAction(){
		Log.d("MainActivity", "onAction");
	}
	
}
