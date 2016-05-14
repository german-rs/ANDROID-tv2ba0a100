package com.example.germanriveros.android_tv2ba0a100;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by germanriveros on 14-05-16.
 */
public class LocationActivity extends AppCompatActivity implements LocationListener {


    private static final long MIN_TIME = 10 * 1000;
    private static final long MIN_DISTANCE = 5;
    private LocationManager mLocationManager;
    private Location localization;
    private TextView mTextView;
    private Criteria criteria;
    private String mProvider;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.location);

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mTextView = (TextView) findViewById(R.id.locationText);
        criteria = new Criteria();

        criteria.setCostAllowed(false);
        criteria.setAltitudeRequired(false);
        criteria.setAccuracy(criteria.ACCURACY_FINE);

        mProvider = mLocationManager.getBestProvider(criteria, true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {

            return;
        }
        localization = mLocationManager.getLastKnownLocation(mProvider);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {

            return;
        }
        mLocationManager.requestLocationUpdates(mProvider, MIN_TIME, MIN_DISTANCE, LocationActivity.this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {

            return;
        }
        mLocationManager.removeUpdates(this);

    }

    @Override
    public void onLocationChanged(Location location)
    {

        mTextView.append(mTextView.getText().toString() + location.toString() + "\n");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){}

    @Override
    public void onProviderEnabled(String provider){}

    @Override
    public void onProviderDisabled(String provider){}

}//.
