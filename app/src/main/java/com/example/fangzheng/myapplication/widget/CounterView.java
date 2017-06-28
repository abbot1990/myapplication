package com.example.fangzheng.myapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by fangzheng on 2017/6/27.
 */

public class CounterView extends View implements View.OnClickListener{

  private static final String TAG = "CounterView";
  private int mCount;
  private Paint mPaint;
  private Rect mBounds;

  public CounterView(Context context,AttributeSet attrs){
    super(context,attrs);
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mBounds = new Rect();
    setOnClickListener(this);


  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    mPaint.setColor(Color.BLACK);
    canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

    Log.i(TAG, "CounterView: rect width "+mBounds.width());
    Log.i(TAG, "CounterView: view width "+getWidth());

    mPaint.setColor(Color.BLUE);
    mPaint.setTextSize(30);
    String text = String.valueOf(mCount);
    mPaint.getTextBounds(text,0,text.length(),mBounds);
    int textWidth = mBounds.width();
    int textHeight = mBounds.height();
    canvas.drawText(text,getWidth()/2-textWidth,getHeight()/2-textHeight,mPaint);


    canvas.drawLine(0,0,mCount*2,mCount*2,mPaint);
  }

  @Override
  public void onClick(View v) {
    mCount++;
    invalidate();
  }
}
