package com.adroitdevs.maps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final CameraPosition NEWYORK = CameraPosition.builder()
            .target(new LatLng(40.784, -73.9857))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.3491))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478, -6.2597))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition JOMBANG = CameraPosition.builder()
            .target(new LatLng(-7.559808, 112.235786))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    GoogleMap mGoogleMap;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMap = (Button) findViewById(R.id.btnSeattle);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    flyTo(SEATTLE);
                }
            }
        });

        Button btnSatellite = (Button) findViewById(R.id.btnDublin);
        btnSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    flyTo(DUBLIN);
                }
            }
        });

        Button btnHybrid = (Button) findViewById(R.id.btnJombang);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) {
                    flyTo(JOMBANG);
                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target) {
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        mGoogleMap = map;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(NEWYORK);
    }

}