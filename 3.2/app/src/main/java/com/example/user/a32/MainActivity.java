package com.example.user.a32;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnEnroll;
    private EditText editName,editAge;
    private Intent sIntent;
    private static final int RequestCode=101;



    //private android.widget.Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnroll=(Button)findViewById(R.id.btn_enroll);
        editName = (EditText)findViewById(R.id.editName);
        editAge = (EditText)findViewById(R.id.editAge);


        btnEnroll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this, "complete", Toast.LENGTH_SHORT).show();
                sIntent=new Intent(MainActivity.this,SecondActivity.class);
                sIntent.putExtra("name",editName.getText().toString());
                sIntent.putExtra("age",editAge.getText().toString());
                startActivityForResult(sIntent,RequestCode);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        switch(requestCode){
            case RequestCode:
                if (requestCode == RESULT_OK) {
                    Toast.makeText(getApplicationContext(),data.getStringExtra("send"), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
