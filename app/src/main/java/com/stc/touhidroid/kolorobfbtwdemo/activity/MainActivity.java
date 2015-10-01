package com.stc.touhidroid.kolorobfbtwdemo.activity;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.stc.touhidroid.kolorobfbtwdemo.R;
import com.stc.touhidroid.kolorobfbtwdemo.adapters.SocialFragPagerAdapter;
import com.stc.touhidroid.kolorobfbtwdemo.models.PagerTabItem;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppConstants;
import com.stc.touhidroid.kolorobfbtwdemo.utils.DepthPageTransformer;
import com.stc.touhidroid.kolorobfbtwdemo.views.SlidingTabLayout;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "Ry0m7RkvJT6wmMdo9aa4y9Ypa";
    private static final String TWITTER_SECRET = "gPCndp5KnmXzQWdT8QAbjOazENWFrYjrRQ4gt8AOW1mZdxJI7T";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbarMainActivity);
        setSupportActionBar(toolbar);

        configureViewPager();
    }

    private void configureViewPager() {
        final ArrayList<PagerTabItem> tabList = getSocialTabList();

        ViewPager vPagerSocialTabs = (ViewPager) findViewById(R.id.vPagerSocialTabs);
        vPagerSocialTabs.setAdapter(new SocialFragPagerAdapter(getSupportFragmentManager(), tabList));
        vPagerSocialTabs.setPageTransformer(true, new DepthPageTransformer());

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stlSocialTabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(vPagerSocialTabs);

        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return tabList.get(position).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return tabList.get(position).getDividerColor();
            }

        });
    }

    private ArrayList<PagerTabItem> getSocialTabList() {
        ArrayList<PagerTabItem> tabList = new ArrayList<>();
        tabList.add(new PagerTabItem(AppConstants.KEY_FACEBOOK_ID,
                "Facebook",
                R.color.green_cream,
                Color.GRAY
        ));

        tabList.add(new PagerTabItem(AppConstants.KEY_TWITTER_ID,
                "Twitter",
                R.color.twitter_blue,
                Color.GRAY
        ));

        return tabList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
