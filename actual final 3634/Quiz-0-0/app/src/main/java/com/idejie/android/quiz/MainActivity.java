package com.idejie.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.idejie.android.quiz.adapters.MainAdapter;
import com.idejie.android.quiz.fragments.LessonFragment;
import com.idejie.android.quiz.models.Lesson;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlphaTabsIndicator alphaTabsIndicator;
    private  ViewPager mViewPager;
    Button btn_search;
    EditText et_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        Log.i("#Quiz:MainActivity","app start");
        mViewPager = findViewById(R.id.mViewPager);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter( mainAdapter);
        mViewPager.addOnPageChangeListener(mainAdapter);
        alphaTabsIndicator = findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(mViewPager);

        alphaTabsIndicator.getTabView(0);
        alphaTabsIndicator.getTabView(1);
        alphaTabsIndicator.getTabView(2);
        alphaTabsIndicator.getTabView(3);
        Log.i("#Quiz:MainActivity","tab-view appear");
        btn_search = findViewById(R.id.search_btn);
        et_search = findViewById(R.id.search_view);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Q = String.valueOf(et_search.getText());
                if (Q.equals("")||Q==null){
                   Log.d("#Quiz","Q is null");
                }else {
                    List<Lesson> lessons = LessonFragment.getLessons();
                    List<Lesson>rets = new ArrayList<>();
                    for (Lesson l:lessons){
                        if (l.lesson_name.indexOf(Q)!=-1||l.lesson_content.indexOf(Q)!=-1){
                            rets.add(l);

                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtra("data", (Serializable) rets);
                    intent.setClass(MainActivity.this,SearchResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
