package com.localyokel.yokel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentManager;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.localyokel.yokel.ListItems.GrowerContent;
import com.localyokel.yokel.ListItems.OrderContent;
import com.localyokel.yokel.ListItems.PackageContent;

public class BottomNavActivity extends AppCompatActivity implements GrowerFragment.OnListFragmentInteractionListener,
        OrderFragment.OnListFragmentInteractionListener, PackageFragment.OnListFragmentInteractionListener
{

    //private TextView mTextMessage;
    //private ViewPager mViewPager;
    private FrameLayout mFrameLayout;

    private PackageFragment mPackageFragment = new PackageFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            FragmentManager fragmentManager = getFragmentManager();

            switch (item.getItemId()) {
                case R.id.navigation_plan:
                    fragment = new PackageFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, fragment )
                            .commit();
                    //mTextMessage.setText(R.string.title_plan);
                    return true;
                case R.id.navigation_grower:
                    fragment = new GrowerFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, fragment )
                            .commit();
                    //mViewPager.setCurrentItem(1);
                    //mTextMessage.setText(R.string.title_growers);
                    return true;
                case R.id.navigation_package:
                    fragment = new OrderFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, fragment )
                            .commit();
                    //mViewPager.setCurrentItem(2);
                    //mTextMessage.setText(R.string.title_orders);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);


        Fragment fragment = new PackageFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment )
                .commit();
        //mTextMessage = (TextView) findViewById(R.id.message);
        //mViewPager = (ViewPager) findViewById(R.id.view_pager);

        //mViewPager.setAdapter(mPageAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onListFragmentInteraction(OrderContent.OrderItem item) {

    }

    @Override
    public void onListFragmentInteraction(PackageContent.PackageItem item) {

    }

    @Override
    public void onListFragmentInteraction(GrowerContent.GrowerItem item) {

    }
}
