package com.example.bdsta_viz.ui.recentStats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bdsta_viz.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class RecentStatsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recent_stats, container, false);
        return root;
    }
}