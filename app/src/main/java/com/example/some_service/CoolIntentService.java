package com.example.some_service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CoolIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS

    public static final String backupString = "com.example.some_service.extra.backupString";

    private  final String TAG = getClass().getSimpleName();
    public CoolIntentService() {
        super("CoolIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String stringToBeBackedUp = intent.getStringExtra(backupString);
            Log.d("onHandleIntent", "onHandleIntent: >>>>>>>>>>>>>" + stringToBeBackedUp);
            assert stringToBeBackedUp != null;
            Database_backup.temporaryThreadWork(stringToBeBackedUp);
            Toast.makeText(this, "Background Work Completed", Toast.LENGTH_SHORT).show();
        }
    }
}
