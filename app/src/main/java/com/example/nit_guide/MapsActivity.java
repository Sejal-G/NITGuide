package com.example.nit_guide;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    Location location;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_maps);
        Intent intent=getIntent ();
        place=intent.getStringExtra ("name");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ( )
                .findFragmentById (R.id.map);
        mapFragment.getMapAsync (this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


//        LatLng position = new LatLng(location.getLatitude (), location.getLongitude ());
//        mMap.addMarker(new MarkerOptions().position(position));

        LatLng sydney = null;
        if(place == "Library"){
             sydney = new LatLng (29.947742,76.815378);
            mMap.addMarker (new MarkerOptions ( ).position (sydney).title ("Library"));
        }
        else {
            sydney = new LatLng (29.947742,76.815378);
            mMap.addMarker (new MarkerOptions ( ).position (sydney).title ("Library"));

        }
        CameraPosition camPos = new CameraPosition(sydney, 15, 0,0);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
        mMap.animateCamera (CameraUpdateFactory.zoomTo (14) );





        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng (29.947805, 76.815576);

        //mMap.moveCamera (CameraUpdateFactory.newLatLng (sydney));
    }
}