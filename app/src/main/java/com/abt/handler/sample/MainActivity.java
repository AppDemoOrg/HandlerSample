package com.abt.handler.sample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.abt.handler.R;
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
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
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

//        msg = Message.obtain();
//        msg.what = 1;
//        mHandler.sendMessage(msg);
//        Logger.d("send msg1.");

        msg = Message.obtain();
        msg.what = 1;
        mHandler.sendMessageDelayed(msg, 4*1000);
        Logger.d("send msg1 delay 4 second.");

        msg = Message.obtain();
        msg.what = 2;
        mHandler.sendMessageDelayed(msg, 2*1000);
        Logger.d("send msg2 delay 2 second.");

        try {
            Logger.d("start to sleep.");
            Thread.sleep(6*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.d("sleep ended.");
    }
}
