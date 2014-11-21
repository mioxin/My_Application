package com.example.mmm.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class about extends Activity {
    String[] catnames = new String[] { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
            "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };
    String[] subscr = new String[] {"Самый интересный ","из трех инструментов, ","пожалуй",
            "SAS Enterprise Miner, ","позволяющий строить применимые в ","бизнесе прогнозные модели, ",
            "с  помощью ","построения диаграмм для анализа и многое другое.",
            "Честно, это очень интересно и круто, ","но понятно, не многим.  ","Например, ",
            "студенты научатся: решать задачи поиска шаблонов ","(сегментация, ассоциация и анализ  последовательности)",
            " и прогнозного моделирования (деревья решений, линейная регрессия, логистическая  регрессия, ",
            "нейронные сети, ансамбль моделей, ассоциативные правила и другие  модели)"
    };
    int[] colors = new int[2];

    //private ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,catnames);
//    AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        ListView lView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,catnames);
        lView.setAdapter(adapter);

        //setListAdapter(adapter);
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

//        LinearLayout lLayout = (LinearLayout) findViewById(R.id.lLayout);
//        LayoutInflater ltInflater = getLayoutInflater();
//        for (int i = 0; i < catnames.length; i++) {
//            Log.d("myLogs", "i = " + i);
//            View item = ltInflater.inflate(R.layout.item, lLayout, false);
//            TextView tvItem = (TextView) item.findViewById(R.id.tvItem);
//            tvItem.setText(catnames[i]);
//            TextView tvSmall = (TextView) item.findViewById(R.id.tvSmall);
//            tvSmall.setText("Описание: " + subscr[i]);
//            ImageView iView = (ImageView) item.findViewById(R.id.iView);
//            iView.setImageResource(R.drawable.kitty);
//
//            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
//            item.setBackgroundColor(colors[i % 2]);
//            lLayout.addView(item);
//        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.about, menu);
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
