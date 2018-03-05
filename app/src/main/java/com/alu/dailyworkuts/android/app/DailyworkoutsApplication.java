package com.alu.dailyworkuts.android.app;

import android.app.Application;

import com.alu.dailyworkuts.android.data.DataConfig;

/**
 * 作者：fuchangle on 2018/1/12 11:29
 */

public class DailyworkoutsApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        DataConfig.getInstance();
    }
}
