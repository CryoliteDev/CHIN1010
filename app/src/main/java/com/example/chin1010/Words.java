package com.example.chin1010;

public class Words {

    private String defaultTranslation;
    private String chineseTranslation;

    public Words(String defaultTranslation, String chineseTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.chineseTranslation = chineseTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getChineseTranslation() {
        return chineseTranslation;
    }

}
