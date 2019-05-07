package com.example.asus.equilibrium;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Contact us page", Toast.LENGTH_SHORT).show();
                 Snackbar.make(view, "Contact Us Page", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
                 startActivity(new Intent(MainActivity.this, ContactActivity.class));

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // The if statement belows allows the chosen
        // fragment to be displayed when the app is executed
        if (savedInstanceState== null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.screen_area,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        // if statement for the setting action in to right corner
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here
       ///  fragment = new FoodRecipeFragment() = imports the
        // chosen fragment from the java class
        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            // Handles the  action
        } else if (id == R.id.nav_diet_plan) {
            fragment = new FoodRecipeFragment();

        } else if (id == R.id.nav_allergies) {
            fragment = new AllergiesFragment();

        } else if (id == R.id.nav_exercises) {
            fragment = new ExerciseFragment();

        } else if (id == R.id.nav_make_your_own) {
            fragment = new MakeYourOwnFragment();

        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        } else if (id == R.id.nav_contact_us) {
       //     startActivity(new Intent(MainActivity.this, ContactActivity.class));
            Intent contactUsIntent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(contactUsIntent);

        } else if (id == R.id.nav_share) {
            Intent shareintent = new Intent();
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.putExtra(Intent.EXTRA_TEXT,  "https://play.google.com/store/apps/details?@id-hi");
            shareintent.setType("text/plain");
            startActivity(Intent.createChooser(shareintent,"Share Via" ));

        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
        }

        // if statement is used to get the fragments
        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();

            // ft = Fragment Transaction
            // The code below basically replaces the screen ui/area with a
            // a chosen fragment such home, settings ect
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
