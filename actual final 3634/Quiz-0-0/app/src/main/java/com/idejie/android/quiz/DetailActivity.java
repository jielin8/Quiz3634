package com.idejie.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.idejie.android.quiz.models.Article;

public class DetailActivity extends AppCompatActivity {
    TextView tv_title;
    TextView tv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String title = bundle.getString("title");
        String content = bundle.getString("content");
        tv_title = findViewById(R.id.detail_title);
        tv_title.setText(title);
        tv_content = findViewById(R.id.detail_content);
        tv_content.setText(content);
    }
}
