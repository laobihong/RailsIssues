import java.util.UUID;

/**
 * Created by xiaomu on 3/7/16.
 */
public class Issue {

    private UUID mId;
    private String mTitle;

    public Issue() {
        // generate unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

}
