package com.example.lesson27getintentaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Info extends AppCompatActivity {

    String format = "", textInfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // получаем Intent, который вызывал это Activity
        Intent intent = getIntent();
        // читаем из него action
        String action = intent.getAction();

        // в зависимости от action заполняем переменные
        switch (Objects.requireNonNull(action)) {
            case "com.example.intent.action.showtime":
                format = "HH:mm:ss";
                textInfo = "Time: ";
                break;
            case "com.example.intent.action.showdate":
                format = "dd.MM.yyyy";
                textInfo = "Date: ";
                break;
        }

        // в зависимости от содержимого переменной format
        // получаем дату или время в переменную datetime
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateTime = sdf.format(new Date(System.currentTimeMillis()));
        TextView tvInfo = findViewById(R.id.tvInfo);
        tvInfo.setText(String.format("%s%s", textInfo, dateTime));
    }
}
