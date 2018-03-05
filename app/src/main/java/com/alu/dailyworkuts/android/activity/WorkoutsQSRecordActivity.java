package com.alu.dailyworkuts.android.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alu.dailyworkuts.android.R;
import com.alu.dailyworkuts.android.base.BaseActivity;

/**
 * 全身运动 记录
 * 作者：chenrui on 2018/1/18 14:51
 */

public class WorkoutsQSRecordActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbarTitle().setText(getString(R.string.lab_7x4));
        initView();
        initData();
        setListener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_qs_record;
    }

    private void initView(){

    }

    private void initData(){

    }

    private void setListener(){

    }
}
