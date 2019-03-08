package vovik.java.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.*;

import java.util.Arrays;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Vovik
 * 2/1/2019
 */

abstract public class AbstractStorageTest {

    public static final String FILE_STORAGE = "./file_storage";
    private Resume R1, R2, R3;

    protected IStorage storage;



    @BeforeClass
    public static void beforeClass() {
        // the same as static {}
    }


    @Before
    public void before() {
        R1 = new Resume("Полное Имя1", "location1");
        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");
        R2 = new Resume("Полное Имя2", "Location1");
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        R3 = new Resume("Полное Имя3", "");
        if (storage.isSectionSupported()) {
            R1.addObjective("Objective1");
            R1.addMultiTextSection(SectionType.ACHIEVEMENT, "Achivment11", "Achivment12");
            R1.addMultiTextSection(SectionType.QUALIFICATIONS, "Java", "SQL");
            R1.addOrganizationSection(SectionType.EXPERIENCE,
                    new Organization("Organization11", null,
                            new Organization.Period(LocalDate.of(2005, Month.JANUARY, 1), Organization.Period.NOW, "position1", "content1"),
                            new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2")));
            R1.addOrganizationSection(SectionType.EDUCATION,
                    new Organization("Institute", null,
                            new Organization.Period(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                            new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                    new Organization("Organization12", "http://Organization12.ru"));
        }
        storage.clear();
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);
    }


    @org.junit.Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @org.junit.Test
    public void update() throws Exception {
        R2.setFullName("Updated N2");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @org.junit.Test
    public void load() throws Exception {
        Resume load = storage.load(R1.getUuid());
        assertEquals(R1, load);
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @org.junit.Test(expected = WebAppException.class)
    public void testDeleteNotFound() throws Exception{
        storage.load("dummy");
    }

    @org.junit.Test
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());

    }

    @org.junit.Test
    public void getAllSorted() throws Exception {
//        Resume[] src = new Resume[]{R1, R2, R3};
//        Arrays.sort(src);
//        assertArrayEquals(src, storage.getAllSorted().toArray());
        List<Resume> list = Arrays.asList(R1, R2, R3);
        Collections.sort(list, new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                return 0;
            }
        });
        assertEquals(list, new ArrayList<>(storage.getAllSorted()));
    }

    @org.junit.Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @org.junit.Test(expected = WebAppException.class)
    public void DeleteMissed() throws Exception {
        storage.delete("dummy");
    }

    @org.junit.Test(expected = WebAppException.class)
    public void SavePresented() throws Exception {
        storage.save(R1);
    }

    @org.junit.Test(expected = WebAppException.class)
    public void UpdateMissed() throws Exception {
        Resume resume = new Resume("dummy", "fullName_U1", "location_U1");
        storage.update(resume);
    }
}
