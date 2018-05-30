package com.abt.handler;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @描述： @HandlerApplication
 * @作者： @黄卫旗
 * @创建时间： @30/05/2018
 */
public class HandlerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
