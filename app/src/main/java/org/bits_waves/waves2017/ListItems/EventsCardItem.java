package org.bits_waves.waves2017.ListItems;

public class EventsCardItem {
    private int mTextResource;
    private int mTitleResource;

    public EventsCardItem(int title, int text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public int getText() {
        return mTextResource;
    }

    public int getTitle() {
        return mTitleResource;
    }
}
