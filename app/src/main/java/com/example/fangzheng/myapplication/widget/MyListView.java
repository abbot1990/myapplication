package com.example.fangzheng.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by fangzheng on 2017/6/27.
 */

public class MyListView extends ListView implements View.OnTouchListener,GestureDetector.OnGestureListener{
  private GestureDetector gestureDetector;

  private OnDeleteListener deleteListener;

  private boolean isDeleteShow;
  private View deleteButton;
  private ViewGroup itemLayout;


  public MyListView(Context context,AttributeSet attrs){
    super(context,attrs);
    gestureDetector = new GestureDetector(getContext(),this);
    setOnTouchListener(this);
    View
  }

  public void setDeleteListener(OnDeleteListener deleteListener) {
    this.deleteListener = deleteListener;
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    if(isDeleteShow)
    return false;
  }


  @Override
  public boolean onDown(MotionEvent e) {
    return false;
  }

  @Override
  public void onShowPress(MotionEvent e) {

  }

  @Override
  public boolean onSingleTapUp(MotionEvent e) {
    return false;
  }

  @Override
  public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    return false;
  }

  @Override
  public void onLongPress(MotionEvent e) {

  }

  @Override
  public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    return false;
  }


  public interface OnDeleteListener{
    void onDelete(int index);
  }
}
