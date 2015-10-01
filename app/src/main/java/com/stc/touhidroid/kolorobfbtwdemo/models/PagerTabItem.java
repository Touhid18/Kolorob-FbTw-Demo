package com.stc.touhidroid.kolorobfbtwdemo.models;

import android.support.v4.app.Fragment;

import com.stc.touhidroid.kolorobfbtwdemo.fragments.FacebookFragment;
import com.stc.touhidroid.kolorobfbtwdemo.fragments.TwitterFragment;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppConstants;

/**
 * Created by touhid on 10/1/15.
 *
 * @author touhid
 */
public class PagerTabItem {
    private int tabId;
    private String tabTitle;
    private int indicatorColor;
    private int dividerColor;

    public PagerTabItem(int tabId, String tabTitle, int indicatorColor, int dividerColor) {
        this.tabId = tabId;
        this.tabTitle = tabTitle;
        this.indicatorColor = indicatorColor;
        this.dividerColor = dividerColor;
    }

    public int getTabId() {
        return tabId;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public int getIndicatorColor() {
        return indicatorColor;
    }

    public int getDividerColor() {
        return dividerColor;
    }

    public Fragment getPagerFragment() {
        if (this.getTabId() == AppConstants.KEY_FACEBOOK_ID)
            return FacebookFragment.newInstance();
        else if (this.getTabId() == AppConstants.KEY_TWITTER_ID)
            return TwitterFragment.newInstance();
        else
            return null;
    }

    @Override
    public String toString() {
        return "PagerTabItem{" +
                "tabTitle='" + tabTitle + '\'' +
                ", indicatorColor=" + indicatorColor +
                ", dividerColor=" + dividerColor +
                '}';
    }
}
