package com.jtl.ijklibrary.widget.media;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.net.URI;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * @author：TianLong
 * @date：2020/10/30 17:58
 */
public class VideoView extends IjkVideoView{


    public VideoView(Context context) {
        super(context);
    }

    public VideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initIjk(){
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        AndroidMediaController controller = new AndroidMediaController(this.getContext(),false);
        this.setMediaController(controller);
    }

    public void setUrl(@Nullable String url){
        this.setVideoURI(Uri.parse(url));
    }
}
