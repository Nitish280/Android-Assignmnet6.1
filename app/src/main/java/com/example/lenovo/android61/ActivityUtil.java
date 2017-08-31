package com.example.lenovo.android61;

import android.content.Context;
import android.content.Intent;

/**
 * Created by lenovo on 8/31/2017.
 */

class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startSecondActivity() {
        context.startActivity(new Intent(context, SecondActivity.class));
    }
}