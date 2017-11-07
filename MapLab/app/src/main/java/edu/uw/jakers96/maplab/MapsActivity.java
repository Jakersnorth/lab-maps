package edu.uw.jakers96.maplab;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera

        LatLng sydney = new LatLng(47.653799, -122.307801);

        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Fountain Ducks")
                .snippet("In spring these ducks get their own ADA compliant ramp")
                .icon(BitmapDescriptorFactory.defaultMarker(267)));

        PolylineOptions dubs = new PolylineOptions();
        dubs.add(new LatLng(47.653796, -122.308228));
        dubs.add(new LatLng(47.653619, -122.308021));
        dubs.add(new LatLng(47.653794, -122.307812));
        dubs.add(new LatLng(47.653588, -122.307614));
        dubs.add(new LatLng(47.653808, -122.307429));
        dubs.color(Color.argb(1000, 51, 0, 111));
        dubs.width(20);

        mMap.addPolyline(dubs);
    }
}
