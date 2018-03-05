package com.alu.dailyworkuts.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alu.dailyworkuts.android.R;
import com.alu.dailyworkuts.android.adapter.WorkutsListAdapter;
import com.alu.dailyworkuts.android.base.BaseActivity;
import com.alu.dailyworkuts.android.data.DataConfig;
import com.alu.dailyworkuts.android.utils.DensityUtils;
import com.alu.dailyworkuts.android.utils.RadiusImageUtils;
import com.alu.dailyworkuts.android.view.ScrollViewWithListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.view_toolbar)
    Toolbar viewToolbar;
    @Bind(R.id.tv_sport_num)
    TextView tvSportNum;
    @Bind(R.id.tv_sport_minute)
    TextView tvSportMinute;
    @Bind(R.id.rl_quanshen)
    RelativeLayout rlQuanshen;
    @Bind(R.id.lv_projects)
    ScrollViewWithListView lvProjects;
    @Bind(R.id.sv_main)
    ScrollView svMain;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getToolbarTitle().setText(getString(R.string.app_name));
        initView();
        initData();
        setListener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected boolean isShowBacking() {
        return false;
    }

    private void initView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, viewToolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        rlQuanshen.setBackground(RadiusImageUtils.getDrawableForRes(HomeActivity.this,
                R.drawable.workuts_quanshen, DensityUtils.dp2px(HomeActivity.this, 8)));
    }

    private void initData() {
        WorkutsListAdapter adapter = new WorkutsListAdapter(HomeActivity.this, DataConfig.getInstance().initWorkoutProjectData(HomeActivity.this));
        lvProjects.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        svMain.smoothScrollTo(0,0);
    }

    private void setListener() {

        viewToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        /**
         * 全身
         */
        rlQuanshen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, WorkoutsQSRecordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
