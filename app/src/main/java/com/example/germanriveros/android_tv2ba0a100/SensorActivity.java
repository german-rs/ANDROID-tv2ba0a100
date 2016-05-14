package com.example.germanriveros.android_tv2ba0a100;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.util.Pools;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 * Created by germanriveros on 14-05-16.
 */
public class SensorActivity extends AppCompatActivity implements SensorEventListener
{

    private SensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor sensor : sensorList)
            Log.d(" --Sensor: ", sensor.getName());

    }


    @Override
    public void onSensorChanged(SensorEvent event)
    {
        synchronized (this)
        {
            switch (event.sensor.getType())
            {
                case Sensor.TYPE_ACCELEROMETER:

                    for (int i = 0 ; i < 3 ; i++)
                    {
                        Log.d("SensorActivity", String.valueOf(event.values[i]));
                    }

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}//.
