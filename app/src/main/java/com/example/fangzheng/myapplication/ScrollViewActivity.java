package com.example.fangzheng.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ScrollViewActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scroll_view);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData());

    ListView listView = (ListView)findViewById(R.id.test_list_view_1);
    listView.setAdapter(adapter);

    ListView listView2 = (ListView)findViewById(R.id.test_list_view_2);
    listView2.setAdapter(adapter);
  }

  private ArrayList<String> getData(){
    ArrayList<String> list = new ArrayList<>();
    for(int i=0;i<10;i++){
      list.add("ggg"+i);
    }

  return list;
  }
}
