package com.example.ap_basic_map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    TextView txtlatitud,txtlongitud;

    private GoogleMap myMap;
    private Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtlatitud=findViewById(R.id.txtlatitud);
        txtlongitud=findViewById(R.id.txtlongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {

        myMap = googleMap;
        this.myMap.setOnMapClickListener(this);
        this.myMap.setOnMapLongClickListener(this);

        LatLng santa = new LatLng(-17.78629,-63.18117);
        myMap.addMarker(new MarkerOptions().position(santa).title("santa cruz puej"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(santa));
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng)
    {
        txtlatitud.setText(String.valueOf(latLng.latitude));
        txtlongitud.setText(String.valueOf(latLng.longitude));

        myMap.clear();
        LatLng mexico = new LatLng(latLng.latitude,latLng.longitude);
        myMap.addMarker(new MarkerOptions().position(mexico).title(""));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtlatitud.setText(String.valueOf(latLng.latitude));
        txtlongitud.setText(String.valueOf(latLng.longitude));

        myMap.clear();
        LatLng santa = new LatLng(latLng.latitude,latLng.longitude);
        myMap.addMarker(new MarkerOptions().position(santa).title(""));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(santa));
    }
}