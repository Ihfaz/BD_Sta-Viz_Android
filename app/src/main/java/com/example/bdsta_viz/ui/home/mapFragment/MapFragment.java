package com.example.bdsta_viz.ui.home.mapFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bdsta_viz.R;
import com.example.bdsta_viz.ui.home.listFragment.ListFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/********************************************************************************
 *  ListFragment class: This option in the Home tab, displays data in a map     *
 *                      view.                                                   *
 *                                                                              *
 * @author Md Rakeen Murtaza (rakeen.murtaza.12@gmail.com)                      *
 ********************************************************************************/

public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map; // Use Google Map API library

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_map, container, false);

        // List Button
        Button listBtn = (Button) root.findViewById(R.id.listButton);
        listBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ListFragment listFragment = new ListFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, listFragment, listFragment.getTag()).commit();
            }
        });

        return root;
    }

    // Display Map Fragment after view is created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment displayMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map1);
        displayMapFragment.getMapAsync(this);
    }

    // Add marker and move camera once map is displayed
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng pp = new LatLng(23.777048, 90.412463);

        MarkerOptions option = new MarkerOptions();
        option.position(pp).title("Gulshan-1, Dhaka, Bangladesh");
        map.addMarker(option);
        map.moveCamera(CameraUpdateFactory.newLatLng(pp));
    }
}
