package com.example.project;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.project.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private ArrayList<String> selectedPlaces;
    String[] startPoints;
    String selectedStartPoint;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    LatLng dehradun = new LatLng(30.3165,78.0322);
    LatLng buddhaTemple = new LatLng(30.2616, 77.9977);
    LatLng fri = new LatLng(30.343769, 77.999559);
    LatLng robbersCave = new LatLng(30.3766, 78.0612);
    LatLng shahastradhara = new LatLng(30.387231, 78.131606);
    LatLng tapkeshwar = new LatLng(30.3573, 78.0167);
    //starting points
    LatLng ballupur = new LatLng(30.3336,78.0115);
    LatLng clementTown = new LatLng(30.2686, 78.0071);
    LatLng clockTower = new LatLng(30.3253, 78.0413);
    LatLng isbt = new LatLng(30.2870, 77.9983);
    LatLng paradeGround = new LatLng(30.3245, 78.0484);
    LatLng pacificMall = new LatLng(30.3665, 78.0703);
    LatLng premNagar = new LatLng(30.3340, 77.9602);
    LatLng rispanaPul = new LatLng(30.2939, 78.0579);
    LatLng rajpur = new LatLng(30.3847, 78.0894);
//    private ArrayList<LatLng> locationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        selectedPlaces = (ArrayList<String>) getIntent().getSerializableExtra("keySelectedPlaces");
        selectedStartPoint=getIntent().getStringExtra("keyStart");
        startPoints= getResources().getStringArray(R.array.array_default_startingPoints);

    }

    /**
     * Manipulates the  map once available.
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

        //set up marker for places if found in the array list of places to visit
        for(int i=0;i<=selectedPlaces.size()-1;i++){
            if(selectedPlaces.get(i).equals("Buddha Temple")){
                mMap.addMarker(new MarkerOptions().position(buddhaTemple).title("Buddha Temple")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.buddhatemple_icon));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(buddhaTemple));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
            }
            if(selectedPlaces.get(i).equals("Forest Research Institute")){
                mMap.addMarker(new MarkerOptions().position(fri).title("Forest Research Institute")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.fri_icon));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(fri));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
            }
            if(selectedPlaces.get(i).equals("Robber's Cave")){
                mMap.addMarker(new MarkerOptions().position(robbersCave).title("Robber's Cave")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.robberscave_icon));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(robbersCave));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
            }
            if(selectedPlaces.get(i).equals("Shahastradhara")){
                mMap.addMarker(new MarkerOptions().position(shahastradhara).title("Shahastradhara")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.shahastradhara_icon));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(shahastradhara));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
            }
            if(selectedPlaces.get(i).equals("Tapkeshwar")){
                mMap.addMarker(new MarkerOptions().position(tapkeshwar).title("Tapkeshwar")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.tapkeshwar_icon));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(tapkeshwar));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
            }
        }

        //set up marker for the starting point
        if(selectedStartPoint.equals("Ballupur")){
            mMap.addMarker(new MarkerOptions().position(ballupur).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ballupur));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Clement Town")){
            mMap.addMarker(new MarkerOptions().position(clementTown).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(clementTown));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Clock Tower")){
            mMap.addMarker(new MarkerOptions().position(clockTower).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(clockTower));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("ISBT")){
            mMap.addMarker(new MarkerOptions().position(isbt).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(isbt));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Parade Ground")){
            mMap.addMarker(new MarkerOptions().position(paradeGround).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(paradeGround));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Pacific Mall")){
            mMap.addMarker(new MarkerOptions().position(pacificMall).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(pacificMall));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Prem Nagar")){
            mMap.addMarker(new MarkerOptions().position(premNagar).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(premNagar));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Rispana Pul")){
            mMap.addMarker(new MarkerOptions().position(rispanaPul).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(rispanaPul));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }
        if(selectedStartPoint.equals("Rajpur")){
            mMap.addMarker(new MarkerOptions().position(rajpur).title("Starting Point"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(rajpur));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dehradun,12),null);
        }

    }
}