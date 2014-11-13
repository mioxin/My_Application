package com.example.mmm.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ShowTime extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);

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
