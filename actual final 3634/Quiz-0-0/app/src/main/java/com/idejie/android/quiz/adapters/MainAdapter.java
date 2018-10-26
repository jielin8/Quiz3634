package com.idejie.android.quiz.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.idejie.android.quiz.fragments.ArticleFragment;
import com.idejie.android.quiz.fragments.LessonFragment;
import com.idejie.android.quiz.fragments.QuizFragment;
import com.idejie.android.quiz.fragments.VideoFragment;

public class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    LessonFragment lessonFragment;
    VideoFragment videoFragment;
    ArticleFragment articleFragment;
    QuizFragment quizFragment;
    public MainAdapter(FragmentManager fm) {
        super(fm);
        lessonFragment = LessonFragment.newInstance(1);
        videoFragment = VideoFragment.newInstance(1);
        articleFragment = ArticleFragment.newInstance(1);
        quizFragment = QuizFragment.newInstance(1);
    }

    @Override
    public Fragment getItem(int i) {
       if (3==i)
           return quizFragment;
       else if (2==i)
           return articleFragment;
       else  if (1==i)
           return videoFragment;
       else
           return lessonFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
