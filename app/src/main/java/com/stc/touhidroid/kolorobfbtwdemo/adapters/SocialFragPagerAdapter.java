package com.stc.touhidroid.kolorobfbtwdemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stc.touhidroid.kolorobfbtwdemo.models.PagerTabItem;
import com.stc.touhidroid.kolorobfbtwdemo.views.SlidingTabLayout;

import java.util.ArrayList;

/**
 * Created by touhid on 10/2/15.
 * @author touhid
 */
public class SocialFragPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<PagerTabItem> mTabList;

    public SocialFragPagerAdapter(FragmentManager fm, ArrayList<PagerTabItem> tabList) {
        super(fm);
        mTabList = tabList;
    }

    /**
     * Return the {@link android.support.v4.app.Fragment} to be displayed at {@code position}.
     * <p>
     * Here we return the value returned from {@link PagerTabItem#getPagerFragment()}.
     */
    @Override
    public Fragment getItem(int i) {
        return mTabList.get(i).getPagerFragment();
    }

    @Override
    public int getCount() {
        return mTabList.size();
    }

    // BEGIN_INCLUDE (pageradapter_getpagetitle)
    /**
     * Return the title of the item at {@code position}. This is important as what this method
     * returns is what is displayed in the {@link SlidingTabLayout}.
     * <p>
     * Here we return the value returned from {@link PagerTabItem#getTabTitle()}.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabList.get(position).getTabTitle();
    }
    // END_INCLUDE (pageradapter_getpagetitle)

}