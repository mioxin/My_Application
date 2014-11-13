package com.example.mmm.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class Activity2 extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    public final static String RGroup;
    private static String RGroup_an;
    private Intent answerIntent = new Intent();
    private Button butOk;
    private  Button butCan;
    private  SeekBar sBar;
    private ToggleButton toggleButton;
    TextView tv;
    Button button;
    Button button2;

    private LinearLayout.LayoutParams lPar1;
    private LinearLayout.LayoutParams lPar2;
    private Animation anim;

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANSLATE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

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
        //toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        tv = (TextView)findViewById(R.id.textA2);
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
        }
    }
}
