package com.alu.dailyworkuts.android.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：fuchangle on 2018/1/4 15:07
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

    private Context context;
    private List<Fragment> fms;
    private int arrayId;

    public MyFragmentPagerAdapter(Context context, FragmentManager fragmentManager, List<Fragment> fms, int arrayId){
        super(fragmentManager);
        this.context = context;
        this.fms = fms;
        this.arrayId = arrayId;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Fragment getItem(int position) {
        return fms.get(position);
    }

    @Override
    public int getCount() {
        return fms.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getStringArray(arrayId)[position];
    }
}
