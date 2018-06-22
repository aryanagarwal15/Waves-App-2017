package org.bits_waves.waves2017.ListItems;

public class EventsCardItem {
    private int mTextResource;
    private int mTitleResource;
    private String imgUrl;

    public EventsCardItem(int title) {
        mTitleResource = title;
    }

    public int getText() {
        return mTextResource;
    }

    public int getTitle() {
        return mTitleResource;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
