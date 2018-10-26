package com.idejie.android.quiz.models;

import android.os.Parcel;
import android.os.Parcelable;



public class Article implements Parcelable {

    public int article_id;
    public String article_pic;
    public String article_title;
    public String article_content;

    protected Article(Parcel in) {
        article_id = in.readInt();
        article_pic = in.readString();
        article_title = in.readString();
        article_content = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_pic() {
        return article_pic;
    }

    public void setArticle_pic(String article_pic) {
        this.article_pic = article_pic;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Article(int article_id, String article_pic, String article_title, String article_content) {

        this.article_id = article_id;
        this.article_pic = article_pic;
        this.article_title = article_title;
        this.article_content = article_content;
    }

    public Article() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(article_id);
        dest.writeString(article_pic);
        dest.writeString(article_title);
        dest.writeString(article_content);
    }
}
