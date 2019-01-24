package lesson02;

import vovik.java.webapp.model.Link;

/**
 * Vovik
 * 1/23/2019
 */

public class Main {
    public static void main(String[] args) {
        Link l1 = new Link("JavaWebinar", "javawebinar.ru");
        Link l2 = l1;
        Link l3 = new Link(l1);
        System.out.println(l1.getClass());
        System.out.println(l1.getClass().getClass());
        System.out.println(l1.getClass().getClass().getClass());
        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));
        System.out.println(l1);
    }
}
