package com.example.bdsta_viz.ui.home.listFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bdsta_viz.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/****************************************************************************
 * ListAdapter class: This class is the custom adapter for the RecyclerView *
 *                    which is used to display the case data as a list      *
 *                                                                          *
 * @author Ihfaz Tajwar                                                     *
 ****************************************************************************/
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Case> cases;  // Arraylist to hold the cases

    // Constructor
    public ListAdapter(ArrayList<Case> cases) {
        this.cases = cases;
    }

    // Initializing the view holder object
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        Case caseEntry = cases.get(position);

        holder.location.setText(caseEntry.getLocation());
        holder.populations.setText(String.valueOf(caseEntry.getPopulation()));
    }

    // Gets the size of the arraylist holding the cases
    @Override
    public int getItemCount() {
        if (cases == null || cases.isEmpty())
            return 0;

        return cases.size();
    }

    // Custom viewholder class to define the textviews for the case data fields
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView location, populations;

        // Initialize all the TextViews which hold the various field data for the cases
        public ListViewHolder(View view) {
            super(view);
            location = view.findViewById(R.id.location);
            populations = view.findViewById(R.id.n_cases);
        }
    }
}

