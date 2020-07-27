package com.example.bdsta_viz.ui.home.listFragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bdsta_viz.R;
import com.example.bdsta_viz.ui.home.mapFragment.MapFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/********************************************************************************
 *  ListFragment class: This option in the Home tab, displays data in a list    *
 *                      view. List views include tabular displays and bar       *
 *                      charts.                                                 *
 *                                                                              *
 * @author Md Rakeen Murtaza (rakeen.murtaza.12@gmail.com)                      *
 ********************************************************************************/


public class ListFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout country;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_list, container, false);

        // Map Button
        Button mapBtn = (Button) root.findViewById(R.id.mapButton);
        mapBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, mapFragment, mapFragment.getTag()).commit();
            }
        });

        country = root.findViewById(R.id.country_name);
        country.setOnClickListener(this);
        // Initialize recycle view and layoutManager
        recyclerView = root.findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchData("Bangladesh", "country", "2016");    // District demographics (population)
        //fetchData("Dhaka", "city", String.valueOf(LocalDate.now()));  // Dhaka zone cases -- For covid

        return root;
    }

    // When User wants to view Bar charts, this function replaces the fragment with BarChartFragment
    public void showOtherFragment() {
        BarChartFragment barChartFragment = new BarChartFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment, barChartFragment, barChartFragment.getTag()).commit();
    }

    protected void populateList(JSONObject inputJson) {
        // Set the adapter to show the data in the recyclerview and parse json into list
        adapter = new ListAdapter(parseJson(inputJson));
        recyclerView.setAdapter(adapter);
    }

    // This method is used to get the data about covid cases from the API. It uses the AsyncTask class.
    protected void fetchData(String name, String type, String year) {
        // Parameters for the API
        String params = "name="+name+"&type="+type+"&year="+year;

        // Creating a DataFetcher object to be executed as a separate thread
        DataFetcher df = new DataFetcher() {
            //Function that is called from the AsyncTask before the work is started.
            @Override
            public void onPreExecute(){
                //TODO: Show progress bar/spinner
            }

            //Function that is called from the AsyncTask when the background work is done. Updates the UI with the results
            @Override
            public void onPostExecute(JSONObject result){
                if(result != null) {
                    populateList(result);   // Populate the list if a result is fetched
                }
                else{
                    //We didn't get a response we expected.
                    Toast.makeText(getContext(), "Error! Couldn't fetch data.", Toast.LENGTH_SHORT).show();
                }

                //TODO: Hide the spinner
            }
        };

        // Execute the thread
        df.execute(params);
    }

    // This method is used to parse the JSON from the API into a list of cases
    protected ArrayList<Case> parseJson(JSONObject jsonObject) {
        ArrayList<Case> caseList = new ArrayList<>();

        try {
            if (jsonObject.getString("status").equals("error")) {
                Toast.makeText(getContext(), "Error! Couldn't find data.", Toast.LENGTH_SHORT).show();
                return null;
            }

            JSONObject payload = jsonObject.getJSONObject("payload");     // JSON object which contains all the data
            String level = payload.getString("level");              // Determines if city or zone
            JSONArray data = payload.getJSONArray("data");          // JSON array which contains the list of city/zone-cases

            // Loop through the JSON objects inside the array
            for (int i = 0; i < data.length(); i++) {
                JSONObject obj = data.getJSONObject(i); // Get objects at each array index
                String loc = (level.equals("city") ? "city" : "zone");  // Determines whether it is a city or a Dhaka zone -- for covid
                caseList.add(new Case(obj.getString(loc), obj.getInt("pop")));    // Adds each case to a list (Modified: pop/area instead of cases)
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        // Sort the list by number of cases in descending order
        Collections.sort(caseList, new Comparator<Case>() {
            @Override
            public int compare(Case obj1, Case obj2) {  // Compare number of cases
                return obj2.getPopulation() - obj1.getPopulation();
            }
        });

        return caseList;    // Return the list created
    }

    @Override
    public void onClick(View v) {
        showOtherFragment(); //clicking the top linear layout will inflate the new BarChartFragment
    }
}
