package com.idejie.android.quiz.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idejie.android.quiz.IFragmentManager;
import com.idejie.android.quiz.R;
import com.idejie.android.quiz.adapters.YouTubeAdapter;
import com.idejie.android.quiz.models.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment implements IFragmentManager {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private RecyclerView recyclerView;
    YouTubeAdapter adapter;
    float scale;

    public VideoFragment() {

        adapter = new YouTubeAdapter(this);
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static VideoFragment newInstance(int columnCount) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scale = getResources().getDisplayMetrics().density;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.videos_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int adapterPosition = parent.getChildAdapterPosition(view);
                if (adapterPosition == 0) {
                    outRect.top = (int) (4 * scale);
                }
                outRect.bottom = (int) (10 * scale);
            }
        });

        List<Video> videos = getVideos();
        adapter.setVideos(videos);
        recyclerView.setAdapter(adapter);
    }

    private List<Video> getVideos() {
        List<Video> videos = new ArrayList<>();
        Video v0 = new Video(Uri.parse("https://www.youtube.com/watch?v=cp2rL3sAFmI&t=173s").getQueryParameter("v"), "Introduction", "An Introduction to SQLite");
        videos.add(v0);
        Video v1 = new Video(Uri.parse("https://www.youtube.com/watch?v=p8TaTgr4uKM").getQueryParameter("v"), "SQLite: Creating DB & Tables", "Creating Databases and Tables in SQLite");
        videos.add(v1);
        Video v2 = new Video(Uri.parse("https://www.youtube.com/watch?v=T0ClYrJukPA&index=3&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07").getQueryParameter("v"), "SQLite:DB Table Values", "Tables Values in Android Database using SQLite");
        videos.add(v2);
        Video v3 = new Video(Uri.parse("https://www.youtube.com/watch?v=KUq5wf3Mh0c&index=4&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07").getQueryParameter("v"), "SQLite: Showing Table Values ", "Browse SQLite data on the Android Emulator ");
        videos.add(v3);
        Video v4 = new Video(Uri.parse("https://www.youtube.com/watch?v=PA4A9IesyCg&list=PLS1QulWo1RIaRdy16cOzBO5Jr6kEagA07&index=5").getQueryParameter("v"), "SQLite:Update Values in DB", "Android SQLite Update Values");
        videos.add(v4);
        Video v5 = new Video(Uri.parse("https://www.youtube.com/watch?v=-4GgzqMVrYc").getQueryParameter("v"), "Content Providers: Introduction", "A Quick Introduction to Content Providers");
        videos.add(v5);
        Video v6 = new Video(Uri.parse("https://www.youtube.com/watch?v=eNW1d8tiXmQ").getQueryParameter("v"), "Content Resolver & Cursor", "A Look at Content Resolvers and Cursors.");
        videos.add(v6);
        Video v7 = new Video(Uri.parse("https://www.youtube.com/watch?v=ulYgU2rP8Gk").getQueryParameter("v"), "Loader & CursorLoader.", "A detailed look into Loaders and CursorLoaders.");
        videos.add(v7);
        Video v8 = new Video(Uri.parse("https://www.youtube.com/watch?v=-4GgzqMVrYc&t=1s").getQueryParameter("v"), "Content Providers: CRUD", "A final look into Content Providers and their relevance to CRUD.");
        videos.add(v8);
        return videos;
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return getFragmentManager();
    }

    @Override
    public Fragment getSupportFragment() {
        return this;
    }
}