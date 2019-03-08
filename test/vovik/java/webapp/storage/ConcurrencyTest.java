package vovik.java.webapp.storage;

import org.junit.Test;
import vovik.java.webapp.model.Resume;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.LogManager;

/**
 * Vovik
 * 3/3/2019
 */

public class ConcurrencyTest {
    static {
        try (FileInputStream logProps = new FileInputStream(new File("logging.properties"))) {
            LogManager.getLogManager().readConfiguration(logProps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void ArrayStorage() throws Exception {
        run(new ArrayStorage());
    }

    @org.junit.Test
    public void SerializedFileStorage() throws Exception {
        run(new SerializeFileStorage(AbstractStorageTest.FILE_STORAGE));
    }

    @org.junit.Test
    public void SynchronizedMapStorage() throws Exception {
        run(new SynchronizedMapStorage());
    }

    @org.junit.Test
    public void ConcurrentMapStorage() throws Exception {
        run(new ConcurrentMapStorage());
    }

    private void run(IStorage storage) throws Exception {
        for (int i = 1; i < 5000; i++) {
            new Thread(() -> {
                Resume r = new Resume("name", "location");
                storage.save(r);
                storage.load(r.getUuid());
                storage.delete(r.getUuid());
                storage.getAllSorted();
            }).start();
        }
        Thread.sleep(5000);
    }
}
