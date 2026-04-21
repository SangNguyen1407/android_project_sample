package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.navigationdrawer.NaviDrawerFragment.FavoriteFragment;
import com.example.navigationdrawer.NaviDrawerFragment.HistoryFragment;
import com.example.navigationdrawer.NaviDrawerFragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_FAVORITE = 1;
    private static final int FRAGMENT_HISTORY = 2;

    private int mCurrentFragment = FRAGMENT_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.main);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.navi_drawer_open,
                R.string.navi_drawer_close);
        mDrawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.navi_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.navi_home){
            if (mCurrentFragment != FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                mCurrentFragment = FRAGMENT_HOME;
            }
        }
        else if (id == R.id.navi_favorite){
            if (mCurrentFragment != FRAGMENT_FAVORITE){
                replaceFragment(new FavoriteFragment());
                mCurrentFragment = FRAGMENT_FAVORITE;
            }
        }
        else if (id == R.id.navi_history){
            if (mCurrentFragment != FRAGMENT_HISTORY){
                replaceFragment(new HistoryFragment());
                mCurrentFragment = FRAGMENT_HISTORY;
            }
        }
        else if (id == R.id.navi_profile){

        }
        else if (id == R.id.navi_change_pass){

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}