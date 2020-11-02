package com.jtl.longlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.jtl.ijklibrary.widget.media.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private VideoView mVideoView;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.video_main_play);
        mToolbar = findViewById(R.id.tool_main_show);
        setSupportActionBar(mToolbar);
        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");
        String name = intent.getStringExtra("Name");
        Log.d(TAG, "url:" + url);
        mVideoView.setUrl(url);
        mToolbar.setTitle(name);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoView.canPause()) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.resume();
        mVideoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.release(true);
    }
}