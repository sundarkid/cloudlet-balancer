package com.trydevs.cloudletbalancer.network;

import android.net.Uri;
import android.util.Log;

import com.trydevs.cloudletbalancer.data.ResultData;
import com.trydevs.cloudletbalancer.extras.FileUtils;
import com.trydevs.cloudletbalancer.extras.MyApplication;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kid on 18/11/16.
 */

public class customRequests {

    // Getting api for service
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    String responseData = "";

    // Function to upload mobile statistics to server
    public String uploadMobileStatistics(){

        Call<ResultData> resultDataCall = apiInterface.uploadSystemInfo("80%", "-103db", "120", "", "", "", "28812", "", "", "");

        resultDataCall.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                Log.d("response", response.raw().toString());
                Log.d("response", response.body().toString());
                responseData = response.body().toString();
            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });

        // wait till response data is obtained
        while (responseData.equalsIgnoreCase(""));

        return responseData;
    }


    // function to upload image to server
    public String uploadImageFile(Uri imageUri){

        File file = FileUtils.getFile(MyApplication.getContext(), imageUri);


        while (file.getAbsolutePath().equalsIgnoreCase(""));
        return responseData;
    }

}
