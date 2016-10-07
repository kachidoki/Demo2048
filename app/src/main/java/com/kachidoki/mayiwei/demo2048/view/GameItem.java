package com.kachidoki.mayiwei.demo2048.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kachidoki.mayiwei.demo2048.app.App;

/**
 * Created by mayiwei on 16/10/4.
 */
public class GameItem extends FrameLayout{

    //Item show number
    private int mCardShowNum;
    //number title
    private TextView mTVNum;
    //title LayoutParams
    private LayoutParams mParams;


    public GameItem (Context context,int cardShowNum){
        super(context);
        this.mCardShowNum = cardShowNum;
        InitGameItem();
    }


    private void InitGameItem() {
        setBackgroundColor(Color.GRAY);
        mTVNum = new TextView(getContext());
        setNum(mCardShowNum);
        //fix text size
        int gameLines = App.msp.getInt(App.KEY_GAME_LINES,4);
        if(gameLines==4){
            mTVNum.setTextSize(35);
        }else if (gameLines == 5) {
            mTVNum.setTextSize(25);
        } else {
            mTVNum.setTextSize(20);
        }

        TextPaint tp = mTVNum.getPaint();
        tp.setFakeBoldText(true);
        mTVNum.setGravity(Gravity.CENTER);
        mParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mParams.setMargins(5,5,5,5);
        addView(mTVNum,mParams);
    }

    public void setNum(int num) {
        this.mCardShowNum = num;
        if (num==0){
            mTVNum.setText("");
        }else {
            mTVNum.setText(""+num);
        }
        switch (num) {
            case 0:
                mTVNum.setBackgroundColor(0x00000000);
                break;
            case 2:
                mTVNum.setBackgroundColor(0xffeee5db);
                break;
            case 4:
                mTVNum.setBackgroundColor(0xffeee0ca);
                break;
            case 8:
                mTVNum.setBackgroundColor(0xfff2c17a);
                break;
            case 16:
                mTVNum.setBackgroundColor(0xfff59667);
                break;
            case 32:
                mTVNum.setBackgroundColor(0xfff68c6f);
                break;
            case 64:
                mTVNum.setBackgroundColor(0xfff66e3c);
                break;
            case 128:
                mTVNum.setBackgroundColor(0xffedcf74);
                break;
            case 256:
                mTVNum.setBackgroundColor(0xffedcc64);
                break;
            case 512:
                mTVNum.setBackgroundColor(0xffedc854);
                break;
            case 1024:
                mTVNum.setBackgroundColor(0xffedc54f);
                break;
            case 2048:
                mTVNum.setBackgroundColor(0xffedc32e);
                break;
            default:
                mTVNum.setBackgroundColor(0xff3c4a34);
                break;
        }

    }

    public int getNum(){
        return mCardShowNum;
    }

    public View getItemView(){
        return mTVNum;
    }
}
