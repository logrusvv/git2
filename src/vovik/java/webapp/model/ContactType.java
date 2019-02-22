package vovik.java.webapp.model;

import java.io.Serializable;

/**
 * Vovik
 * 1/25/2019
 */

public enum ContactType implements Serializable {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"){
        @Override
        public String toHtml(String value){
            return "<a href='skype:" + value + "'>" + value + "</a>";
        }
    },
    VIBER("Почта"),
    MAIL("Viber"){
        @Override
        public String toHtml(String value){
            return "<a href='mailto:" + value + "'>" + value + "</a>";
        }
    };

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ContactType[] VALUES = ContactType.values();

    public String toHtml(String value){
        return title + ": " + value;
    }
}
