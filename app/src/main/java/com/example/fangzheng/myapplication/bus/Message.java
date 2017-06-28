package com.example.fangzheng.myapplication.bus;

/**
 * Created by fangzheng on 2017/6/23.
 */

public class Message {
  String content;

  public Message(String content){
    this.content = content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }
}
