package com.example.bdsta_viz;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/********************************************************************************
 *  MainActivity class: The app has one main activity: The Navigation Drawer    *
 *                      Activity. All navigation drawer options and click       *
 *                      functionality has been implemented.                     *
 *                                                                              *
 * @author Md Rakeen Murtaza (rakeen.murtaza.12@gmail.com)                      *
 ********************************************************************************/

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_recent_stats, R.id.nav_about_app, R.id.nav_about_us)
                .setDrawerLayout(drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        /* What happens when each Navigation Drawer item is clicked */

        switch(item.getItemId()){
            case R.id.nav_home:{
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.nav_home);
                break;
            }
            case R.id.nav_recent_stats:{
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.nav_recent_stats);
                break;
            }
            case R.id.nav_about_app:{
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.nav_about_app);
                break;
            }
            case R.id.nav_about_us:{
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.nav_about_us);
                break;
            }
        }


        item.setChecked(true); // Highlight the one selected
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}