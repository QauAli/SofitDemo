package com.duplicatefile.remover.file.sofitdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.duplicatefile.remover.file.sofitdemo.Fragments.HomeFragment;
import com.duplicatefile.remover.file.sofitdemo.Fragments.PostsFragment;
import com.duplicatefile.remover.file.sofitdemo.Fragments.ServicesFragment;
import com.duplicatefile.remover.file.sofitdemo.databinding.ActivityBaseBinding;
import com.duplicatefile.remover.file.sofitdemo.utils.AllStrings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Fragment mSelectedFrag = null;

    private Context mContext;
    private ActivityBaseBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBaseBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setBackground(null);
        mContext = BaseActivity.this;
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mBinding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        HomeFragment homeFragment = new HomeFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        mBinding.appBarMain.contentMain.bottomNavigationId.setSelectedItemId(R.id.home);
        mBinding.appBarMain.contentMain.bottomNavigationId.setOnNavigationItemSelectedListener(navlistner);

        setNavigationImages();

        mBinding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home: {
//                        Intent myIntent = new Intent(mContext, ChatActivity.class);
//                        mContext.startActivity(myIntent);
                        break;
                    }
                    case R.id.nav_services: {
//                        Intent myIntent = new Intent(mContext, MultimediaActivity.class);
//                        myIntent.putExtra("type", "images_display"); //Optional parameters
//                        mContext.startActivity(myIntent);
                        break;
                    }
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.home:
                            mSelectedFrag = new HomeFragment();
                            //Toast.makeText(BottomNavigationActivity.this, "all pdf", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.services:
                            mSelectedFrag = new ServicesFragment();
                            //Toast.makeText(BottomNavigationActivity.this, "recent", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.posts:
                            mSelectedFrag = new PostsFragment();
                            //Toast.makeText(BottomNavigationActivity.this, "favourites", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            mSelectedFrag).commit();

                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void setNavigationImages() {
        Menu menu = mBinding.appBarMain.contentMain.bottomNavigationId.getMenu();
        final MenuItem homeItem = menu.getItem(0);
        final MenuItem servicesItem = menu.getItem(1);
        final MenuItem postsItem = menu.getItem(2);
        setIcon(AllStrings.HOME_IMAGE_URL, homeItem);
        setIcon(AllStrings.SERVICE_IMAGE_URL, servicesItem);
        setIcon(AllStrings.POST_IMAGE_URL, postsItem);

        Menu navigationMenu = mBinding.navView.getMenu();
        final MenuItem navgationHomeItem = navigationMenu.getItem(0);
        setIcon(AllStrings.HOME_IMAGE_URL, navgationHomeItem);
        final MenuItem navgationServiceItem = navigationMenu.getItem(1);
        setIcon(AllStrings.SERVICE_IMAGE_URL, navgationServiceItem);



    }

    public void setIcon(String imageUrl, final MenuItem menuItem) {
        Glide.with(this).asBitmap().load(imageUrl).into(new SimpleTarget<Bitmap>(100, 100) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                menuItem.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });
        Glide.with(this).asBitmap().load(imageUrl).into(new SimpleTarget<Bitmap>(100, 100) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                menuItem.setIcon(new BitmapDrawable(getResources(), resource));
            }
        });
    }
}
