package com.idejie.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.idejie.android.quiz.adapters.LessonAdapter;
import com.idejie.android.quiz.models.Lesson;

import java.util.List;

public class SearchResultActivity extends AppCompatActivity {
    TextView result_tv;
    RecyclerView recyclerView;
    private LessonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        result_tv = findViewById(R.id.search_result_tv);
        recyclerView = findViewById(R.id.search_result_list);
        List<Lesson> lessons = (List<Lesson>) getIntent().getSerializableExtra("data");
        if (lessons==null){
            result_tv.setText("0 result searched");
        }else if(lessons.size()==0){
            result_tv.setText("0 result searched");
        }else {
            result_tv.setText(lessons.size()+" results searched");
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new LessonAdapter(this, lessons, new LessonAdapter.OnItemClickCallback<Lesson>() {
                @Override
                public void onClick(View view, Lesson info) {
                    Log.d("#Quiz","####"+info.lesson_name);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("title",info.lesson_name);
                    bundle.putString("content",info.lesson_content);
                    intent.putExtras(bundle);
                    intent.setClass(SearchResultActivity.this,DetailActivity.class);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        }
    }
}
