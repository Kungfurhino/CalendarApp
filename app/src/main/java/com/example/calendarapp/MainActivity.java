package com.example.calendarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    public HashMap<Integer, Map<Integer, reminder>> RemindersMonth;
    EditText reminderTextBox;
    TextView reminderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reminderTextBox = (EditText) findViewById(R.id.reminderTextBox);
        reminderList = (TextView) findViewById(R.id.ReminderList);
        //TODO - add method that updates reminders on start(gets rid of ones that have already passed)
    }

    public void switchToCalanderPage(View view) {
        setContentView(R.layout.activity_calendar_page);
    }

    public void updateReminders(View view){
        reminderList.setText(reminderTextBox.getText());
    }
}