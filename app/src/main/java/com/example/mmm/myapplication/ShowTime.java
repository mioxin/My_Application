package com.example.mmm.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ShowTime extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);
        final String LOG_TAG = "myLogs";
        Intent intent = getIntent();
        String action = intent.getAction();
        String format ="", info = "";

        if (action.equals("com.example.mmm.myapplication.intent.action.ShowTime")) {
            format = "HH:mm:ss";
            info = "Time: ";
        }
        if (action.equals("com.example.mmm.myapplication.intent.action.ShowDate")) {
            format = "dd.MM.yyyy";
            info = "Date: ";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String time = sdf.format(new Date(System.currentTimeMillis()));
        TextView tvTime = (TextView) findViewById(R.id.tvTime);
        tvTime.setText(info + time);

        LayoutInflater ltInflater = getLayoutInflater();
        LinearLayout lLayout = (LinearLayout)findViewById(R.id.lLayout);
        View view1 = ltInflater.inflate(R.layout.text, lLayout, true);
        ViewGroup.LayoutParams lp1 = view1.getLayoutParams();
//        lLayout.addView(view1);

        Log.d(LOG_TAG, "Class of view: " + view1.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view1: " + lp1.getClass().toString());
//        Log.d(LOG_TAG, "Text of view: " + ((TextView) view1).getText());

        RelativeLayout rLayout = (RelativeLayout)findViewById(R.id.rLayout);
        View view2 = ltInflater.inflate(R.layout.text, rLayout, true);
        ViewGroup.LayoutParams lp2 = view2.getLayoutParams();
//        lLayout.addView(view1);

        Log.d(LOG_TAG, "Class of view: " + view2.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view2: " + lp2.getClass().toString());
//        Log.d(LOG_TAG, "Text of view: " + ((TextView) view2).getText());
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.show_time, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
