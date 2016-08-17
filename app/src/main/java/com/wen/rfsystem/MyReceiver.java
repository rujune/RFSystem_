package com.wen.rfsystem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

/**
 * Created by Student on 2016/8/16.
 */
public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("B", "收到廣播");

    }



}