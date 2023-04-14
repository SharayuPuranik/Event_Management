package com.example.event_management;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.event_management.MainActivity;
import com.example.event_management.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final LatLng LAVENDERBOUGH = new LatLng(19.0766, 72.9081);
    private static final LatLng TAJ_LANDS_END = new LatLng(19.0423, 72.8199);

    private static final LatLng JWMarriott = new LatLng(19.1019, 72.8262);
    private static final LatLng ITCMaratha = new LatLng(19.1040, 72.8697);
    private static final LatLng SaharaStar = new LatLng(19.0957, 72.8538);
    private static final LatLng TheOberoi = new LatLng(18.9269, 72.8206);
    private GoogleMap mMap;
    private Marker selectedMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button selectButton = findViewById(R.id.selectButton);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedMarker != null) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("markerTitle", selectedMarker.getTitle());
                    setResult(MainActivity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(MapsActivity.this, "Please select a marker", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(LAVENDERBOUGH).title("Lavenderbough"));
        mMap.addMarker(new MarkerOptions().position(TAJ_LANDS_END).title("Taj Lands End"));
        mMap.addMarker(new MarkerOptions().position(JWMarriott).title("JW Marriott"));
        mMap.addMarker(new MarkerOptions().position(ITCMaratha).title("ITC Maratha"));
        mMap.addMarker(new MarkerOptions().position(SaharaStar).title("Sahara Star"));
        mMap.addMarker(new MarkerOptions().position(TheOberoi).title("The Oberoi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(JWMarriott));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LAVENDERBOUGH,10));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (selectedMarker != null) {
                    selectedMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                }
                selectedMarker = marker;
                selectedMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                return true;
            }
        });
    }
}
