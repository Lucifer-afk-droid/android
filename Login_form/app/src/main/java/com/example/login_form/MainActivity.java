package com.example.login_form;

import static java.lang.System.out;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                EditText user = (EditText) findViewById(R.id.inuser);
                String inuser= user.getText().toString();
                EditText pass= (EditText) findViewById(R.id.inpass);
                String in_pass=pass.getText().toString();
                if(!inuser.isEmpty() && !in_pass.isEmpty()){
                    Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                    MainActivity.this.startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"Input Required",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}