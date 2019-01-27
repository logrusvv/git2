package vovik.java.webapp.storage;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.Contact;
import vovik.java.webapp.model.ContactType;
import vovik.java.webapp.model.Resume;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Vovik
 * 1/27/2019
 */


public class ArrayStorageTest {
    private Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();



    @BeforeClass
    public static void beforeClass() {
        // the same as static {}
    }

    @Before
    public void before() {
        R1 = new Resume("Полное Имя1", "location1");
        R1.addContact((new Contact(ContactType.MAIL, "mail1@ya.ru")));
        R1.addContact(new Contact(ContactType.PHONE, "11111"));

        R2 = new Resume("Полное Имя2", null);
        R2.addContact((new Contact(ContactType.SKYPE, "skype2")));
        R2.addContact(new Contact(ContactType.PHONE, "22222"));

        R3 = new Resume("Полное Имя3", null);

        storage.clear();
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);
    }

    @org.junit.Test
    public void clear() {
    }

    @org.junit.Test
    public void save() {

    }

    @org.junit.Test
    public void update() {
//        Resume R4 = new Resume(R2);  // think about this realization

        R2.setFullName("Updated N2");
        storage.update(R2);
        assertEquals(R2, storage.load((R2.getUuid())));

    }

    @org.junit.Test
    public void load() {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @org.junit.Test(expected = WebAppException.class)
    public void testDeleteNotFound() throws Exception{
        storage.load("dummy");
    }

    @org.junit.Test
    public void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());

    }

    @org.junit.Test
    public void getAllSorted() {
        Resume[] src = new Resume[]{R1, R2, R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getAllSorted().toArray());
    }

    @org.junit.Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}
