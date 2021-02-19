package com.adnanabouelenein.sharzadcleaningcenter.data.infoadapter;

public class InfoModel {

    private String title;
    private String info;
    private int image;

    public InfoModel(String title, String info, int image) {
        this.title = title;
        this.info = info;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImage() {
        return image;
    }
}
