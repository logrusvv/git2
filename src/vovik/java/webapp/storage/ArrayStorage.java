package vovik.java.webapp.storage;

import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Vovik
 * 1/27/2019
 */

public class ArrayStorage implements IStorage {
    private static final int LIMIT = 100;
    // protected Logger LOGGER = Logger.getLogger(getClass().getName());
    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName());
    private Resume[] array = new Resume[LIMIT];
    private int size;

    @Override
    public void clear() {
        LOGGER.info("Delete all resumes.");
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public void save(Resume r) {
        LOGGER.info("Save resume with uuid=" + r.getUuid());
        int idx = getIndex(r.getUuid());
        if(idx != -1) throw new WebAppException("Resume " + r.getUuid() + "already exist" , r);
        array[size++] = r;
/*

        int idx = -1;
        for (int i = 0; i < LIMIT; i++) {
            Resume resume = array[i];
            if (resume != null) {
                if (r.equals(resume)) {
                    throw new IllegalStateException("Already present");
                } else if (idx == -1) {
                    idx = i;
                }
            }
        }
        array[idx] = r;
*/


    }

    @Override
    public void update(Resume r) {
        LOGGER.info("Update resume with uuid=" + r.getUuid());
        int idx = getIndex(r.getUuid());
        if(idx == -1) throw new WebAppException("Resume " + r.getUuid() + "not exist" , r);
        array[idx] = r;
    }

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resume with uuid=" + uuid);
        int idx = getIndex(uuid);
        if(idx == -1) throw new WebAppException("Resume " + uuid + "not exist");
        return array[idx];
    }

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete resume with uuid=" + uuid);
        int idx = getIndex(uuid);
        if(idx == -1) throw new WebAppException("Resume " + uuid + "not exist");
        int numMoved = size - idx - 1;
        if(numMoved > 0){
            System.arraycopy(array, idx+1, array , idx, numMoved);
        }
        array[--size] = null;
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Arrays.sort(array, 0, size);
        return Arrays.asList(Arrays.copyOf(array, size));
    }

    @Override
    public int size() {
        return 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)){
                    return i;
                }
            }

        }
        return -1;
    }
}