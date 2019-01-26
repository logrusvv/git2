package lesson3;

import vovik.java.webapp.model.Contact;
import vovik.java.webapp.model.ContactType;
import vovik.java.webapp.model.Link;

import java.lang.reflect.Field;

/**
 * Vovik
 * 1/25/2019
 */

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Contact c = new Contact(ContactType.PHONE,"113131");

        Field f = Link.class.getDeclaredField("url");
        f.setAccessible(true);
        Link l = new Link("dddd","URL");
        System.out.println(f.get(l));
    }
}
