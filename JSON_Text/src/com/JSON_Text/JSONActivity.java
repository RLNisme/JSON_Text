package com.JSON_Text;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONObject;

/**
 * Created by RLN on 3/27/2015.
 */
public class JSONActivity extends Activity implements View.OnClickListener{

    JSONActivity ja = null;
    TextView result;
    EditText un,pw;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_main);

        ja = this;

        un = (EditText)findViewById(R.id.un);
        pw = (EditText)findViewById(R.id.pw);
        result = (TextView)findViewById(R.id.result);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login){
            JSONAsyncTask jat = new JSONAsyncTask(ja);
            jat.execute();
        }
    }

    public void getJsonData(String... s){
        Log.d("--MSG--",s[0]);
        String st = "";
        try {
            JSONObject jo = new JSONObject(s[0]);
            String fn = jo.getString("fname");
            String ln = jo.getString("lname");
            st = "Hi "+fn +" - "+ln;
            Log.d("--MSG--", st);
            result.setText(st);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
