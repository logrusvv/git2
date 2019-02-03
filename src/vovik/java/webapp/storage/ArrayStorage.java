package vovik.java.webapp.storage;

import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Vovik
 * 1/27/2019
 */

public class ArrayStorage extends AbstractStorage {
    private static final int LIMIT = 100;

    private Resume[] array = new Resume[LIMIT];
    private int size;

    @Override
    protected void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected boolean exists(String uuid) {
        return getIndex(uuid) != -1;
    }



    @Override
    protected void doSave(Resume r) {
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
    protected void doUpdate(Resume r) {
        int idx = getIndex(r.getUuid());
        if (idx == -1) throw new WebAppException("Resume " + r.getUuid() + "not exist", r);
        array[idx] = r;
    }

    @Override
    protected Resume doLoad(String uuid) {
        int idx = getIndex(uuid);
        return array[idx];
    }


    @Override
    protected void doDelete(String uuid) {
        int idx = getIndex(uuid);
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        }
        array[--size] = null;
    }

    @Override
    protected List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOf(array, size));
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }

        }
        return -1;
    }
}