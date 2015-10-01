package com.stc.touhidroid.kolorobfbtwdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stc.touhidroid.kolorobfbtwdemo.R;

/**
 * Created by touhid on 10/2/15.
 * @author touhid
 */
public class FacebookFragment extends Fragment {

    public static FacebookFragment newInstance(){
        return new FacebookFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fb_frag, container, false);
    }
}
