package com.kachidoki.mayiwei.demo2048.config;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by mayiwei on 16/10/7.
 */
public class Utils {

    public static DisplayMetrics getDisplayMetrics(Context context){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager vm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = vm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }

    public static int getDeviceDensity(Context context){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return (int) metrics.density;
    }
}
