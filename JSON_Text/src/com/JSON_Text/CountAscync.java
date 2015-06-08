package com.JSON_Text;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by RLN on 3/27/2015.
 */
public class CountAscync extends AsyncTask {

    MyActivity ma;

    CountAscync(MyActivity ma){
        this.ma=ma;
    }


    @Override
    protected String doInBackground(Object[] params) {
        Log.d("--Msg--", "Inside the doInBackground Method");
        for (int j = 0;j < 10;j++){
            try {
                Thread.sleep(1000);
                publishProgress((j + 1) * 10);
                Thread.sleep(1000);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("--msgPre--", "Executing on pre");
        ma.i = 1;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        ma.setCountDown(values[0]+"");
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        ma.setCountDown("Click CD to start count down");
        ma.i = 0;
    }
}
