package com.alu.dailyworkuts.android.data;

import android.content.Context;

import com.alu.dailyworkuts.android.R;
import com.alu.dailyworkuts.android.bean.WorkoutsGroupBean;
import com.alu.dailyworkuts.android.bean.WorkoutsItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：fuchangle on 2018/1/12 11:23
 */

public class DataConfig {

    private static DataConfig appInstance;

    private DataConfig() {
        super();
    }

    public static DataConfig getInstance(){
        if (appInstance == null){
            appInstance = new DataConfig();
        }
        return appInstance;
    }

    /**
     * 初始化列表运动项目数据
     * @return
     */
    private static final int[][] projectIds = new int[][]{{201, 202, 203}, {301, 302, 303}, {401, 402, 403}, {501, 502, 503}};
    private static final int[][] projectBgDrawable = new int[][]{
            {R.drawable.workuts_xiongbu_1, R.drawable.workuts_xiongbu_2, R.drawable.workuts_xiongbu_3},
            {R.drawable.workuts_fubu_1, R.drawable.workuts_fubu_2, R.drawable.workuts_fubu_3},
            {R.drawable.workuts_jianbu_1, R.drawable.workuts_jianbu_2, R.drawable.workuts_jianbu_3},
            {R.drawable.workuts_tuibu_1, R.drawable.workuts_tuibu_2, R.drawable.workuts_tuibu_3}};


    public List<WorkoutsGroupBean> initWorkoutProjectData(Context context){
        List<WorkoutsGroupBean> projectBeanList = new ArrayList<>();
        for (int i=0; i<projectIds.length; i++){
            WorkoutsGroupBean workoutsGroupBean = new WorkoutsGroupBean();

            List<WorkoutsItemBean> listWorkoutsItems =  new ArrayList<>();
            workoutsGroupBean.setGroupLabName(context.getResources().getStringArray(R.array.workuts_project)[i]);
            for (int j=0; j<projectIds[i].length; j++){
                WorkoutsItemBean workoutsItemBean = new WorkoutsItemBean();
                workoutsItemBean.setProjuctId(projectIds[i][j]);
                workoutsItemBean.setDrawableId(projectBgDrawable[i][j]);
                if(i == 0){ //胸部
                    workoutsItemBean.setProjuctName(context.getResources().getStringArray(R.array.workuts_project_xiongbu)[j]);
                } else if ( i == 1) { //腹部
                    workoutsItemBean.setProjuctName(context.getResources().getStringArray(R.array.workuts_project_fubu)[j]);
                } else if ( i == 2) { //肩部
                    workoutsItemBean.setProjuctName(context.getResources().getStringArray(R.array.workuts_project_jianbu)[j]);
                } else if ( i == 3) { //腿部
                    workoutsItemBean.setProjuctName(context.getResources().getStringArray(R.array.workuts_project_tuibu)[j]);
                }
                listWorkoutsItems.add(workoutsItemBean);
            }
            workoutsGroupBean.setListWorkoutsItem(listWorkoutsItems);
            projectBeanList.add(workoutsGroupBean);
        }
        return projectBeanList;
    }
}
