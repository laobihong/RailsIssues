import android.support.v4.app.ListFragment;

import java.util.ArrayList;

/**
 * Created by xiaomu on 3/7/16.
 */
public class IssueListFragment extends ListFragment{
    private ArrayList<Issue> mIssues;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.issue_title);
        mIssues = IssueLab.get(getActivity()).getIssues();
    }
}
