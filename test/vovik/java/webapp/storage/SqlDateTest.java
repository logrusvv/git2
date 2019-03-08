package vovik.java.webapp.storage;

import org.junit.Test;
import vovik.java.webapp.WebAppConfig;

import java.time.LocalDate;
import java.time.Month;

/**
 * Vovik
 * 3/3/2019
 */

public class SqlDateTest {
    @Test
    public void testInsertDate() throws Exception {
        SqlStorage storage = (SqlStorage) WebAppConfig.get().getStorage();
        storage.insertDate(LocalDate.now(), LocalDate.of(2015, Month.FEBRUARY, 23));
    }
}
