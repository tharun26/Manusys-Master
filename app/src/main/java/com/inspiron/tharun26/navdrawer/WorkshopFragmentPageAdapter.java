package com.inspiron.tharun26.navdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tharun26 on 9/2/15.
 */
public class WorkshopFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Engine", "BLUEBOT", "HYBRID","INDUSTRIAL ROBOTICS" };

    public WorkshopFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0)
            return FragmentEngine.newInstance(position);
        else if(position==1)
            return FragmentBluebot.newInstance(position);
        else if(position==2)
            return FragmentHybrid.newInstance(position);
        else if(position==3)
            return FragmentRobotics.newInstance(position);

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
