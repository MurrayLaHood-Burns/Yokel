package com.localyokel.yokel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 7201363 on 3/25/2017.
 */

public class NavPagerAdapter extends FragmentPagerAdapter {

    public NavPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Bundle args;

        switch (position) {
            case 0:
                fragment = new PackageFragment();
                args = new Bundle();
                fragment.setArguments(args);
                break;
            case 1:
            case 2:
            default:
                fragment = new PackageFragment();
                args = new Bundle();
                fragment.setArguments(args);
        }

        return  fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
