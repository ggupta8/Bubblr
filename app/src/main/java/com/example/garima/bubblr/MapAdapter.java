package com.example.garima.bubblr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by chenyinghe on 11/15/16.
 */

public class MapAdapter extends BaseAdapter {
    private final ArrayList mData;
    private final Context context;

    public MapAdapter(Map<String, ArrayList<String>> map, Context context) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
        this.context=context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, ArrayList<String>> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_adapter_item, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, ArrayList<String>> item = getItem(position);

        ((TextView) result.findViewById(android.R.id.text1)).setText(item.getKey());

        //HorizontalScrollView
        //((TextView) result.findViewById(android.R.id.text2)).setText(item.getValue());
        ArrayAdapter<String> titleAdapter = new ArrayAdapter<String>(this.context,
                android.R.layout.simple_list_item_1, item.getValue());

        /*
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        */

        return result;
    }

}

