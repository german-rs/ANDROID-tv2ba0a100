package com.example.germanriveros.appsample;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.widget.EditText;
import android.content.Context;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;



import java.io.IOException;

/**
 * Created by germanriveros on 15-05-16.
 */
public class SaveNoteActivity extends Activity
{

    private EditText editText;
    private Button saveNote;

    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.write_note);

        saveNote = (Button) findViewById(R.id.buttonSaveNote);
        editText = (EditText)findViewById(R.id.editText);

        saveNote.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                long unixTime = System.currentTimeMillis() / 1000L;

                    String nameFile = String.valueOf(unixTime);

                        saveIntoFile(nameFile);

            }
        });

    }//..

    private void saveIntoFile(String nameFile)
    {

        try
        {
            FileOutputStream outputStream = openFileOutput(nameFile, Context.MODE_PRIVATE);

                outputStream.write(editText.getText().toString().getBytes());

                    outputStream.close();

        }
        catch (FileNotFoundException e)
        {

            e.printStackTrace();
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }

    }//..

}//.
