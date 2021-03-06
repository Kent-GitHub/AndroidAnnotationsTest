//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package com.example.androidannotationstest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.example.androidannotationstest.R.id;
import com.example.androidannotationstest.R.layout;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class EActivityDemo_
    extends EActivityDemo
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private final IntentFilter intentFilter1_ = new IntentFilter();
    private final BroadcastReceiver onActionReceiver_ = new BroadcastReceiver() {


        public void onReceive(Context context, Intent intent) {
            EActivityDemo_.this.onAction();
        }

    }
    ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.activity_main);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        intentFilter1_.addAction("com.mybrocast.receiveraction");
        this.registerReceiver(onActionReceiver_, intentFilter1_);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static EActivityDemo_.IntentBuilder_ intent(Context context) {
        return new EActivityDemo_.IntentBuilder_(context);
    }

    public static EActivityDemo_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new EActivityDemo_.IntentBuilder_(fragment);
    }

    public static EActivityDemo_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new EActivityDemo_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        btn_test = ((Button) hasViews.findViewById(id.btn_test));
        btn_start_sec = ((Button) hasViews.findViewById(id.btn_start_sec));
        btn_brocast = ((Button) hasViews.findViewById(id.btn_brocast));
        if (btn_start_sec!= null) {
            btn_start_sec.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    EActivityDemo_.this.btnTest(view);
                }

            }
            );
            btn_start_sec.setOnLongClickListener(new OnLongClickListener() {


                @Override
                public boolean onLongClick(View view) {
                    EActivityDemo_.this.longClick();
                    return true;
                }

            }
            );
        }
        if (btn_test!= null) {
            btn_test.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    EActivityDemo_.this.btnTest(view);
                }

            }
            );
            btn_test.setOnLongClickListener(new OnLongClickListener() {


                @Override
                public boolean onLongClick(View view) {
                    EActivityDemo_.this.longClick();
                    return true;
                }

            }
            );
        }
        if (btn_brocast!= null) {
            btn_brocast.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    EActivityDemo_.this.btnTest(view);
                }

            }
            );
        }
        afterView();
    }

    @Override
    public void onDestroy() {
        this.unregisterReceiver(onActionReceiver_);
        super.onDestroy();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<EActivityDemo_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, EActivityDemo_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), EActivityDemo_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), EActivityDemo_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                        fragment_.startActivityForResult(intent, requestCode, lastOptions);
                    } else {
                        fragment_.startActivityForResult(intent, requestCode);
                    }
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent, lastOptions);
                        } else {
                            context.startActivity(intent);
                        }
                    }
                }
            }
        }

    }

}
