package com.jtl.longlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jtl.ijklibrary.widget.media.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.video_main_play);
        Intent intent =getIntent();
        String url = intent.getStringExtra("Url");
        Log.d(TAG,"url:"+url);
        mVideoView.setUrl(url);
//        mVideoView.setUrl("rtmp://58.200.131.2:1935/livetv/cctv4");
        mVideoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoView.canPause();
        mVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.release(true);
    }
}