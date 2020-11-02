/*
 * Copyright (C) 2015 Bilibili
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jtl.longlive.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jtl.ijklibrary.widget.media.IMediaController;
import com.jtl.longlive.R;

public class AndroidMediaController extends FrameLayout implements IMediaController, View.OnClickListener {
    private ImageView mPlayImage;
    private ImageView mBackImage;
    private ImageView mScreenImage;
    public ControllerBackListener mControllerBackListener;
    public ControllerPlayListener mControllerPlayListener;
    public ControllerScreenListener mControllerScreenListener;
    private Context mContext;
    private boolean isShowing = false;
    public AndroidMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AndroidMediaController(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_media_controller, this,true);
        mBackImage = view.findViewById(R.id.iv_media_back);
        mPlayImage = view.findViewById(R.id.iv_media_play);
        mScreenImage = view.findViewById(R.id.iv_media_screen);

        mBackImage.setOnClickListener(this::onClick);

        mPlayImage.setOnClickListener(this::onClick);

        mScreenImage.setOnClickListener(this::onClick);
    }

    @Override
    public void hide() {
        this.setVisibility(GONE);
        setStatusNavigation();
    }

    @Override
    public boolean isShowing() {
        return isShowing;
    }

    @Override
    public void show(int timeout) {
        AndroidMediaController mediaController = this;
        if (!isShowing()){
            mediaController.setVisibility(VISIBLE);
            isShowing = true;

            this.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mediaController.setVisibility(GONE);
                    isShowing = false;
                }
            },timeout);
        }
    }

    @Override
    public void show() {
        this.setVisibility(VISIBLE);
    }

    public void setStatusNavigation() {
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = ((Activity)mContext).getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public void setControllerBackListener(ControllerBackListener controllerBackListener) {
        mControllerBackListener = controllerBackListener;
    }

    public void setControllerPlayListener(ControllerPlayListener controllerPlayListener) {
        mControllerPlayListener = controllerPlayListener;
    }

    public void setControllerScreenListener(ControllerScreenListener controllerScreenListener) {
        mControllerScreenListener = controllerScreenListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_media_back:
                if (mControllerBackListener!=null){
                    mControllerBackListener.backListener();
                }
                break;
            case R.id.iv_media_play:
                if (mControllerPlayListener!=null){
                    mControllerPlayListener.playListener();
                }
                break;
            case R.id.iv_media_screen:
                if (mControllerScreenListener!=null){
                    mControllerScreenListener.screenListener();
                }
                break;
            default:
                break;
        }
    }

    public interface ControllerBackListener{
       void backListener();
    }

    public interface ControllerPlayListener{
        void playListener();
    }

    public interface ControllerScreenListener{
        void screenListener();
    }
}
