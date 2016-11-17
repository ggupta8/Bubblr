package com.example.garima.bubblr;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by chenyinghe on 11/17/16.
 */

public class LinearLayoutListView extends LinearLayout {
    ListView listView;

    public LinearLayoutListView(Context context) {
        super(context);
    }

    public LinearLayoutListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayoutListView(Context context, AttributeSet attrs,
                                int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListView(ListView lv){
        listView = lv;
    }
}
