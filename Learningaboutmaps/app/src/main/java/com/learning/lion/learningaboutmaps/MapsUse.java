package com.learning.lion.learningaboutmaps;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsUse extends Activity implements GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private MapFragment mMapFragment;
    private GoogleMapOptions mGoogleMapOptions;
    private FragmentManager mFragmentManager;

    private static final LatLng MOUNTAIN_VIEW = new LatLng(0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_use);

//        mGoogleMapOptions = new GoogleMapOptions();
//        mGoogleMapOptions.mapType(GoogleMap.MAP_TYPE_TERRAIN);
//        mGoogleMapOptions.rotateGesturesEnabled(true);

        mFragmentManager = getFragmentManager();
        mMapFragment = (MapFragment) mFragmentManager.findFragmentById(R.id.map1);
        mMap = mMapFragment.getMap();
        //Log.w("--------------------", (mMap == null) + "");

        //mFragmentManager.beginTransaction().add(R.id.map1, mMapFragment).commit();

        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.target(MOUNTAIN_VIEW);
        //builder.zoom(25);
        builder.bearing(0);
        //builder.tilt(30);

        CameraPosition cameraPosition = builder.build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.setOnMapLongClickListener(this);
        mMap.setTrafficEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.setMyLocationEnabled(true);
    }

    private void setUpMapIfNeeded() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_maps_use, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();
        switch (itemID) {
            case R.id.itNone:
                mGoogleMapOptions = new GoogleMapOptions();
                mGoogleMapOptions.mapType(GoogleMap.MAP_TYPE_NONE);
                mGoogleMapOptions.rotateGesturesEnabled(true);

                mMapFragment = MapFragment.newInstance(mGoogleMapOptions);
                mMap = mMapFragment.getMap();
                mFragmentManager.beginTransaction().replace(R.id.map1, mMapFragment).commit();
                break;

            case R.id.itNormal:
                mGoogleMapOptions = new GoogleMapOptions();
                mGoogleMapOptions.mapType(GoogleMap.MAP_TYPE_NORMAL);
                mGoogleMapOptions.rotateGesturesEnabled(true);

                mMapFragment = MapFragment.newInstance(mGoogleMapOptions);
                mMap = mMapFragment.getMap();
                mFragmentManager.beginTransaction().replace(R.id.map1, mMapFragment).commit();
                break;

            case R.id.itSatellite:
                mGoogleMapOptions = new GoogleMapOptions();
                mGoogleMapOptions.mapType(GoogleMap.MAP_TYPE_SATELLITE);
                mGoogleMapOptions.rotateGesturesEnabled(true);

                mMapFragment = MapFragment.newInstance(mGoogleMapOptions);
                mMap = mMapFragment.getMap();
                mFragmentManager.beginTransaction().replace(R.id.map1, mMapFragment).commit();
                break;

            case R.id.itHybrid:
                mGoogleMapOptions = new GoogleMapOptions();
                mGoogleMapOptions.mapType(GoogleMap.MAP_TYPE_HYBRID);
                mGoogleMapOptions.rotateGesturesEnabled(true);

                mMapFragment = MapFragment.newInstance(mGoogleMapOptions);
                mMap = mMapFragment.getMap();
                mFragmentManager.beginTransaction().replace(R.id.map1, mMapFragment).commit();
                break;

            case R.id.itTerrain:
                mGoogleMapOptions = new GoogleMapOptions();
                mGoogleMapOptions.mapType(GoogleMap.MAP_TYPE_TERRAIN);
                mGoogleMapOptions.rotateGesturesEnabled(true);

                mMapFragment = MapFragment.newInstance(mGoogleMapOptions);
                mMap = mMapFragment.getMap();
                mFragmentManager.beginTransaction().replace(R.id.map1, mMapFragment).commit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        //Toast.makeText(this, "Longitude: " + latLng.longitude + "; Latitude: " + latLng.latitude, Toast.LENGTH_LONG).show();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("You are here");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        markerOptions.position(latLng);
        mMap.addMarker(markerOptions);
    }
}