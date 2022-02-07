package com.example.navigatondrowerwithbottomtab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
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
    public ActionBarDrawerToggle actionBarDrawerToggle;

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

        fragment = new OneFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ChangeFrame, fragment,null);
        fragmentTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.page_1){
                    fragment = new OneFragment();
                    FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.ChangeFrame, fragment,null);
                    fragmentTransaction.commit();
                }else if(item.getItemId() == R.id.page_2){
                    fragment = new TwoFragment();
                    FragmentManager fragmentManager1 = MainActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    fragmentTransaction1.replace(R.id.ChangeFrame, fragment,null);
                    fragmentTransaction1.commit();
                }else if(item.getItemId() == R.id.page_3){
                    fragment = new ThreeFragment();
                    FragmentManager fragmentManager2 = MainActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.replace(R.id.ChangeFrame, fragment,null);
                    fragmentTransaction2.addToBackStack(null);
                    fragmentTransaction2.commit();
                }
                return true;
            }
        });



    }



    @Override
    public void onClick(View view) {
        ToggleDrawer();
    }

    public void ToggleDrawer(){
       try{
           if(!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(GravityCompat.START);
           else drawerLayout.closeDrawer(GravityCompat.END);
       }catch (Exception e){

       }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment;

        if(item.getItemId() == R.id.nav_home){
            fragment = new OneFragment();
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.ChangeFrame, fragment,null);
            fragmentTransaction.commit();

        }else if(item.getItemId() == R.id.nav_share){
            fragment = new TwoFragment();
            FragmentManager fragmentManager1 = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
            fragmentTransaction1.replace(R.id.ChangeFrame, fragment,null);
            fragmentTransaction1.commit();
        }else if(item.getItemId() == R.id.nav_send){
            fragment = new ThreeFragment();
            FragmentManager fragmentManager2 = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
            fragmentTransaction2.replace(R.id.ChangeFrame, fragment,null);
            fragmentTransaction2.addToBackStack(null);
            fragmentTransaction2.commit();
        }


        return true;
    }
}