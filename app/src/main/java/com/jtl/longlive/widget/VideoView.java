package com.jtl.longlive.widget;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.jtl.ijklibrary.widget.media.IjkVideoView;

/**
 * @author：TianLong
 * @date：2020/10/30 17:58
 */
public class VideoView extends IjkVideoView {
    private AndroidMediaController mAndroidMediaController;
    public VideoView(Context context) {
        this(context, null);
    }

    public VideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mAndroidMediaController = new AndroidMediaController(context);
        this.addView(mAndroidMediaController.getRootView());
        this.setMediaController(mAndroidMediaController);
        mAndroidMediaController.show();
    }

    public void setUrl(@Nullable String url) {
        this.setVideoURI(Uri.parse(url));
    }

    public void show() {
        mAndroidMediaController.show();
    }

    public void hide() {
        mAndroidMediaController.hide();
    }

    public void show(int time) {
        if (mAndroidMediaController.isShowing()){
            mAndroidMediaController.hide();
        }else{
            mAndroidMediaController.show(time);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        show(3000);
        return false;
    }

    public void setControllerBackListener(AndroidMediaController.ControllerBackListener controllerBackListener) {
        mAndroidMediaController.setControllerBackListener(controllerBackListener);
    }

    public void setControllerPlayListener(AndroidMediaController.ControllerPlayListener controllerPlayListener) {
        mAndroidMediaController.setControllerPlayListener(controllerPlayListener);
    }

    public void setControllerScreenListener(AndroidMediaController.ControllerScreenListener controllerScreenListener) {
        mAndroidMediaController.setControllerScreenListener(controllerScreenListener);
    }
}
