package com.example.assignment2aug2022;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
//    Boolean isPermission;
//    MapView mapView;

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    FourthFragment fourthFragment = new FourthFragment();
    LocationScreen locationScreen = new LocationScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
//        checkPermissionMap();

//        mapView = findViewById(R.id.);

//        if (isPermission) {
//            checkGooglePlayService();
//            mapView.getMapAsync(this);
//            mapView.onCreate(savedInstanceState);
//
//        } else {
//            Toast.makeText(this, "GoogleService not Available", Toast.LENGTH_SHORT).show();
//        }
    }

//    private boolean checkGooglePlayService() {
//        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
//        int result = googleApiAvailability.isGooglePlayServicesAvailable(this);
//        if (result == ConnectionResult.SUCCESS) {
//            return true;
//        } else if (googleApiAvailability.isUserResolvableError(result)) {
//
//            Dialog dialog = googleApiAvailability.getErrorDialog(this, result, 201, new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dialogInterface) {
//                    Toast.makeText(MainActivity.this, "User Cancelked Dialoge", Toast.LENGTH_SHORT).show();
//                }
//
//            });
//
//            dialog.show();
//            ;
//        }
//
//        return false;
//    }

//    private void checkPermissionMap() {
//
//        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
//            @Override
//            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                isPermission = true;
//                Toast.makeText(MainActivity.this, "Permission Granter", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//                Intent intent = new Intent();
//                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                Uri uri = Uri.fromParts("package", getPackageName(), "");
//                intent.setData(uri);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//                permissionToken.cancelPermissionRequest();
//            }
//        }).check();
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                return true;
            case R.id.appointment:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                return true;
            case R.id.location:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;
            case R.id.more:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourthFragment).commit();
                return true;
        }
        return false;
    }


    public void OnToLocation(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, locationScreen).commit();
    }

//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//
//    }
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mapView.onStart();
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mapView.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mapView.onStop();
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        mapView.onSaveInstanceState(outState);
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mapView.onLowMemory();
//    }
}