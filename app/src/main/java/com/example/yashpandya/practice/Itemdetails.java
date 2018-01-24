package com.example.yashpandya.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.yashpandya.practice.MainActivity.GET_BIO;


public class Itemdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetails);
        Intent intent=getIntent();
        String bio=intent.getStringExtra(GET_BIO);

        TextView details= (TextView) findViewById(R.id.tdetails);
        details.setText(bio);
    }
}
