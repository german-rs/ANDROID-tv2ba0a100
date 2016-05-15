package com.example.germanriveros.appsample;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;



import java.io.File;

/**
 * Created by germanriveros on 15-05-16.
 */
public class NoteActivity extends Activity
{

    private LinearLayout linearLayout;
    private Button notesButton;


    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_notas);

        linearLayout = (LinearLayout) findViewById(R.id.layoutNotes);
        notesButton = (Button) findViewById(R.id.buttonCreate);

        notesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent i = new Intent(getApplicationContext(), SaveNoteActivity.class);
                startActivity(i);

            }
        });

    }//..

    private void readAndDisplayNotes()
    {

        File dirFile = getFilesDir();


        for(String strFile : dirFile.list())
        {
            TextView mTextView = new TextView(this);
            mTextView.setText(strFile);

            mTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            linearLayout.addView(mTextView);
        }
    }//..


}//.









