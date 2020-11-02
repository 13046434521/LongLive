package com.jtl.longlive;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jtl.longlive.widget.AndroidMediaController;
import com.jtl.longlive.widget.VideoView;

public class MainActivity extends AppCompatActivity implements AndroidMediaController.ControllerBackListener, AndroidMediaController.ControllerScreenListener {
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
        mVideoView.setControllerBackListener(this::backListener);
        mVideoView.setControllerScreenListener(this::screenListener);
        mToolbar.setTitle(name);
        mVideoView.show();
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("translate","翻跟斗");
    }

    @Override
    public void backListener() {
        finish();
    }

    @Override
    public void screenListener() {
        Configuration configuration = getResources().getConfiguration();
        // 当前是横屏
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i(TAG, "设为竖屏");
            MainActivity.this
                    .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            Log.i(TAG, "设为横屏");
            MainActivity.this
                    .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}