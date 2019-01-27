package lesson3;

import vovik.java.webapp.model.Link;
import vovik.java.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

/**
 * Vovik
 * 1/27/2019
 */

public class MainArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        System.out.println(array.length);
        System.out.println(array.getClass());
        System.out.println(Arrays.toString(array));

        Resume[] resumes = new Resume[10];
        System.out.println(resumes.length);
        System.out.println(resumes.getClass());

//        Link l = new Link();
//        ((Object[]) resumes)[0] = l;
    }
}
