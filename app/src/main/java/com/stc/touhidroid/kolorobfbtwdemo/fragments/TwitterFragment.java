package com.stc.touhidroid.kolorobfbtwdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.stc.touhidroid.kolorobfbtwdemo.R;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppDialogManager;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppUtils;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

/**
 * Created by touhid on 10/2/15.
 *
 * @author touhid
 */
public class TwitterFragment extends Fragment {

    private static final String NO_INTERNET_MSG = "No internet available! Please first connect to internet to tweet ...";

    public static TwitterFragment newInstance() {
        return new TwitterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.twitter_frag, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*TweetComposer.Builder builder = new TweetComposer.Builder(getActivity())
                .text("just setting up my Fabric.");
                // .image(myImageUri);
        builder.show();*/
        /*loginButton = (TwitterLoginButton) view.findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });*/
        final EditText etTweet = (EditText) view.findViewById(R.id.etTweetTw);
        view.findViewById(R.id.btnPostTweetTw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ctx = getActivity();
                if(!AppUtils.isInternetAvailable(ctx)){
                    AppDialogManager.showSimpleAlert(ctx, NO_INTERNET_MSG);
                    return;
                }
                String tweetText = etTweet.getText().toString();
                if(tweetText.length()<2) {
                    Toast.makeText(ctx, "Too short Tweet!", Toast.LENGTH_SHORT).show();
                    return ;
                }
                TweetComposer.Builder builder = new TweetComposer.Builder(getActivity())
                        .text(tweetText);
                //.image(myImageUri);
                builder.show();
            }
        });

    }
    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getActivity(), "Twitter logged-in", Toast.LENGTH_SHORT).show();
    }*/
}
