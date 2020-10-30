package com.jtl.longlive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jtl.ijklibrary.widget.media.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.video_main_play);
        mVideoView.setUrl("rtmp://58.200.131.2:1935/livetv/hljtv");
        mVideoView.start();
    }

    private List initList(){
        String list = this.getString(R.string.list);
        ArrayList arrayList = new ArrayList<String>(16);

        String [] result = list.split(":");


        return arrayList;
    }
}