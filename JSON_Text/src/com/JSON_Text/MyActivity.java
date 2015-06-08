package com.JSON_Text;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity implements View.OnClickListener{

    MyActivity ma=null;
    EditText gen;
    Button cd;
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ma = this;

        gen = (EditText)findViewById(R.id.gen);
        cd = (Button)findViewById(R.id.count);

        cd.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.main_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ActionBar ab = getActionBar();

        switch (item.getItemId()){
            case R.id.next_activity:
                Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.count){
            CountAscync cas = new CountAscync(ma);
            if(i == 0){
                cas.execute();
            }else{
                Toast.makeText(getApplicationContext(),"Waite...",Toast.LENGTH_LONG).show();
            }
            Log.d("--Msg--","Inside onClick method");
        }
    }

    public void setCountDown(String... s){

        gen.setText(s[0]);
    }


}
