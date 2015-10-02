package com.stc.touhidroid.kolorobfbtwdemo.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.stc.touhidroid.kolorobfbtwdemo.R;

/**
 * Created by touhid on 10/2/15.
 * @author touhid
 */
public class AppDialogManager {
    public static void showSimpleAlert(Context ctx, String message) {
        try {
            AlertDialog.Builder b = new AlertDialog.Builder(ctx);
            b.setMessage(message);
            b.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog d = b.create();
            d.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            d.show();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
            } catch (Exception e2) {
                ALog.e("showSimpleAlert", "Alert nor Toast can be shown.", e2);
            }
        }
    }
}
