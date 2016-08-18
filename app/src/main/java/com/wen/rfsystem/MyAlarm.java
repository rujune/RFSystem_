package com.wen.rfsystem;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by Student on 2016/8/18.
 */
//使用WakefulBroadcastReceiver
public class MyAlarm extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This is the Intent to deliver to our service.
        Intent service = new Intent(context, MyAlarm.class);

        // Start the service, keeping the device awake while it is launching.
        Log.i("MyAlarm", "Starting service @ " + SystemClock.elapsedRealtime());
        startWakefulService(context, service);
    }
}
public class MyAlarm extends IntentService {

    public MyAlarm() {
        super("MyAlarm");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // At this point SimpleWakefulReceiver is still holding a wake lock
        // for us.  We can do whatever we need to here and then tell it that
        // it can release the wakelock.  This sample just does some slow work,
        // but more complicated implementations could take their own wake
        // lock here before releasing the receiver's.
        //
        // Note that when using this approach you should be aware that if your
        // service gets killed and restarted while in the middle of such work
        // (so the Intent gets re-delivered to perform the work again), it will
        // at that point no longer be holding a wake lock since we are depending
        // on SimpleWakefulReceiver to that for us.  If this is a concern, you can
        // acquire a separate wake lock here.
        for (int i=0; i<5; i++) {
            Log.i("SimpleWakefulReceiver", "Running service " + (i+1)
                    + "/5 @ " + SystemClock.elapsedRealtime());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
        Log.i("SimpleWakefulReceiver", "Completed service @ " + SystemClock.elapsedRealtime());
        MyAlarm.completeWakefulIntent(intent);
    }

}



