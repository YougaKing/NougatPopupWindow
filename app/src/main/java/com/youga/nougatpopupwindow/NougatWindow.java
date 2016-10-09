package com.youga.nougatpopupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YougaKing on 2016/10/9.
 */

public class NougatWindow extends PopupWindow {

    private final ArrayAdapter<String> mAdapter;
    List<String> mStrings = new ArrayList<>();

    public NougatWindow(Context context) {

        setHeight(LayoutParams.MATCH_PARENT);
        setWidth(LayoutParams.MATCH_PARENT);
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#44000000")));
        View view = View.inflate(context, R.layout.window_nougat, null);
        setContentView(view);

        setFocusable(true);
        setOutsideTouchable(true);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, mStrings);
        listView.setAdapter(mAdapter);

        View layout = view.findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


    public void showWindow(View anchor, List<String> strings) {
        mStrings.clear();
        mStrings.addAll(strings);
        mAdapter.notifyDataSetChanged();
        showAsDropDown(anchor);
    }

}
