package com.example.chin1010;

public class Words {

    private String defaultTranslation;
    private String chineseTranslation;
    private int imgResourceID =  NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Words(String defaultTranslation, String chineseTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.chineseTranslation = chineseTranslation;
    }

    public Words(String defaultTranslation, String chineseTranslation, int imgResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.chineseTranslation = chineseTranslation;
        this.imgResourceID = imgResourceID;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getChineseTranslation() {
        return chineseTranslation;
    }

    public int getImgResourceID() {
        return imgResourceID;
    }

    /**
     * @returns whether or not there is an image.
     */
    public boolean hasImage() {
        return imgResourceID != NO_IMAGE_PROVIDED;
    }

}
