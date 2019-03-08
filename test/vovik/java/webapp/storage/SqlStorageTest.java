package vovik.java.webapp.storage;

import vovik.java.webapp.WebAppConfig;

/**
 * Vovik
 * 3/3/2019
 */

public class SqlStorageTest extends AbstractStorageTest{
    {
        storage = WebAppConfig.get().getStorage();
    }

}
