package com.example.xiaomu.railsissues;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by xiaomu on 3/7/16.
 */
public class IssueListFragment extends ListFragment{
    private ArrayList<Issue> mIssues;
    private static final String TAG = "IssueListFragment";
    private static final int sleepTime = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.issues_title);
        while(IssueLab.get(getActivity()).getIssues().size() <= 0) {
            try {
                Thread.sleep(sleepTime);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        mIssues = IssueLab.get(getActivity()).getIssues();

        ArrayAdapter<Issue> adapter = new ArrayAdapter<Issue>(getActivity(),
                android.R.layout.simple_list_item_1, mIssues);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Issue i = (Issue) (getListAdapter()).getItem(position);
        //Toast.makeText(getActivity(), i.verboseMsg(),
                //Toast.LENGTH_LONG).show();
        //Log.d(TAG, i.getTitle() + " was clicked");
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("");
        alertDialog.setMessage(i.verboseMsg());
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
