package com.learning.lion.mymaps;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Main
        extends Activity
        implements GoogleMap.OnCameraChangeListener,
        GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMyLocationChangeListener,
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener {

    private GoogleMap googleMap;
    private MapFragment mapFragment;
    private FragmentManager fragmentManager;
    private GoogleMapOptions googleMapOptions;
    private LatLng locationCoordenates;
    private CameraPosition.Builder cameraPositionBuilder;
    private CameraPosition cameraPosition;
    private StreetViewPanorama streetViewPanorama;
    private StreetViewPanoramaFragment streetViewPanoramaFragment;

    private LocationClient locationClient;
    private LocationRequest locationRequest;

    private boolean removeMarker = false;
    private boolean addMarker = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCamera();
        loadMapsOptions();
        loadMap();
        addStreetView();
        loadLocationTools();
    }

    protected void loadLocationTools() {
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(30000);
        locationRequest.setSmallestDisplacement(0.5f);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        locationClient = new LocationClient(this, this, this);

        try {
            locationClient.connect();
        } catch (Exception e) {
            Log.d("-----", e.getMessage());
        }
    }

    protected void loadCamera() {
        locationCoordenates = new LatLng(6.26950646, -75.56591749);

        cameraPositionBuilder = new CameraPosition.Builder();
        cameraPositionBuilder.zoom(15);
        cameraPositionBuilder.target(locationCoordenates);
        cameraPositionBuilder.tilt(0);
        // cameraPositionBuilder.bearing(-90);

        cameraPosition = cameraPositionBuilder.build();
    }

    protected void loadMapsOptions() {
        googleMapOptions = new GoogleMapOptions();
        googleMapOptions.rotateGesturesEnabled(true);
        googleMapOptions.mapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMapOptions.camera(cameraPosition);
        googleMapOptions.compassEnabled(true);
        googleMapOptions.tiltGesturesEnabled(true);
        googleMapOptions.zoomGesturesEnabled(true);
    }

    protected void loadMap() {
        mapFragment = MapFragment.newInstance(googleMapOptions);
        googleMap = mapFragment.getMap();

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mapContainer, mapFragment).commit();
    }

    protected void showMessage(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("INFO");
        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.show();
    }

    protected void loadEventsListeners() {
        googleMap.setOnCameraChangeListener(this);
        googleMap.setOnMapLongClickListener(this);
        googleMap.setOnMapClickListener(this);
        googleMap.setOnMyLocationButtonClickListener(this);
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMyLocationChangeListener(this);

        //showMessage("It works");
    }

    protected void addStreetView() {
        StreetViewPanoramaOptions streetViewPanoramaOptions = new StreetViewPanoramaOptions();
        streetViewPanoramaOptions.position(locationCoordenates);
        streetViewPanoramaOptions.zoomGesturesEnabled(true);
        streetViewPanoramaOptions.streetNamesEnabled(true);

        streetViewPanoramaFragment = StreetViewPanoramaFragment.newInstance(streetViewPanoramaOptions);
        streetViewPanorama = streetViewPanoramaFragment.getStreetViewPanorama();

        fragmentManager.beginTransaction().replace(R.id.streetviewpanorama, streetViewPanoramaFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.itNone:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;

            case R.id.itNormal:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.itSatellite:
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.itHybrid:
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case R.id.itTerrain:
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

            case R.id.itAddMarker:
                addMarker = true;
                break;

            case R.id.itRemoveMarker:
                removeMarker = true;
                break;

            case R.id.itPoly:
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.add(new LatLng(0, 0), new LatLng(25, 25), locationCoordenates);
                googleMap.addPolyline(polylineOptions);
                break;

            case R.id.itStreetView:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        googleMap = mapFragment.getMap();
        if (googleMap != null) {
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setAllGesturesEnabled(true);
        }
        try {
            loadEventsListeners();
        } catch (NullPointerException nullPointerException) {
        }

        if (streetViewPanorama == null) {
            streetViewPanorama = streetViewPanoramaFragment.getStreetViewPanorama();
        }

        if (locationClient.isConnected()) {
            locationClient.requestLocationUpdates(locationRequest, this);
        }
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        if (addMarker) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title("Marker a");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
            markerOptions.position(latLng);
            markerOptions.draggable(true);
            markerOptions.flat(true);

            googleMap.addMarker(markerOptions);
            addMarker = false;
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        /*googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(-33.86997, 151.2089), 18));*/
        //StreetViewPanoramaCamera streetViewPanoramaCamera = new StreetViewPanoramaCamera(5,0,0);
        streetViewPanorama.setPosition(latLng);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (removeMarker) {
            marker.remove();
            removeMarker = !removeMarker;
        }
        return true;
    }

    @Override
    public void onConnected(Bundle bundle) {
        showMessage("Ok connection");
        locationClient.requestLocationUpdates(locationRequest, this);
    }

    @Override
    public void onDisconnected() {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        showMessage("Failed connection " + connectionResult.toString());
    }

    @Override
    public void onMyLocationChange(Location location) {

    }

    @Override
    public void onLocationChanged(Location location) {
        locationCoordenates = new LatLng(location.getLatitude(), location.getLongitude());

        CameraPosition.Builder newPositionBuilder = new CameraPosition.Builder();
        newPositionBuilder.target(locationCoordenates);
        newPositionBuilder.zoom(100);

        CameraPosition newPosition = newPositionBuilder.build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(newPosition));

        Log.d("-----", location.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationClient.removeLocationUpdates(this);
    }
}
