package com.trydevs.cloudletbalancer.extras;

import android.app.Application;
import android.content.Context;

import com.evernote.android.job.JobManager;
import com.trydevs.cloudletbalancer.services.HeartBeatJob;
import com.trydevs.cloudletbalancer.services.JobCreator;

/**
 * Created by kid on 11/11/16.
 */

public class MyApplication extends Application {

    private static MyApplication myInstance;
    private static JobManager jobManager;

    public static Application getInstance(){
        return myInstance;
    }

    public static Context getContext(){
        return myInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        jobManager = JobManager.create(this);
        addJobCreator();
        HeartBeatJob.scheduleJob();
    }

    public synchronized static JobManager getJobManager(){
        return jobManager;
    }


    public synchronized static void addJobCreator(){
        getJobManager().addJobCreator(new JobCreator());
    }

}
