package com.example.mmm.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;



public class about extends Activity {

    ListView lView;
    final String LOG_TAG = "myLogs";

    AdapterHelper ah;
    SimpleAdapter adapter;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        lView = (ListView) findViewById(R.id.listView);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        // создаем адаптер
        ah = new AdapterHelper(this);
        adapter = ah.getAdapter();
        lView.setAdapter(adapter);

    }
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
