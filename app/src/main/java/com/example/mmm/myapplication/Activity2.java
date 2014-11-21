package com.example.mmm.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class Activity2 extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    public static final String LOG_TAG = "myLogs";
    public final static String RGroup;
    private static String RGroup_an;
    private Intent answerIntent = new Intent();
    private Button butOk;
    private  Button butCan;
    private  SeekBar sBar;
    private Switch switch1;
    TextView tv;
    Button button, butAdd, butGet, butDel, butClear;
    Button button2;
    EditText editText;
    DBHelper dbHelper;
    RadioGroup radiogr;

    private LinearLayout.LayoutParams lPar1;
    private LinearLayout.LayoutParams lPar2;
    private Animation anim;

//    final int MENU_ALPHA_ID = 1;
//    final int MENU_SCALE_ID = 2;
//    final int MENU_TRANSLATE_ID = 3;
//    final int MENU_ROTATE_ID = 4;
//    final int MENU_COMBO_ID = 5;
//
    static {
        RGroup = "com.example.mmm.myapplication.ch";
        RGroup_an = "";
    }
    public void onRadioClick(View view) {
        anim = null;
        switch (view.getId()) {
            case R.id.rb1:
                RGroup_an = "Радио кнопка №1";
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case R.id.rb2:
                RGroup_an = "Радио кнопка №2";
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case R.id.rb3:
                RGroup_an = "Радио кнопка №3";
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case R.id.rb4:
                RGroup_an = "Радио кнопка №4";
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case R.id.rb5:
                RGroup_an = "Радио кнопка №5";
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
            default:
                break;
        }
        button.setAnimation(anim);
        button.requestLayout();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        butOk = (Button) findViewById(R.id.button_ok);
        butCan = (Button) findViewById(R.id.button_concel);
        lPar1 = (LinearLayout.LayoutParams) butOk.getLayoutParams();
        lPar2 = (LinearLayout.LayoutParams) butCan.getLayoutParams();
        sBar = (SeekBar)findViewById(R.id.seekBar);
        sBar.setOnSeekBarChangeListener(this);
        switch1 = (Switch)findViewById(R.id.switch1);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        butAdd = (Button)findViewById(R.id.butAdd);
        butGet = (Button)findViewById(R.id.butGet);
        butDel = (Button)findViewById(R.id.butDel);
        butClear = (Button)findViewById(R.id.butClear);
        editText = (EditText)findViewById(R.id.editText);
        radiogr = (RadioGroup)findViewById(R.id.radiogr);
        tv = (TextView)findViewById(R.id.textA2);

        dbHelper = new DBHelper(this);

        String user = "Ктото";
        String gift = "Чтото";
        user = getIntent().getExtras().getString("user");
        gift = getIntent().getExtras().getString("gift");
        tv.setText(user +", вам передали "+ gift);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity2, menu);
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

    public void onOKClick(View view) {
        answerIntent.putExtra(RGroup,RGroup_an);
        setResult(RESULT_OK, answerIntent);
        finish();

    }

    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED, answerIntent);
        finish();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int lVal = i;
        int rVal = sBar.getMax() - i;
        lPar2.weight = lVal;
        lPar1.weight = rVal;
        //butCan.requestLayout();
        butOk.requestLayout();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void OnToggleClick(View view) {
        button.setAnimation(anim);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        String textA2 =  tv.getText().toString();
        Integer radiogroup = radiogr.getCheckedRadioButtonId();
        Integer swit = (switch1.isChecked())?1:0;
        Integer progress = sBar.getProgress();
        ContentValues cv = new ContentValues();
        String id = editText.getText().toString();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (view.getId()) {
            case R.id.button:
                intent = new Intent("com.example.mmm.myapplication.intent.action.ShowTime");
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent("com.example.mmm.myapplication.intent.action.ShowDate");
                startActivity(intent);
                break;
            case R.id.button_ok:
                answerIntent.putExtra(RGroup, RGroup_an);
                setResult(RESULT_OK, answerIntent);
                finish();
                break;
            case R.id.button_concel:
                setResult(RESULT_CANCELED, answerIntent);
                finish();
                break;
            case R.id.butAdd:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                cv.put("textA2",textA2);
                cv.put("radiog",radiogroup);
                cv.put("switch",swit);
                cv.put("progress",progress);
                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);

                break;
            case R.id.butGet:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
// делаем запрос всех данных из таблицы mytable, получаем Cursor
                Cursor c = db.query("mytable", null, null, null, null, null, null);
// ставим позицию курсора на первую строку выборки
// если в выборке нет строк, вернется false
                if (c.moveToFirst()) {
// определяем номера столбцов по имени в выборке
                    int idColIndex = c.getColumnIndex("id");
                    int textA2ColIndex = c.getColumnIndex("textA2");
                    int radiogColIndex = c.getColumnIndex("radiog");
                    int switchColIndex = c.getColumnIndex("switch");
                    int progressColIndex = c.getColumnIndex("progress");

                    do {
// получаем значения по номерам столбцов и пишем все в лог
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", textA2 = " + c.getString(textA2ColIndex) +
                                        ", switch = " + c.getString(switchColIndex) +
                                        ", progress = " + c.getString(progressColIndex) +
                                        ", radiog = " + ((RadioButton)findViewById(c.getInt(radiogColIndex))).getText().toString()
                        );
// переход на следующую строку
// а если следующей нет (текущая - последняя), то false - выходим из цикла
                    } while (c.moveToNext());
                } else
                    Log.d(LOG_TAG, "0 rows");

                break;

            case R.id.butClear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
// удаляем все записи
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;

            case R.id.butDel:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Delete from mytabe: ---");
// удаляем по id
                int delCount = db.delete("mytable", "id = " + id, null);
                Log.d(LOG_TAG, "deleted rows count = " + delCount);
                break;

            default:
                break;
        }
        dbHelper.close();
    }
}
