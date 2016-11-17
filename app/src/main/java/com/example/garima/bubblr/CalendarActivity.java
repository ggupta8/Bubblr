package com.example.garima.bubblr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CalendarActivity extends AppCompatActivity {

    HashMap<String,ArrayList<String>> calendarDictionary=new HashMap<>();
    //ArrayList<String> tags=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> school=new ArrayList<>();
        school.add("Oct 18");
        school.add("Oct 20");
        school.add("Oct 22");
        school.add("Oct 24");
        school.add("Oct 26");
        school.add("Oct 28");

        calendarDictionary.put("school",school);
        calendarDictionary.put("work",school);
        calendarDictionary.put("leisure",school);
        /*
        tags.add("school");
        tags.add("work");
        tags.add("leisure");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tags);

        */
        /*
        MapAdapter adapter=new MapAdapter(calendarDictionary,this);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        */
        LayoutInflater li= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout ll= (LinearLayout) findViewById(R.id.content_calendar);

        for (HashMap.Entry<String, ArrayList<String>> entry : calendarDictionary.entrySet()) {
            View v=li.inflate(R.layout.map_adapter_item,null,false);

            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();

            TextView textView= (TextView) v.findViewById(R.id.textview);
            textView.setText(key);

            LinearLayout horizontalScrollView= (LinearLayout) v.findViewById(R.id.category_layout);
            for(String valueElement:value){
                TextView valueTextView= (TextView) li.inflate(android.R.layout.simple_list_item_1,null,false);
                //TextView valueTextView= (TextView)horizontalScrollView.inflate(R.layout.map_adapter_item,null,false);
                valueTextView.setText(valueElement);
                horizontalScrollView.addView(valueTextView);
            }


            ll.addView(v);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                callCalendarSettingsActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void callCalendarSettingsActivity(){
        Intent intent = new Intent(this, CalendarSettingsActivity.class);
        startActivity(intent);
    }
}

