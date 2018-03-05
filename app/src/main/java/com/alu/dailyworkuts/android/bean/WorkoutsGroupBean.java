package com.alu.dailyworkuts.android.bean;

import com.alu.dailyworkuts.android.base.BaseBean;

import java.util.List;

/**
 * 作者：fuchangle on 2018/1/12 11:24
 */

public class WorkoutsGroupBean extends BaseBean{

    private String groupLabName;

    private List<WorkoutsItemBean> listWorkoutsItem;

    public String getGroupLabName() {
        return groupLabName;
    }

    public void setGroupLabName(String groupLabName) {
        this.groupLabName = groupLabName;
    }

    public List<WorkoutsItemBean> getListWorkoutsItem() {
        return listWorkoutsItem;
    }

    public void setListWorkoutsItem(List<WorkoutsItemBean> listWorkoutsItem) {
        this.listWorkoutsItem = listWorkoutsItem;
    }
}
