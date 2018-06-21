package com.abt.handler.memory_leak;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

/**
 * @描述： @LeakActivity
 * @作者： @黄卫旗
 * @创建时间： @22/06/2018
 */
public class LeakActivity extends Activity {

    // 可能引入内存泄漏的用法
    private final Handler mLeakHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("mLeakHandler handleMessage");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLeakHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("mLeakHandler run");
            }
        }, 1000*60*5); // 延迟5分钟发送消息
    }
}
