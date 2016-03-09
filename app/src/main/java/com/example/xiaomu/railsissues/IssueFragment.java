package com.example.xiaomu.railsissues;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Xiaomu on 3/7/16.
 * This class is for an Issue's view on the screen.
 */
public class IssueFragment extends Fragment{
    private Issue mIssue;

    private EditText mTitleField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIssue = new Issue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_issue, parent, false);

        mTitleField = (EditText)v.findViewById(R.id.issue_title);
        return v;
    }
}
