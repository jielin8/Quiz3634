package com.idejie.android.quiz.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyTextureView extends TextureView implements TextureView.SurfaceTextureListener{
    private static final String TAG = "MyTextureView";

    private String playingUrl = "";

    private MediaPlayer mMediaPlayer;
    private Surface surface;
    private MediaPlayer.OnPreparedListener preparedListener;
    private MediaPlayer.OnErrorListener errorListener;
    private MediaPlayer.OnCompletionListener completionListener;
    private MediaPlayer.OnInfoListener infoListener;
    private MediaPlayer.OnSeekCompleteListener seekCompleteListener;

    public MyTextureView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setSurfaceTextureListener(this);
    }

    public MyTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }



    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        initMediaPlayer(surface);
    }

    private int initMediaPlayer(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null)
            return 1;

        try {
            if (mMediaPlayer == null) {
                mMediaPlayer = new MediaPlayer();
                Log.e(TAG, " initMediaPlayer new media");
            }
            surface = new Surface(surfaceTexture);
            mMediaPlayer.setSurface(surface);
            Log.e(TAG, " initMediaPlayer Success");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, " initMediaPlayer-" + e.getMessage());
            return -1;
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void setOnClickListener( View.OnClickListener l) {
        super.setOnClickListener(l);
    }

    public void startPlay() {
        if (mMediaPlayer != null) {
            mMediaPlayer.start();
            Log.e(TAG, "startPlay");
        } else {
            Log.e(TAG, "start Error media is null");
        }
    }

    public void pausePlay() {
        if (mMediaPlayer != null) {
            mMediaPlayer.pause();
            Log.e(TAG, "stopPlay");
        } else {
            Log.e(TAG, "pause Error media is null");
        }
    }

    public void resetPlay() {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
            Log.e(TAG, "resetPlay");
        } else {
            Log.e(TAG, "reset Error media is null");
        }
    }


    public void destory() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }


    public void setUrl(String path) {
        if (!playingUrl.equals(path)) {
            mMediaPlayer.reset();
            try {
                playingUrl = path;
                if (path.contains("http")) {
                    mMediaPlayer.setDataSource(path);
                } else {
                    FileInputStream fis = null;
                    fis = new FileInputStream(new File(path));
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_RING);
                    mMediaPlayer.setDataSource(fis.getFD());
                }
                mMediaPlayer.prepareAsync();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            mMediaPlayer.start();
        }
        if(preparedListener != null) {
            mMediaPlayer.setOnPreparedListener(preparedListener);
        }
    }
}
