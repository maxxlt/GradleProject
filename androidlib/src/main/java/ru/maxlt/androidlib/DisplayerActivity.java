package ru.maxlt.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayerActivity extends AppCompatActivity {
    TextView textView;
    Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayer);
        textView = findViewById(R.id.display_text_tv);
        mIntent = getIntent();
        Log.v("androidlib: ","mIntent is: " + mIntent.getStringExtra("extraString"));
        if (mIntent != null){
            textView.setText(mIntent.getStringExtra("extraString"));
        }
    }
}
