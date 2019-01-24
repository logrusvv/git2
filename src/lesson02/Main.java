package lesson02;

import vovik.java.webapp.model.Link;

/**
 * Vovik
 * 1/23/2019
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
//      main(null);
/*
        Link l1 = new Link("JavaWebinar", "javawebinar.ru");
        Link l2 = l1;
        Link l3 = new Link(l1);
        System.out.println(l1.getClass());
        System.out.println(l1.getClass().getClass());
        System.out.println(l1.getClass().getClass().getClass());
        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));
        System.out.println(l1);
*/
//        System.out.println(Link.empty());
//         m.printInt(5);

        Integer obj = null;
        printInt(obj);
    }
/*
    static void printInt(Integer obj) {
        System.out.println("Object " + obj);
    }
*/

    static void printInt(int obj) {
        System.out.println(obj);
    }
}
