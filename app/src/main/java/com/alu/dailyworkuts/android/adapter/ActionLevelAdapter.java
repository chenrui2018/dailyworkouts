package com.alu.dailyworkuts.android.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.alu.dailyworkuts.android.R;
import com.alu.dailyworkuts.android.adapter.common.CCAdapterHolder;
import com.alu.dailyworkuts.android.adapter.common.CCListAdapter;

import java.util.List;

/**
 * 作者：chenrui on 2018/1/6 17:20
 */

public class ActionLevelAdapter extends CCListAdapter<String>{

    public ActionLevelAdapter(Context context, List<String> adapterContent) {
        super(context, adapterContent);
    }

    @Override
    public CCAdapterHolder<String> createHolder(int type) {
        return new CCAdapterHolder<String>() {

            TextView tvName;

            @Override
            public int getResource() {
                return R.layout.item_actionlevel;
            }

            @Override
            public void initializeView(View convertView) {
                
            }

            @Override
            public void updateView(String content, int position) {

            }
        };
    }
}
