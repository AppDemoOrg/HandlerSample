package com.abt.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

/**
 * @描述： @MainActivity
 * @作者： @黄卫旗
 * @创建时间： @20/05/2018
 */
public class MainActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Logger.d("msg.what"+msg.what);
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Message msg = Message.obtain();
        msg.what = 0;
        mHandler.sendMessage(msg);
        Logger.d("send msg0.");

        msg = Message.obtain();
        msg.what = 1;
        mHandler.sendMessageDelayed(msg, 10*1000);
        Logger.d("send msg1 delay 10 second.");

        msg = Message.obtain();
        msg.what = 2;
        mHandler.sendMessageDelayed(msg, 5*1000);
        Logger.d("send msg2 delay 5 second.");

        try {
            Logger.d("start to sleep.");
            Thread.sleep(15*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.d("sleep ended.");
    }
}
