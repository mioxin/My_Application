package com.example.mmm.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;

import static android.view.View.OnClickListener;


public class MyActivity extends Activity {
    private RelativeLayout mLayout;
    Button mbutRed;
    Button mbutYellow;
    Button mbutGreen;
    static final private int CHOOSE = 0;

//    butRed

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mLayout = (RelativeLayout)findViewById(R.id.myLayout);
        mbutRed = (Button)findViewById(R.id.ButtonRed);
        mbutYellow = (Button)findViewById(R.id.ButtonYellow);
        mbutGreen = (Button)findViewById(R.id.ButtonGreen);
        OnClickListener myClick = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.ButtonRed:
                        mLayout.setBackgroundColor(Color.RED);
                        break;
                    case R.id.ButtonYellow:
                        EditText edUser = (EditText) findViewById(R.id.editText);
                        EditText edGift = (EditText) findViewById(R.id.editText3);
                        Intent intent1 = new Intent(MyActivity.this,Activity2.class);
                        intent1.putExtra("user", edUser.getText().toString());
                        intent1.putExtra("gift", edGift.getText().toString());
                        startActivityForResult(intent1,CHOOSE);
                        break;
                    case R.id.ButtonGreen:
                        Intent intent= new Intent(MyActivity.this, about.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        mbutRed.setOnClickListener(myClick);
        mbutYellow.setOnClickListener(myClick);
        mbutGreen.setOnClickListener(myClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tv = (TextView) findViewById(R.id.textViewA2);
        if (requestCode == CHOOSE) {
            if (resultCode == RESULT_OK) {
                String rb_choose = data.getStringExtra(Activity2.RGroup);
                tv.setText(tv.getText() + rb_choose + "\n");
            } else {
                tv.setText(tv.getText() + ""); // стираем текст
            }
        }
    }
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.ButtonRed:
//                mLayout.setBackgroundColor(Color.RED);
//                break;
//            case R.id.ButtonYellow:
//                mLayout.setBackgroundColor(Color.YELLOW);
//                break;
//            case R.id.ButtonGreen:
//                mLayout.setBackgroundColor(Color.GREEN);
//                break;
//        }
//    }
}
