package com.idejie.android.quiz.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.idejie.android.quiz.R;
import com.idejie.android.quiz.fragments.ArticleFragment;
import com.idejie.android.quiz.models.Article;
import com.idejie.android.quiz.models.Lesson;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    Context context;
    List<Article> articles;
    // layout inflater
    private LayoutInflater mInflater;
    //declaring click event interface variable click callback
    private OnItemClickCallback callback = null;
    public ArticleAdapter(Context context, List<Article> articles,OnItemClickCallback clickCallback) {
        this.context = context;
        this.articles = articles;
        this.callback = clickCallback;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_article_list_item,viewGroup,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Article article = articles.get(i);
        Glide.with(context).load(article.article_pic).into(myViewHolder.pic);
        myViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(v,article);
            }
        });
        myViewHolder.title.setText(article.article_title);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView title;
        View item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item_article);
            pic = itemView.findViewById(R.id.articles_pic);
            title = itemView.findViewById(R.id.articles_title);
        }
    }
    public interface OnItemClickCallback<T> {
        //clickEvent
        void onClick(View view , T info);

    }


}
