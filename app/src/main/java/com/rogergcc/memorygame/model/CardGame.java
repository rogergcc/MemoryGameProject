package com.rogergcc.memorygame.model;

import android.graphics.Bitmap;

public class CardGame {
    private String Name;
    private String Image;
    private Bitmap bitmapImage;
    private String key;

    public CardGame() {
    }

    public CardGame(String name, String image) {
        Name = name;
        Image = image;
    }

    public CardGame(String name) {

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBitmapImage(Bitmap bitmapImage) {
        this.bitmapImage = bitmapImage;
    }

    public Bitmap getBitmapImage() {
        return bitmapImage;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
