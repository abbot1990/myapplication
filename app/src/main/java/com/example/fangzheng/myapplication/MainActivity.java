package com.example.fangzheng.myapplication;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity implements BlankFragment.OnFragmentInteractionListener,SecondFragment.OnFragmentInteractionListener{
    private static final String TAG = "branch_test";




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getRequest();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.container,new BlankFragment());
        ft.commit();

        Button btnTest = (Button)findViewById(R.id.btn_change);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container,new SecondFragment());
                ft.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * get request
     */
    private void getRequest(){
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = new String(response.body().bytes(),"utf-8");


                Log.i(TAG, "onResponse: "+res);
                Log.i(TAG, "onResponse: "+response.code());
                Log.i(TAG, "onResponse: "+response.body().contentLength());

                InputStream inputStream = response.body().byteStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //ImageView imageView = (ImageView)findViewById(R.id.image_view);
                        //imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    /**
     * post request
     */
    private void postRequest(){
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("name","jack");
        builder.add("pw","12");
        Request request = new Request.Builder().url("").post(builder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
