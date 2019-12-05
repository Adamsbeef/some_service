package com.example.some_service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

public class Jobservice extends JobService {

    public static final String INPUT_DATA = "stringKey";

    public Jobservice() {

    }
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        AsyncTask<JobParameters,Void, Void> task = new AsyncTask<JobParameters, Void, Void>() {
            @Override
            protected Void doInBackground(JobParameters... jobParameters) {
                JobParameters jobParams = jobParameters[0];
                String inputText = jobParams.getExtras().getString(INPUT_DATA);
                Database_backup.temporaryThreadWork(inputText);
                jobFinished(jobParams,false);
                return null;
            }
        };

        task.execute(jobParameters);

        //tell the process that a background work has started and that it needs to let it run.
        return true;
    }
    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        /**
         * Modify this part to tell android what to do when your job stop perhaps you want to re schedule the task
         * if you do reschedule the taask set the return value to true**/
        return false;
    }

}
