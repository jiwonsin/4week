package com.example.user.a32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.content.Context;

/**
 * Created by user on 2017-03-02.
 */

public class SecondActivity extends AppCompatActivity {
    private Intent gIntent;
    private String name,age;
    private Intent sIntent2;


    @Override
    public void onBackPressed(){
        sIntent2=new Intent(SecondActivity.this,MainActivity.class);
        sIntent2.putExtra("send","잘받았습니다.");
        setResult(RESULT_OK,sIntent2);
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button2=(Button)findViewById(R.id.btn2);
        gIntent=getIntent();
        name=gIntent.getStringExtra("name");
        age=gIntent.getStringExtra("age");
        Toast.makeText(SecondActivity.this,name+ "/"+age+"입니다.", Toast.LENGTH_LONG).show();
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear);
                View view2 = inflater.inflate(R.layout.image,null,false);
                linearLayout.addView(view2);
            }
        });
    }

}
