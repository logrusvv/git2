package vovik.java.webapp.model;

import vovik.java.webapp.web.SectionHtmlType;

/**
 * Vovik
 * 1/25/2019
 */

public enum SectionType {
    OBJECTIVE("Позиция", SectionHtmlType.TEXT),
    ACHIEVEMENT("Достижения", SectionHtmlType.MULTI_TEXT),
    QUALIFICATIONS("Квалификация", SectionHtmlType.MULTI_TEXT),
    EXPERIENCE("Опыт работы", SectionHtmlType.ORGANIZATION),
    EDUCATION("Образование", SectionHtmlType.ORGANIZATION);

    private String title;
    private SectionHtmlType htmlType;

    SectionType(String title, SectionHtmlType htmlType) {
        this.title = title;
        this.htmlType = htmlType;
    }

    public SectionHtmlType getHtmlType() {
        return htmlType;
    }

    public String getTitle() {
        return title;
    }
}
