package com.wen.rfsystem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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

        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){

           // alarm.setAlarm(context);
        }
        /*當Alarm開啟後，開啟Receiver :
        ComponentName receiver = new ComponentName(context, MyReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
//關閉:
        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);*/




    }



}