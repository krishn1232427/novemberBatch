package samples.android.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
public static final String TAG = "MyService";
    @Override
    public void onCreate() {
        Toast.makeText(MyService.this, "my service running", Toast.LENGTH_SHORT).show();
        //On create is called when service is created for the first time
        Log.i(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //On Start Command is called each time we call startServices in application when service is already running
        Log.i(TAG,"onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
               //network code ... or long running operation.
            }
        });
        //stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        // called only once before service is killed.
        super.onDestroy();
    }





    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
