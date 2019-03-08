package vovik.java.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Vovik
 * 3/3/2019
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayStorageTest.class, MapStorageTest.class,
        DataStreamFileStorageTest.class, SerializeFileStorageTest.class,
        XmlFileStorageTest.class, JsonFileStorage.class,
        SqlStorageTest.class})
public class AllStorageTests {
}
