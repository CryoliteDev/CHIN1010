package com.example.chin1010;

public class Words {

    private String defaultTranslation;
    private String chineseTranslation;
    private int imgResourceID =  NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceID;

    public Words(String defaultTranslation, String chineseTranslation, int mAudioResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.chineseTranslation = chineseTranslation;
        this.mAudioResourceID = mAudioResourceID;
    }

    public Words(String defaultTranslation, String chineseTranslation, int imgResourceID, int mAudioResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.chineseTranslation = chineseTranslation;
        this.imgResourceID = imgResourceID;
        this.mAudioResourceID = mAudioResourceID;
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

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

    /**
     * @returns whether or not there is an image.
     */
    public boolean hasImage() {
        return imgResourceID != NO_IMAGE_PROVIDED;
    }


    @Override
    public String toString() {
        return "Words{" +
                "defaultTranslation='" + defaultTranslation + '\'' +
                ", chineseTranslation='" + chineseTranslation + '\'' +
                ", imgResourceID=" + imgResourceID +
                ", mAudioResourceID=" + mAudioResourceID +
                '}';
    }
}
