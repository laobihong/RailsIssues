package com.example.xiaomu.railsissues;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Xiaomu on 3/7/16.
 * This class is for displaying a list of issue.
 */
public class IssueListActivity extends FragmentActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new IssueListFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment).commit();
        }
    }
}
