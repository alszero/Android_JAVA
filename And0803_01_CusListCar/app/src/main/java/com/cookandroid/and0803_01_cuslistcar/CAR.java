package com.cookandroid.and0803_01_cuslistcar;

import android.graphics.drawable.Drawable;

public class CAR {
    private Drawable image;
    private String title;

    public CAR(Drawable image, String title) {
        this.image = image;
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }
    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
