package com.example.germanriveros.android_tv2ba0a100;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by germanriveros on 13-05-16.
 */
public class HelloBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {

        Log.d("BroadcastReceiver","power is connected!");

    }

}
