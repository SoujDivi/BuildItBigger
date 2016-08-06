package com.example.souji.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by souji on 27/7/16.
 */
public class DisplayJoke extends AppCompatActivity {


    public static final String EXTRA_JOKE = "EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_jokes);


            TextView jokeView =( TextView) findViewById(R.id.tv_joke);
            jokeView.setText("JOKE:\n"+getIntent().getStringExtra(Intent.EXTRA_TEXT));


    }

  }
