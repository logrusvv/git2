package vovik.java.webapp.storage;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import vovik.java.webapp.model.Contact;
import vovik.java.webapp.model.ContactType;
import vovik.java.webapp.model.Resume;

import static org.junit.Assert.*;

/**
 * Vovik
 * 1/27/2019
 */


public class ArrayStorageTest {
    private static Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();

    static {
        R1 = new Resume("Полное Имя1", "location1");
        R1.addContact((new Contact(ContactType.MAIL, "mail1@ya.ru")));
        R1.addContact(new Contact(ContactType.PHONE, "11111"));

        R1 = new Resume("Полное Имя2", null);
        R1.addContact((new Contact(ContactType.SKYPE, "skype2")));
        R1.addContact(new Contact(ContactType.PHONE, "22222"));

        R3 = new Resume("Поное Имя3", null);
    }

    @BeforeClass
    public static void beforeClass() {
        // the same as static {}
    }

    @Before
    public void before() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @org.junit.Test
    public void clear() {
    }

    @org.junit.Test
    public void save() {

    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void load() {
    }

    @org.junit.Test
    public void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
        Assert.assertEquals(null, storage.load(R1.getUuid()));
    }

    @org.junit.Test
    public void getAllSorted() {
    }

    @org.junit.Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}
