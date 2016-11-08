package com.example.garima.bubblr;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        {
            //android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            //actionBar.hide();
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
