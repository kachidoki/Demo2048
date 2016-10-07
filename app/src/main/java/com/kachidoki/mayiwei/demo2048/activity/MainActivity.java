package com.kachidoki.mayiwei.demo2048.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kachidoki.mayiwei.demo2048.R;
import com.kachidoki.mayiwei.demo2048.app.App;
import com.kachidoki.mayiwei.demo2048.view.GameView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static MainActivity mainActivity;
    private TextView mTvScore;
    private TextView mTvHighScore;
    private int mHighScore;

    private TextView mTvGoal;
    private int mGoal;

    private Button mBtnRestart;
    private Button mBtnRevert;
    private Button mBtnOptions;
    private GameView mGameView;

    public MainActivity(){
        mainActivity = this;
    }

    public static MainActivity getMainActivity(){
        return mainActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mGameView = new GameView(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.game_panel);
        // 为了GameView能居中
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.game_panel_rl);
        relativeLayout.addView(mGameView);
    }

    private void initView() {
        mTvScore = (TextView) findViewById(R.id.scroe);
        mTvGoal = (TextView) findViewById(R.id.tv_Goal);
        mTvHighScore = (TextView) findViewById(R.id.record);
        mBtnRestart = (Button) findViewById(R.id.btn_restart);
        mBtnRevert = (Button) findViewById(R.id.btn_revert);
        mBtnOptions = (Button) findViewById(R.id.btn_option);
        mBtnRestart.setOnClickListener(this);
        mBtnRevert.setOnClickListener(this);
        mBtnOptions.setOnClickListener(this);
        mHighScore = App.msp.getInt(App.KEY_HIGH_SCORE, 0);
        mGoal = App.msp.getInt(App.KEY_GAME_GOAL, 2048);
        mTvHighScore.setText("" + mHighScore);
        mTvGoal.setText("" + mGoal);
        mTvScore.setText("0");
        setScore(0, 0);
    }

    public void setScore(int score, int flag) {
        switch (flag) {
            case 0:
                mTvScore.setText("" + score);
                break;
            case 1:
                mTvHighScore.setText("" + score);
                break;
            default:
                break;
        }
    }

    public void setGoal(int num) {
        mTvGoal.setText(String.valueOf(num));
    }

    private void getHighScore() {
        int score = App.msp.getInt(App.KEY_HIGH_SCORE, 0);
        setScore(score, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_restart:
                mGameView.startGame();
                setScore(0, 0);
                break;
            case R.id.btn_revert:
                mGameView.revertGame();
                break;
            case R.id.btn_option:
                Intent intent = new Intent(MainActivity.this, ConfigAcitivity.class);
                startActivityForResult(intent, 0);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            mGoal = App.msp.getInt(App.KEY_GAME_GOAL, 2048);
            mTvGoal.setText("" + mGoal);
            getHighScore();
            mGameView.startGame();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
