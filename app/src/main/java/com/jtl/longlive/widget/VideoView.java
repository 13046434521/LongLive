package com.jtl.longlive.widget;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.jtl.ijklibrary.widget.media.IjkVideoView;

/**
 * @author：TianLong
 * @date：2020/10/30 17:58
 */
public class VideoView extends IjkVideoView {
    private AndroidMediaController mAndroidMediaController;

    public VideoView(Context context) {
        this(context,null);
    }

    public VideoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        mAndroidMediaController = new AndroidMediaController(context);
        this.addView(mAndroidMediaController.getRootView());
        this.setMediaController(mAndroidMediaController);
        mAndroidMediaController.show(500);
    }

    public void setUrl(@Nullable String url){
        this.setVideoURI(Uri.parse(url));
    }

    public void show(){
        mAndroidMediaController.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },500);
    }
}
