package com.trydevs.cloudletbalancer.network;

import com.trydevs.cloudletbalancer.data.SystemInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kid on 14/11/16.
 */

public interface ApiInterface {

    @GET("mobileLog")
    Call<SystemInfo> uploadSystemInfo(@Query("batteryPercentage") String batteryPercentage,
                                      @Query("signalStrength")String signalStrength,
                                      @Query("latency") String latency,
                                      @Query("averageCpuUsage") String averageCpuUsage,
                                      @Query("averageCpuFrequency") String averageCpuFrequency,
                                      @Query("memoryUsage") String memoryUsage,
                                      @Query("mobileId") String mobileId,
                                      @Query("energy") String energy,
                                      @Query("bandWidth") String bandWidth,
                                      @Query("connectionState") String connectionState);

}
