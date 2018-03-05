package com.alu.dailyworkuts.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alu.dailyworkuts.android.R;
import com.alu.dailyworkuts.android.adapter.common.CCAdapterHolder;
import com.alu.dailyworkuts.android.adapter.common.CCListAdapter;
import com.alu.dailyworkuts.android.bean.WorkoutsGroupBean;
import com.alu.dailyworkuts.android.bean.WorkoutsItemBean;
import com.alu.dailyworkuts.android.utils.DensityUtils;
import com.alu.dailyworkuts.android.utils.RadiusImageUtils;

import java.util.List;

/**
 * 作者：fuchangle on 2018/1/5 11:01
 */

public class WorkutsListAdapter extends CCListAdapter{

    private Context context;
    private List<WorkoutsGroupBean> listWorkutGroups;

    public WorkutsListAdapter(Context context, List<WorkoutsGroupBean> adapterContent) {
        super(context, adapterContent);
        this.context = context;
        this.listWorkutGroups = adapterContent;
    }

    @Override
    public CCAdapterHolder createHolder(int type) {

        return new CCAdapterHolder() {

            TextView tv_name;
            LinearLayout llWorkoutsitemGroup;

            @Override
            public int getResource() {
                return R.layout.item_workouts_group;
            }

            @Override
            public void initializeView(View convertView) {
                tv_name = convertView.findViewById(R.id.tv_project_name);
                llWorkoutsitemGroup = convertView.findViewById(R.id.ll_workoutsitem_group);
            }

            @Override
            public void updateView(Object content, int position) {
                tv_name.setText(listWorkutGroups.get(position).getGroupLabName());
                llWorkoutsitemGroup.removeAllViews();
                List<WorkoutsItemBean> listWorkoutsItems = listWorkutGroups.get(position).getListWorkoutsItem();
                if(listWorkoutsItems != null && listWorkoutsItems.size() > 0){
                    for(WorkoutsItemBean workoutsItemBean : listWorkoutsItems){
                        View view = LayoutInflater.from(context).inflate(R.layout.item_workouts_item, null);
                        RelativeLayout rlWorkoutsItem = view.findViewById(R.id.rl_workouts_item);
                        rlWorkoutsItem.setBackground(RadiusImageUtils.getDrawableForRes(context, workoutsItemBean.getDrawableId(), DensityUtils.dp2px(context, 8)));
                        TextView tvProjuctName = view.findViewById(R.id.tv_project_name);
                        tvProjuctName.setText(workoutsItemBean.getProjuctName());
                        llWorkoutsitemGroup.addView(view);
                    }
                }
            }
        };
    }
}
