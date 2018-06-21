package com.abt.handler.memory_leak;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * @描述： @LeakActivity
 * @作者： @黄卫旗
 * @创建时间： @22/06/2018
 */
public class UnLeakActivity extends Activity {

    private final InnerHandler mHandler = new InnerHandler(this);

    private static final Runnable sRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("sRunnable run");
        }
    };

    private static class InnerHandler extends Handler {

        private final WeakReference<UnLeakActivity> mActivity;

        public InnerHandler(UnLeakActivity activity) {
            mActivity = new WeakReference<UnLeakActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            UnLeakActivity activity = mActivity.get();
            if (null != activity) {
                System.out.println("InnerHandler handleMessage");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.postDelayed(sRunnable, 1000*60*5);
    }
}
