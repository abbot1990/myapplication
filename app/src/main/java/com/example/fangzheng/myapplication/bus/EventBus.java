package com.example.fangzheng.myapplication.bus;

import com.squareup.otto.Bus;

/**
 * Created by fangzheng on 2017/6/23.
 */

public class EventBus extends Bus{

  private static EventBus bus;
  private EventBus(){}

  public static EventBus getInstance(){
    if (bus == null) {
      bus = new EventBus();
    }
    return bus;
  }
}
