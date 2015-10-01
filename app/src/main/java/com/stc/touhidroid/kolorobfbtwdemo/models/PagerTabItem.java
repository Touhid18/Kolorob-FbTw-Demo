package com.stc.touhidroid.kolorobfbtwdemo.models;

import android.support.v4.app.Fragment;

/**
 * Created by touhid on 10/1/15.
 *
 * @author touhid
 */
public class PagerTabItem {
    private String tabTitle;
    private int indicatorColor;
    private int dividerColor;

    public PagerTabItem(String tabTitle, int indicatorColor, int dividerColor) {
        this.tabTitle = tabTitle;
        this.indicatorColor = indicatorColor;
        this.dividerColor = dividerColor;
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

    public Fragment getPagerFragment(){

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
