package com.kachidoki.mayiwei.demo2048.app;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by mayiwei on 16/10/4.
 */
public class App extends Application {
    public static SharedPreferences msp;

    public static int mGameGoal;
    public static int mGameLines;
    public static int mItemSize;

    //record score
    public static int SCORE = 0;
    public static String SP_HIGH_SCORE = "SP_HIGHSCORE";
    public static String KEY_HIGH_SCORE = "KEY_HIGHSCORE";
    public static String KEY_GAME_LINES = "KEY_GAMELINES";
    public static String KEY_GAME_GOAL = "KEY_GAMEGOAL";

    @Override
    public void onCreate() {
        super.onCreate();
        msp = getSharedPreferences(SP_HIGH_SCORE,0);
        mGameLines = msp.getInt(KEY_GAME_LINES,4);
        mGameGoal = msp.getInt(KEY_GAME_GOAL,2048);
        mItemSize = 0;
    }
}
