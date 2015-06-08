package com.JSON_Text;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
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
public class RequestType extends AsyncTask{

    SecondActivity sa;

    RequestType(SecondActivity sa){
        this.sa = sa;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        //String url = "http://10.0.3.2:8084/AndroidWebServer1_Day04_/AndroidGETMethod"; //Get request
        //String result = getRequest(url);

        String url = "http://10.0.3.2:8084/AndroidWebServer1_Day04_/AndroidPOSTMethod"; //Post request
        String result = postRequest(url);
        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("OPreE","OnPreExecute");
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.d("----Result----", o + "");
        Log.d("----Calling----", "set request Method");
        sa.setGetResult(o + "");
    }

    public String getRequest(String url){
        Log.d("--Msg--","GetRequest()");
        String s = "";
        int id;
        try {
            HttpClient hc = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(url);
            HttpResponse httpResponse = hc.execute(getRequest);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
            id = httpResponse.getStatusLine().getStatusCode();
            String thisLine = "";
            while ((thisLine = reader.readLine()) != null){
                s += thisLine;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return s;
    }

    public String postRequest(String url){
        Log.d("--Msg--","PostRequest()");
        String s = "";
        try {
            HttpClient hc =new DefaultHttpClient();
            HttpPost postReqest = new HttpPost(url);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(); //Creating Name and Value pair
            nameValuePairs.add(new BasicNameValuePair("UUID", "9")); //adding pair to list
            postReqest.setEntity(new UrlEncodedFormEntity(nameValuePairs)); //setting a entity
            HttpResponse httpResponse = hc.execute(postReqest);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
            String thisLine = "";
            while ((thisLine=reader.readLine())!=null){
                System.out.println(thisLine);
                s += thisLine;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
