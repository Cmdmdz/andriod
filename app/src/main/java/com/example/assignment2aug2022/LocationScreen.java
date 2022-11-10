package com.example.assignment2aug2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationScreen extends Fragment {

    public LocationScreen(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view   = inflater.inflate(R.layout.location, container, false);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView);

        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(googleMap -> googleMap.setOnMapClickListener(latLng -> {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title(latLng.latitude+ " : " + latLng.longitude);
            googleMap.clear();
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
            googleMap.addMarker(markerOptions);
        }));

        return view;
    }
}
