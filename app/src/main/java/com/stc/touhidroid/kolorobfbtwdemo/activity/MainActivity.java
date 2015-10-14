package com.stc.touhidroid.kolorobfbtwdemo.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.stc.touhidroid.kolorobfbtwdemo.R;
import com.stc.touhidroid.kolorobfbtwdemo.adapters.SocialFragPagerAdapter;
import com.stc.touhidroid.kolorobfbtwdemo.models.PagerTabItem;
import com.stc.touhidroid.kolorobfbtwdemo.utils.ALog;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppConstants;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppDialogManager;
import com.stc.touhidroid.kolorobfbtwdemo.utils.DepthPageTransformer;
import com.stc.touhidroid.kolorobfbtwdemo.views.SlidingTabLayout;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetui.TweetUi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(AppConstants.TWITTER_KEY,
                AppConstants.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new TweetUi(), new TweetComposer());

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbarMainActivity);
        setSupportActionBar(toolbar);

        configureViewPager();
        // showHashKey();
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

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }


    private void showHashKey() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.stc.touhidroid.kolorobfbtwdemo", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String k = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                ALog.d("KeyHash:", k);
                AppDialogManager.showSimpleAlert(this, k);
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            ALog.e(TAG, "showHashKey()", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
