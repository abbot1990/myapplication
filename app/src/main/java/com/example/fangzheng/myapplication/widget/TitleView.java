package com.example.fangzheng.myapplication.widget;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fangzheng.myapplication.R;

/**
 * Created by fangzheng on 2017/6/27.
 */

public class TitleView extends FrameLayout{

  private ImageView titleIcon;
  private TextView titleContent;
  public TitleView(final Context context,AttributeSet attrs){
    super(context,attrs);
    LayoutInflater.from(context).inflate(R.layout.custom_title,this);
    titleIcon = (ImageView)findViewById(R.id.iv_close);
    titleContent = (TextView)findViewById(R.id.tv_title);

    titleIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ((Activity)getContext()).finish();
      }
    });

  }

 public void setText(String title){
   titleContent.setText(title);
 }

}
