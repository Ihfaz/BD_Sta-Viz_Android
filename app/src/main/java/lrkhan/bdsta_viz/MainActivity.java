package lrkhan.bdsta_viz;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Developer Name: Md Rakeen Murtaza
 * Contact: rakeen.murtaza@utdallas.edu
 * The following fragment operates when the user clicks on the 'Map' button
 * on the navigation bar
 */

public class MainActivity extends AppCompatActivity implements FragmentChangeListener {
    FragmentTransaction transaction = getFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // State of the app when the app is first opened
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MapFragment()).commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.navbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    // When options are selected on bottom navigation bar
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Instantiate a fragment class
                    Fragment fragment = null;
                    switch(item.getItemId()){
                        // Load MapFragment when user taps on Map button
                        case R.id.nav_map:
                            fragment = new MapFragment();
                            break;
                        // Load ListFragment when user taps on Map button
                        case R.id.nav_list:
                            fragment = new ListFragment();
                            break;
                    }

                    // Replace previous selection for every new click
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                    return true;
                }
            };

    @Override
    public void replaceFragment(Fragment fragment) { //navigation fragment will be replaced by BarChartFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment, fragment.toString()).commit();
    }
}
