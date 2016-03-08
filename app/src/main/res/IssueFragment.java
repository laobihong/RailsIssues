import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by xiaomu on 3/7/16.
 */
public class IssueFragment extends Fragment{
    private Issue mIssue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIssue = new Issue();
    }

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_issue, parent, false);
        return v;
    }
}
