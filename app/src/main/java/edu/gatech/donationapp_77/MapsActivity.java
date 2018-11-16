package edu.gatech.donationapp_77;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Displays a map with pins for each location
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        FragmentManager mapFragManager =  getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) mapFragManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // the map object

        // we use these to set the map to the center (average) of all locations
        double avgLat = 0;
        double avgLon = 0;


        // iterate through the list of locations and add them to the map as mapMarker objects
        // also add their lat/lon to the avg to be used for centering the map later
        for (Location loc : Location.getLocationList()) {
            LatLng newLtLng = new LatLng(Double.parseDouble(loc.getLatitude()),
                    Double.parseDouble(loc.getLongitude()));
            MarkerOptions proto = new MarkerOptions();
            proto = proto.position(newLtLng);
            proto = proto.title(loc.getName());
            proto = proto.snippet(loc.getPhoneNumber());
            googleMap.addMarker(proto);
            avgLat += Double.parseDouble(loc.getLatitude());
            avgLon += Double.parseDouble(loc.getLongitude());
        }

        // updating the avgLat/Lon by dividing by the number of locations
        List<Location> locations = Location.getLocationList();
        avgLat = avgLat / locations.size();
        avgLon = avgLon / locations.size();

        // create the object representing the "center" of all locations
        // and set the camera there
        LatLng center = new LatLng(avgLat, avgLon);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 10.5f));

    }
}
