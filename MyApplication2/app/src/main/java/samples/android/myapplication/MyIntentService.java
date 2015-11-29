package samples.android.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //code directly runs on background thread.
        Log.i("IntentService","onHandleIntent" );
        for (int i = 0; i <30; i ++){
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i("IntentService","onHandleIntent completed" );
    }

}
