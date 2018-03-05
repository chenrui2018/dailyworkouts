package com.alu.dailyworkuts.android.bean;

import com.alu.dailyworkuts.android.base.BaseBean;

/**
 * 作者：fuchangle on 2018/1/18 11:05
 */

public class WorkoutsItemBean extends BaseBean{

    private int projuctId;

    private String projuctName;

    private String lastTime;

    private int drawableId;

    public String getProjuctName() {
        return projuctName;
    }

    public void setProjuctName(String projuctName) {
        this.projuctName = projuctName;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int getProjuctId() {
        return projuctId;
    }

    public void setProjuctId(int projuctId) {
        this.projuctId = projuctId;
    }
}
