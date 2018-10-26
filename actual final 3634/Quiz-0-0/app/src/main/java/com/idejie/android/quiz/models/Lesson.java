package com.idejie.android.quiz.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Lesson implements Parcelable {
    public int lesson_id;
    public String lesson_name;
    public String lesson_pic;
    public String lesson_content;

    public Lesson() {
    }

    public Lesson(int lesson_id, String lesson_name, String lesson_pic, String lesson_content) {
        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
        this.lesson_pic = lesson_pic;
        this.lesson_content = lesson_content;
    }

    protected Lesson(Parcel in) {
        lesson_id = in.readInt();
        lesson_name = in.readString();
        lesson_pic = in.readString();
        lesson_content = in.readString();
    }

    public static final Creator<Lesson> CREATOR = new Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public String getLesson_pic() {
        return lesson_pic;
    }

    public void setLesson_pic(String lesson_pic) {
        this.lesson_pic = lesson_pic;
    }

    public String getLesson_content() {
        return lesson_content;
    }

    public void setLesson_content(String lesson_content) {
        this.lesson_content = lesson_content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lesson_id);
        dest.writeString(lesson_name);
        dest.writeString(lesson_pic);
        dest.writeString(lesson_content);
    }
}
