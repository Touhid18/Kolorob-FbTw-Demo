package com.stc.touhidroid.kolorobfbtwdemo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.widget.ShareDialog;
import com.stc.touhidroid.kolorobfbtwdemo.R;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppConstants;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppDialogManager;
import com.stc.touhidroid.kolorobfbtwdemo.utils.AppUtils;

/**
 * Created by touhid on 10/2/15.
 *
 * @author touhid
 */
public class FacebookFragment extends Fragment {
   /* private CallbackManager callbackManager;
    private ShareDialog shareDialog;

    private FacebookCallback<Sharer.Result> facebookShareCallback = new FacebookCallback<Sharer.Result>() {
        @Override
        public void onSuccess(Sharer.Result result) {

        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };
*/
    private static final String NO_INTERNET_MSG = "No internet available! Please first connect to internet to post your status ...";
    public static FacebookFragment newInstance() {
        return new FacebookFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fb_frag, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        shareDialog.registerCallback(callbackManager, facebookShareCallback);*/

        final EditText etStatus = (EditText) view.findViewById(R.id.etPostStatusFb);

        view.findViewById(R.id.btnPostStatusFb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ctx = getActivity();
                if(!AppUtils.isInternetAvailable(ctx)){
                    AppDialogManager.showSimpleAlert(ctx, NO_INTERNET_MSG);
                    return;
                }
                ShareOpenGraphObject object = new ShareOpenGraphObject.Builder()
                        .putString("og:title", AppConstants.POST_TITLE)
                        .putString("og:type", "com_sci_kolorob_fbtw:status") // TO_DO
                        .putString("og:description", etStatus.getText().toString())
                        // .putString("books:isbn", "0-553-57340-3")/*TO_DO*/
                        .build();
                ShareOpenGraphAction action = new ShareOpenGraphAction.Builder()
                         .setActionType("com_sci_kolorob_fbtw:review") // TO_DO
                         .putObject("status", object) // TO_DO
                        .build();
                // Create the content
                ShareOpenGraphContent content = new ShareOpenGraphContent.Builder()
                         .setPreviewPropertyName("status") // TODO
                        .setAction(action)
                        .build();
                ShareDialog.show(FacebookFragment.this, content);
            }
        });

    }
}
