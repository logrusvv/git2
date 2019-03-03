package vovik.java.webapp.web;

import vovik.java.webapp.model.MultiTextSection;
import vovik.java.webapp.model.Section;
import vovik.java.webapp.model.SectionType;
import vovik.java.webapp.model.TextSection;

import java.util.Collections;

import static vovik.java.webapp.web.HtmlUtil.input;
import static vovik.java.webapp.web.HtmlUtil.textArea;

/**
 * Vovik
 * 3/3/2019
 */

public enum SectionHtmlType {
    TEXT {
        @Override
        public String toHtml(Section section, SectionType type) {
            return input(type.name(), section == null ? "" : ((TextSection) section).getValue());
        }

        @Override
        public TextSection createSection(String value) {
            return new TextSection(value);
        }
    },
    MULTI_TEXT {
        @Override
        public String toHtml(Section section, SectionType type) {
            return textArea(type.name(), section == null ? Collections.singletonList("") :((MultiTextSection) section).getValues());
        }

        @Override
        public MultiTextSection createSection(String values) {
            return new MultiTextSection(values.split("\\n"));
        }
    },
    ORGANIZATION {
        @Override
        public String toHtml(Section section, SectionType type) {
            return section.toString();
        }

        @Override
        public Section createSection(String value) {
            throw new UnsupportedOperationException();
        }
    };

    public abstract String toHtml(Section section, SectionType type);

    public abstract Section createSection(String value);
}
