package com.idejie.android.quiz.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.idejie.android.quiz.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView image;
    public TextView title;
    public TextView description;
    public FrameLayout videoContainer;

    public VideoViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        videoContainer = itemView.findViewById(R.id.video_container);
    }
}
