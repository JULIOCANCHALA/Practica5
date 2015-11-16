package com.canchala.julio.practica5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {


    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab=actionBar.newTab().setIcon(R.drawable.ic_favorite_white_36dp).setTabListener(this);
        actionBar.addTab(tab);
        tab=actionBar.newTab().setIcon(R.drawable.ic_local_dining_white_36dp).setTabListener(this);
        actionBar.addTab(tab);
        /*
        tab=actionBar.newTab().setIcon(R.drawable.ic_local_bar_white_36dp).setTabListener(this);
        actionBar.addTab(tab);
        tab=actionBar.newTab().setIcon(R.drawable.ic_explore_white_36dp).setTabListener(this);
        actionBar.addTab(tab);
        tab=actionBar.newTab().setIcon(R.drawable.ic_local_movies_white_36dp).setTabListener(this);
        actionBar.addTab(tab);
        tab=actionBar.newTab().setIcon(R.drawable.ic_teatro).setTabListener(this);
        actionBar.addTab(tab);
        */



    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
     getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                return new inicio();
                case 1:
                    return new Comida();
                /*
                case 2:
                    return new Rumba();
                case 3:
                    return new Lugares();
                case 4:
                    return new Cine();
                case 5:
                    return new Teatro();
                    */
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }



}
