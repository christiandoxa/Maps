package com.adroitdevs.maps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class MainActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetViewPanoramaFragment);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
        panorama.setPosition(new LatLng(36.0579667, -112.1430996));
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        panorama.animateTo(camera, 10000);
    }
}