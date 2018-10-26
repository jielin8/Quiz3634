package com.idejie.android.quiz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.idejie.android.quiz.R;
import com.idejie.android.quiz.models.Lesson;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.MyViewHolder> {
    private List<Lesson> lessons;
    Context context;
    // item条目布局注入器
    private LayoutInflater mInflater;
    // 申明一个点击事件接口变量
    private OnItemClickCallback callback = null;
    public  LessonAdapter(Context context,List<Lesson> lessons,OnItemClickCallback clickCallback){
        this.context=context;
        this.lessons=lessons;
        this.callback = clickCallback;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_lesson_list_item,viewGroup,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Lesson lesson = lessons.get(i);
        Log.i("#Quiz:LessonAdapter","#"+context.toString()+"#load lesson " + i +":"+lesson.lesson_pic);
        Glide.with(context).load(lesson.lesson_pic).into(myViewHolder.picView);
        myViewHolder.titleView.setText(lesson.lesson_name);
        myViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(v,lesson);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemLayout;
        ImageView picView;
        TextView titleView;
        public  MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.item_lesson);
            picView = itemView.findViewById(R.id.pic_lesson);
            titleView = itemView.findViewById(R.id.title_lesson);
        }
    }
    public interface OnItemClickCallback<T> {
        // click callback
        void onClick(View view , T info);

    }
}
