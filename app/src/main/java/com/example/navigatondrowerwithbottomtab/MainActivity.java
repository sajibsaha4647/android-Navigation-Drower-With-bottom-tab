package com.example.navigatondrowerwithbottomtab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private ImageView menuBtn;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(this);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onClick(View view) {
        if(!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(GravityCompat.START);
        else drawerLayout.closeDrawer(GravityCompat.END);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.nav_home:
                Fragment fragment = new OneFragment();
                FragmentManager fragmentManager = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentid, fragment,null);
                fragmentTransaction.commitAllowingStateLoss();

                break;
            case R.id.nav_share:
                Fragment fragment1 = new TwoFragment();
                FragmentManager fragmentManager1 = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.fragmentid, fragment1,null);
                fragmentTransaction1.commitAllowingStateLoss();

                break;
            case R.id.nav_send:
                Fragment fragment2 = new ThreeFragment();
                FragmentManager fragmentManager2 = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fragmentid, fragment2,null);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commitAllowingStateLoss();
                break;
            case R.id.page_1:
                Toast.makeText(MainActivity.this,"warn page bottom 1",Toast.LENGTH_LONG).show();
                break;
        }

        return true;
    }
}