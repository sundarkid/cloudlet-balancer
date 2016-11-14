package com.trydevs.cloudletbalancer.services;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TimeUtils;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.trydevs.cloudletbalancer.extras.MobileStatistics;

import java.util.concurrent.TimeUnit;

/**
 * Created by kid on 11/11/16.
 */

public class HeartBeatJob extends Job {

    public static final String TAG = "heartBeatJobTag";

    @NonNull
    @Override
    protected Result onRunJob(Params params) {

        for (int i = 0; i > -1; i++) {
            try {
                Thread.sleep(100);
                Log.d(TAG, "value of i = " + i);
                MobileStatistics mobileStatistics = new MobileStatistics();
                Log.d(TAG, mobileStatistics.getCpuUsageStatistic());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        new JobRequest.Builder(TAG)
                .setExecutionWindow(3_000L, 4_000L)
                .build()
                .schedule();
    }
}
