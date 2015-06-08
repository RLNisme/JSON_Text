package com.JSON_Text;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RLN on 3/27/2015.
 */
public class JSONAsyncTask extends AsyncTask {

    JSONActivity ja = null;

    JSONAsyncTask(JSONActivity ja){
        this.ja = ja;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("--MSG--","Inside the onPreExecute()");
    }

    @Override
    protected Object doInBackground(Object[] params) {
        String urll="http://10.0.3.2:8084/AndroidWebServer1_Day04_/AndroidJSONMethod";
        String s="";

        try {
            HttpClient hc = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(urll);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("un",ja.un.getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("pw", ja.pw.getText().toString()));

            postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = hc.execute(postRequest);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
            String thisLine = "";
            while ((thisLine = br.readLine())!=null){
                s += thisLine;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("--MSG--","inside the doInBackGround()");
        Log.d("--Response--",s);
        return s;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.d("--Return--", o + "");
        ja.getJsonData(o+ "");
    }
}
