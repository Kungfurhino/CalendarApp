package com.example.calendarapp;

import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reminder {

    private int month;
    private int day;
    private String message;
    private int time;
    private int militaryTime;
    private Boolean am; //true=am false=pm

    public reminder(int m, int d, String message, int tim, boolean ampm){
        month = m;
        day = d;
        this.message = message;
        time = tim;
        am = ampm;
        if(!am){
            militaryTime = time + 12;
        }else{
            militaryTime = time;
        }
    }

    public int getDay(){
        return day;
    }

    public int getTime(){
        return time;
    }

    public int getMilitaryTime(){
        return militaryTime;
    }
}

//class for treemap sorting, sorts by whichever time is closer to the current time *disregards events that have already passed"
class sortReminders implements Comparator<reminder> {

    public int compare(reminder a, reminder b){
        //Gets the current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String currentDate = formatter.format(date);
        int currentDay = Integer.parseInt(currentDate.substring(0, 1));
        int currentHour = Integer.parseInt(currentDate.substring(11, 12));
        if(currentDay - a.getDay() < currentDay - b.getDay()){
            return 1;
        }else if(currentDay - a.getDay() > currentDay - b.getDay()){
            return -1;
        }else if(currentHour - a.getMilitaryTime() < currentHour - b.getMilitaryTime()){
            return 1;
        }else{
            return -1;
        }
    }
}
