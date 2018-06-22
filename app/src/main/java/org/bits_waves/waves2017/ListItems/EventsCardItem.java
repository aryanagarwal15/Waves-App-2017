package org.bits_waves.waves2017.ListItems;

public class EventsCardItem {
    private int mTextResource;
    private int mTitleResource;
    private String imgUrl;

    public EventsCardItem(int title) {
        mTitleResource = title;
        imgUrl = "https://img.freepik.com/free-vector/modern-dark-texture-background_1035-11632.jpg?size=338&ext=jpg";
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
