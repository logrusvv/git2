package lesson3;

import vovik.java.webapp.model.ContactType;
import vovik.java.webapp.model.Link;

import java.lang.reflect.Field;

/**
 * Vovik
 * 1/25/2019
 */

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //Contact c = new Contact(ContactType.PHONE,"113131");

        Field f = Link.class.getDeclaredField("url");
        f.setAccessible(true);
        Link l = new Link("dddd","URL");
        System.out.println(f.get(l));

        //System.out.println(l.getClass().isInstance(Link.class));

        String a1 = "Ja"+"va";
        String a2 = "Java";
        System.out.println(a1+a2);

        Integer b1 = 10000;
        Integer b2 = 10000;

        System.out.println(b1==b2);

        StringBuilder fill = new StringBuilder();

        for (int i=0; i<10; i++){
            fill.append("a");
        }
        System.out.println(fill.toString());
    }
}
