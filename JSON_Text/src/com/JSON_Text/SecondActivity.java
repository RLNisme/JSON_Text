package com.JSON_Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by RLN on 3/27/2015.
 */
public class SecondActivity extends Activity implements View.OnClickListener{

    SecondActivity sa=null;
    Button get,post,json;
    TextView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        sa = this;

        get =(Button)findViewById(R.id.get);
        post =(Button)findViewById(R.id.post);
        json = (Button)findViewById(R.id.json);

        show = (TextView)findViewById(R.id.show);

        get.setOnClickListener(this);
        post.setOnClickListener(this);
        json.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

        RequestType rt = new RequestType(sa);

        if(v.getId() == R.id.get){

            rt.execute();

        }else if(v.getId() == R.id.post){

            rt.execute();

        }else if(v.getId() == R.id.json){

            Intent i = new Intent(this,JSONActivity.class);
            startActivity(i);

        }
    }

    public void setGetResult(String... s){

        show.setText(s[0] + "");

    }


}
