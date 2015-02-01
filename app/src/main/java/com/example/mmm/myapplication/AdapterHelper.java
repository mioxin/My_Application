package com.example.mmm.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by palchuk on 25.11.2014.
 */
public class AdapterHelper{
    //String[] animals = new String[]{"Котики", "Собачки"};
    String[] catnames = new String[] { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Бобик"};
    String[] dognames = new String[]{"Кристина", "Пушок",
            "Дымка", "Кузя", "Китти",
            "Барбос", "Масяня", "Симба" };
    String[] subscr1 = new String[] {"Самый интересный ","из трех инструментов, ","пожалуй",
            "SAS Enterprise Miner, ","позволяющий строить применимые в ","бизнесе прогнозные модели, ",
            "с  помощью "};
    String[] subscr2 = new String[] {"построения диаграмм для анализа и многое другое.",
            "Честно, это очень интересно и круто, ","но понятно, не многим.  ","Например, ",
            "студенты научатся: решать задачи поиска шаблонов ","(сегментация, ассоциация и анализ  последовательности)",
            " и прогнозного моделирования (деревья решений, линейная регрессия, логистическая  регрессия, ",
            "нейронные сети, ансамбль моделей, ассоциативные правила и другие  модели)"
    };
    int img = R.drawable.kitty;
    // картинки для отображения динамики
    final int positive = android.R.drawable.arrow_up_float;
    final int negative = android.R.drawable.arrow_down_float;

    //ArrayList<Map<String,String>> arAnimals;
    ArrayList<Map<String,Object>> arItems;
    //ArrayList<ArrayList<Map<String,String>>> arChildData;
    Map <String,Object> m;

    class MySimpleAdapter extends SimpleAdapter {
        public MySimpleAdapter(Context context,
                               List<? extends Map<String, ?>> data, int resource,
                               String[] from, int[] to) {
            super(context, data, resource, from, to);
        }
        @Override
        public void setViewText(TextView v, String text) {
// метод супер-класса, который вставляет текст
            super.setViewText(v, text);
// если нужный нам TextView, то разрисовываем
            if (text.toCharArray()[0] == 'К') v.setTextColor(Color.RED); else
                v.setTextColor(Color.GREEN);
        }
        @Override
        public void setViewImage(ImageView v, int value) {
// метод супер-класса
            super.setViewImage(v, value);
// разрисовываем ImageView
            if (value == negative) v.setBackgroundColor(Color.RED); else
            if (value == positive) v.setBackgroundColor(Color.GREEN);
        }
    }

    Context ctx;
    AdapterHelper(Context _ctx) {
        ctx = _ctx;
    }
    MySimpleAdapter adapter;

    MySimpleAdapter getAdapter() {

        arItems = new ArrayList<Map<String, Object>>();
// заполняем список аттрибутов для каждого элемента
        for (int i = 0; i < catnames.length; i++){
            m = new HashMap<String, Object>();
            m.put("Name", catnames[i]);
            m.put("Subscr", subscr1[i]);
            img = (catnames[i].toCharArray()[0] == 'К') ? negative:positive;
            m.put("Img",img);
            arItems.add(m);
        }
        for (int i = 0; i < dognames.length; i++){
            m = new HashMap<String, Object>();
            m.put("Name", dognames[i]);
            m.put("Subscr", subscr2[i]);
            img = (dognames[i].toCharArray()[0] == 'К') ? negative:positive;
            m.put("Img",img);
            arItems.add(m);
        }

        //arChildData.add(arChildItems);
        // список аттрибутов элементов для чтения
        String childFrom[] = new String[] {"Name","Subscr","Img"};
// список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[] {R.id.tvItem, R.id.tvSmall, R.id.imageView};
        adapter = new MySimpleAdapter(
                ctx,
                arItems,
                R.layout.item,
                childFrom,
                childTo
        );

    return adapter;
    }

//    String getChildText(int groupPos, int childPos) {
//        return ((Map<String,String>)(adapter.getChild(groupPos, childPos))).get("Name");
//    }

}
