package com.example.germanriveros.android_tv2ba0a100;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by germanriveros on 14-05-16.
 */
public class LayoutActivity extends AppCompatActivity
{

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login   = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(et_username.getText().toString().equals("admin") &&
                        et_password.getText().toString().equals("admin"))

                    finish();
                else
                    Log.d("Login","Wrong username or pass");

            }
        });

    }//..
}
