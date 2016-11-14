package com.trydevs.cloudletbalancer.services;

import android.util.Log;
import android.util.StringBuilderPrinter;

import com.evernote.android.job.Job;

/**
 * Created by kid on 11/11/16.
 */

public class JobCreator implements com.evernote.android.job.JobCreator {
    private static String TAG = "JobCreator";
    @Override
    public Job create(String tag) {
        switch (tag) {
            case HeartBeatJob.TAG:
                return new HeartBeatJob();
            default:
                Log.d(TAG, "default case is run");
                return new HeartBeatJob();
        }
    }
}
