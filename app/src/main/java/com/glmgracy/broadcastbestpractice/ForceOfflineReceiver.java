package com.glmgracy.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by glmgr on 2016/11/19.
 */

public class ForceOfflineReceiver  extends BroadcastReceiver{
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Force Offline")
                .setMessage("You're forced to offline")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.finishAll();
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });
        AlertDialog alertDialog = builder.create();
        //TYPE_SYSTEM_ALERT -> TYPE_TOAST
        //Android6.0 以上要另外申请权限
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alertDialog.show();
    }
}
