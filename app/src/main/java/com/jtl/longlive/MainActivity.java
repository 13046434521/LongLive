package com.jtl.longlive;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jtl.longlive.widget.AndroidMediaController;
import com.jtl.longlive.widget.VideoView;

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
            //APP进入后台时，是否暂停申请视频实时流数据
//            mVideoView.stopPlayback();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStatusNavigation();
        mVideoView.resume();
        mVideoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.release(true);
    }

    //隐藏状态栏和导航栏，可以拉出，自动收起
    public void setStatusNavigation() {
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}