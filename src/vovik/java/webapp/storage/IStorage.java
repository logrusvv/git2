package vovik.java.webapp.storage;

import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.Resume;

import java.util.Collection;

/**
 * Vovik
 * 1/27/2019
 */

public interface IStorage {
    void clear();

    void save(Resume r) throws WebAppException;

    void update(Resume r);

    Resume load(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();

    boolean isSectionSupported();
}
