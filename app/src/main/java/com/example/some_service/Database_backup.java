package com.example.some_service;

import android.util.Log;

public class Database_backup {
    final static String TAG = "DatabaseClass";


    public static void temporaryThreadWork(String backupText){
//        backupText.trim();
        Log.d(TAG, "Starting  the service ....... ");
        Log.d(TAG, "Continuing the service ....... " + backupText);
        for (int i = 0; i < backupText.length(); i++) {

            System.out.println((double) backupText.length() /100);
            System.out.println(30/4);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            }

            //TODO : get the fucking percentage to work..
            Log.d(TAG, (((double) backupText.length())/100 * (i * 0.44))   +  " Completed");
            Log.d(TAG, ">>>>>>>>>>>>>>>> " + backupText.charAt(i));
        }
        Log.d(TAG, "Finished  the service ....... ");
    }

    /**
     * TODO: Save data to firebase database in this class also use a service to stor the downloaded data to an
    *sqlite database
     * */
}
