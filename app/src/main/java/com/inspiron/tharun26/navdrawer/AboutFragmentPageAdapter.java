package com.inspiron.tharun26.navdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tharun26 on 9/2/15.
 */
public class AboutFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "CEG", "DoME", "Developer","Designer" };

    public AboutFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
        return FragmentAbout1.newInstance(position);
        else if(position==1)
        return FragmentAbout2.newInstance(position);
        else if(position==2)
            return FragmentAbout3.newInstance(position);
        else if (position==3)
            return FragmentAbout4.newInstance(position);


        return null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
