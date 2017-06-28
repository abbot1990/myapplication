package com.example.fangzheng.myapplication.bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.fangzheng.myapplication.R;
import com.example.fangzheng.myapplication.bus.EventBus;
import com.example.fangzheng.myapplication.bus.Message;
import com.squareup.otto.Subscribe;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener{
  private static final String TAG = "EventBusActivity";
  private TextView textView;

  private EventBus eventBus;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_bus);

    eventBus = EventBus.getInstance();

    textView = (TextView)findViewById(R.id.tv_message);

    findViewById(R.id.btn_test_bus).setOnClickListener(this);
    findViewById(R.id.btn_test_bus2).setOnClickListener(this);

    EventBus.getInstance().register(this);

  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btn_test_bus:
        Log.i(TAG, "onClick:");
        eventBus.post(new Message("hello"));

        break;
      case R.id.btn_test_bus2:
        eventBus.post(new Message("world"));
        break;
      default:
        break;
    }
  }

  @Subscribe
  public void setContent(Message message){
    Log.i(TAG, "setContent: subscribe");
    textView.setText(message.getContent());
  }
}
