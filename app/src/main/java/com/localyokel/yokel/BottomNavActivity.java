package com.localyokel.yokel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.localyokel.yokel.dummy.DummyContent;

public class BottomNavActivity extends AppCompatActivity implements PackageFragment.OnListFragmentInteractionListener {

    //private TextView mTextMessage;
    private ViewPager mViewPager;
    private NavPagerAdapter mPageAdapter;
    //private FrameLayout mFrameLayout;

    private PackageFragment mPackageFragment = new PackageFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_plan:
                    mViewPager.setCurrentItem(0);
                    //mTextMessage.setText(R.string.title_plan);
                    return true;
                case R.id.navigation_grower:
                    mViewPager.setCurrentItem(1);
                    //mTextMessage.setText(R.string.title_growers);
                    return true;
                case R.id.navigation_package:
                    mViewPager.setCurrentItem(2);
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

        //mTextMessage = (TextView) findViewById(R.id.message);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mPageAdapter = new NavPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
