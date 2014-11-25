package com.example.mmm.myapplication;

import android.content.Context;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by palchuk on 25.11.2014.
 */
public class AdapterHelper{
    String[] animals = new String[]{"Котики", "Собачки"};
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
    int[] colors = new int[2];

    ArrayList<Map<String,String>> arAnimals;
    ArrayList<Map<String,String>> arChildItems;
    ArrayList<ArrayList<Map<String,String>>> arChildData;
    Map <String,String> m;

    Context ctx;
    AdapterHelper(Context _ctx) {
        ctx = _ctx;
    }
    SimpleExpandableListAdapter adapter;

    SimpleExpandableListAdapter getAdapter() {

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,catnames);
//        lView.setAdapter(adapter);
        // заполняем коллекцию групп из массива с названиями групп
        arAnimals = new ArrayList<Map<String, String>>();
        for (String group : animals) {
// заполняем список аттрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put("groupName", group);
            arAnimals.add(m);
        }
// список аттрибутов групп для чтения
        String groupFrom[] = new String[] {"groupName"};
// список ID view-элементов, в которые будет помещены аттрибуты групп
        int groupTo[] = new int[] {android.R.id.text1};
// создаем коллекцию для коллекций элементов
        arChildData = new ArrayList<ArrayList<Map<String, String>>>();
        // создаем коллекцию элементов для первой группы
        arChildItems = new ArrayList<Map<String, String>>();
// заполняем список аттрибутов для каждого элемента
        for (int i = 0; i < catnames.length; i++){
            m = new HashMap<String, String>();
            m.put("Name", catnames[i]);
            m.put("Subscr", subscr1[i]);
            arChildItems.add(m);
        }
// добавляем в коллекцию коллекций
        arChildData.add(arChildItems);
// создаем коллекцию элементов для второй группы
        arChildItems = new ArrayList<Map<String, String>>();
        for (int i = 0; i < dognames.length; i++){
            //for (String cat : catnames) {
            m = new HashMap<String, String>();
            m.put("Name", dognames[i]);
            m.put("Subscr", subscr2[i]);
            arChildItems.add(m);
        }
        arChildData.add(arChildItems);
        // список аттрибутов элементов для чтения
        String childFrom[] = new String[] {"Name","Subscr"};
// список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[] {R.id.tvItem, R.id.tvSmall};
        adapter = new SimpleExpandableListAdapter(
                ctx,
                arAnimals,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                arChildData,
                R.layout.item,
                childFrom,
                childTo
        );

    return adapter;
    }
    String getGroupText(int groupPos) {
        return ((Map<String,String>)(adapter.getGroup(groupPos))).get("groupName");
    }
    String getChildText(int groupPos, int childPos) {
        return ((Map<String,String>)(adapter.getChild(groupPos, childPos))).get("Name");
    }
    String getGroupChildText(int groupPos, int childPos) {
        return getGroupText(groupPos) + " " + getChildText(groupPos, childPos);
    }
}
