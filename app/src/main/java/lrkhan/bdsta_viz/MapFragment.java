package lrkhan.bdsta_viz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Developer Name: Md Rakeen Murtaza
 * Contact: rakeen.murtaza@utdallas.edu
 * The following fragment operates when the user clicks on the 'Map' button
 * on the navigation bar
 */


public class MapFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }
}
