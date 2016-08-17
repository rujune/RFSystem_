package com.wen.rfsystem;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class MyService extends Service {
    boolean isOpen = false;
    public MyService() {
    }
    private Handler handler = new Handler();
    private Runnable showTime = new Runnable() {
        public void run() {
// 顯示目前時間
            Log.i("MYB mylog", new Date().toString());
            handler.postDelayed(this, 1000);
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MYB mylog", "onStartCommand()");
        if (isOpen == false)
        {
            handler.post(showTime);
            isOpen = true;
        }

        return Service.START_STICKY;
    }
    @Override
    public void onDestroy() {
        Log.i("MYB mylog", "onDestroy()");
        handler.removeCallbacks(showTime);
        super.onDestroy();
    }
}
