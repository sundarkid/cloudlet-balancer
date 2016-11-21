package com.trydevs.cloudletbalancer.services;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TimeUtils;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.trydevs.cloudletbalancer.data.ResultData;
import com.trydevs.cloudletbalancer.extras.MobileStatistics;
import com.trydevs.cloudletbalancer.network.ApiClient;
import com.trydevs.cloudletbalancer.network.ApiInterface;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                Thread.sleep(TimeUnit.SECONDS.toMillis(30));
                Log.d(TAG, "value of i = " + i);
                MobileStatistics mobileStatistics = new MobileStatistics();
                Log.d(TAG, mobileStatistics.getCpuUsageStatistic());
                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

                Call<ResultData> resultDataCall = apiInterface.uploadSystemInfo("80%", "-103db", "120", "", "", "", "28812", "", "", "");

                resultDataCall.enqueue(new Callback<ResultData>() {
                    @Override
                    public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                        Log.d("response", response.raw().toString());
                        Log.d("response", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<ResultData> call, Throwable t) {
                        Log.d("error", t.toString());
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Result.SUCCESS;
    }

    public static void scheduleJob() {

        new JobRequest.Builder(TAG)
                .setRequiredNetworkType(JobRequest.NetworkType.UNMETERED)
                .setExecutionWindow(3_000L, 4_000L)
                .build()
                .schedule();
    }
}
