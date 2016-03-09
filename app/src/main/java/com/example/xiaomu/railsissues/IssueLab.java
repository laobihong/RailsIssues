package com.example.xiaomu.railsissues;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Xiaomu on 3/7/16.
 * The IssueLab fetches the issues from
 * https://api.github.com/repos/rails/rails/issues
 * then it parses the JSON objects and stores the
 * information, e.g. issue title, author and body
 * into the Issue instances for further usage.
 */
public class IssueLab {
    private ArrayList<Issue> mIssues;

    private static IssueLab sIssueLab;
    private Context mAppContext;

    private IssueLab(Context appContext){
        mAppContext = appContext;
        mIssues = new ArrayList<Issue>();
        try {
            new FetchIssuesTask().execute().wait();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class FetchIssuesTask extends AsyncTask<String, Void, ArrayList<Issue>> {

        protected ArrayList<Issue> doInBackground(String... urls) {
            try {
                URL url = new URL("https://api.github.com/repos/rails/rails/issues");
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String strTemp = "";
                String jsonString = "";
                while (null != (strTemp = br.readLine())) {
                    jsonString += strTemp;
                }

                JSONArray ja = new JSONArray(jsonString);
                for(int i = 0; i < ja.length(); i++) {
                    JSONObject jo = ja.getJSONObject(i);
                    Issue issue = new Issue();
                    issue.setTitle(jo.getString("title"));
                    issue.setBody(jo.getString("body"));
                    issue.setAuthor(jo.getJSONObject("user").getString("login"));
                    mIssues.add(issue);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return mIssues;
        }
    }

    public static IssueLab get(Context c) {
        if(sIssueLab == null) {
            sIssueLab = new IssueLab(c.getApplicationContext());
        }
        return sIssueLab;
    }

    public ArrayList<Issue> getIssues() {
        return mIssues;
    }

    public Issue getIssue(UUID id) {
        for(Issue i : mIssues) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
}
