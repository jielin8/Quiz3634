package com.idejie.android.quiz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface IFragmentManager {
    FragmentManager getSupportFragmentManager();
    Fragment getSupportFragment();
}
