package com.example.some_service;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ApplicationErrorReport;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final int JOB_ID = 1;
    Intent intent;
    private String txtVwText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.textView);
        editText.requestFocus();
        findViewById(R.id.doBackgroundWork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),CoolIntentService.class);
                collectText(editText);
                intent.putExtra(CoolIntentService.backupString, txtVwText);
                startService(intent);
            }
        });

        findViewById(R.id.scheduleJob).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                collectText(editText);
                scheduleJob();
            }
        });
    }

    private void collectText(EditText editText) {
        txtVwText = editText.getText().toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void scheduleJob() {
        PersistableBundle extras = new PersistableBundle();
        extras.putString(Jobservice.INPUT_DATA,txtVwText);
        ComponentName componentName = new ComponentName(this, Jobservice.class);


        JobInfo jobInfo = new JobInfo.Builder(JOB_ID,componentName).setRequiresBatteryNotLow(true)
                .setExtras(extras)
                .build();
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfo);
    }


}
