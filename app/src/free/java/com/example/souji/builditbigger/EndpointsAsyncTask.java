package com.example.souji.builditbigger;

/**
 * Created by souji on 3/8/16.
 */

import android.content.Context;
import android.os.AsyncTask;

import com.example.souji.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * From google Source
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private TaskListner mlistner = null;


    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1268.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];


        try {
            return myApiService.sayHi("Soujanya").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (null != mlistner)
            this.mlistner.getTaskResult(result);

    }


    public interface TaskListner {
        void getTaskResult(String result);
    }

    public EndpointsAsyncTask setListner(TaskListner listner) {
        this.mlistner = listner;
        return this;
    }


}

