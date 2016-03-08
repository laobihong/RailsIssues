package com.example.xiaomu.railsissues;
import java.util.UUID;

/**
 * Created by xiaomu on 3/7/16.
 */
public class Issue {

    private UUID mId;
    private String mTitle;
    private String mBody;
    private String mAuthor;

    public Issue() {
        // generate unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String mBody) {
        this.mBody = mBody;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getFirst140() {
        if(mBody.length() > 140) {
            return mBody.substring(0, 140);
        }
        return mBody;
    }

    @Override
    public String toString() {
        return "Issue Title: " + mTitle + getAuthor() + "\n\n" + getFirst140();
    }

    public String verboseMsg() {
        return "Author: " + getAuthor() + "\n\nComplete message:\n" + getBody();
    }

}
