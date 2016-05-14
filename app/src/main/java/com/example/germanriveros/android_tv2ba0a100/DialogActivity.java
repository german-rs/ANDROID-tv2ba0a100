package com.example.germanriveros.android_tv2ba0a100;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * Created by germanriveros on 14-05-16.
 */
public class DialogActivity extends AppCompatActivity
{

    private final CharSequence[] items = {"blue", "green", "yellow"};
    private ProgressDialog barProgressDialog;
    private AlertDialog.Builder builder;
    private Handler updateBarHandler;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);

        //showDialog();
        //showDialogwithList();
        //showDialogwithCheckBox();
        //showRingDialog();
        //showBarDialog();
        showCustomDialog();

    }//..


    private void showDialog()
    {

        new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Cerrar aplicacion")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        Log.d("Dialog","seguimos en la aplicacion.");
                    }
                }).show();

    }//..

    private void showDialogwithList()
    {

        builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick a Color");

        builder.setItems(items, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), items[which],Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


    private void showDialogwithCheckBox()
    {

        builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick a Color");

        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                Toast.makeText(getApplicationContext(), items[which],Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }//..

    private void showRingDialog()
    {

        final ProgressDialog ringProgressDialog;
        ringProgressDialog = ProgressDialog.show(DialogActivity.this, "Espere", "Descargando...", true);
        ringProgressDialog.setCancelable(true);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                ringProgressDialog.dismiss();

            }
        }).start();


    }//..


    private void showBarDialog()
    {

        barProgressDialog = new ProgressDialog(DialogActivity.this);
        updateBarHandler = new Handler();

        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
        barProgressDialog.setMessage("Descargando...");
        barProgressDialog.setTitle("Espere");
        barProgressDialog.setProgress(0);
        barProgressDialog.setMax(20);
        barProgressDialog.show();


        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    while (barProgressDialog.getProgress() <= barProgressDialog.getMax())
                    {

                        Thread.sleep(2000);

                        updateBarHandler.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                barProgressDialog.incrementProgressBy(2);

                            }
                        });

                        if(barProgressDialog.getProgress() == barProgressDialog.getMax())
                        {

                            barProgressDialog.dismiss();
                        }
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        }).start();

    }//..

    private void showCustomDialog()
    {

        builder = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        AlertDialog alert;

        builder.setView(inflater.inflate(R.layout.dialog_custom, null))

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {


                    }
                });

        alert = builder.create();
        alert.show();


    }//..



}//.






