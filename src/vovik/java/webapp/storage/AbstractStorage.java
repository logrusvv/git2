package vovik.java.webapp.storage;

import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.Link;
import vovik.java.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Vovik
 * 1/27/2019
 */

abstract public class AbstractStorage implements IStorage {

    protected final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void clear() {
        logger.info("Delete all resumes.");
        doClear();
    }

    protected abstract void doClear();

    protected abstract boolean exists(String uuid);

    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid=" + r.getUuid());
        if (exists(r.getUuid())) {
            throw new WebAppException("Resume " + r.getUuid() + "already exist", r);
        }
        doSave(r);
    }

    protected abstract void doSave(Resume r);

    @Override
    public void update(Resume r) {
        logger.info("Update resume with uuid=" + r.getUuid());

        if (!exists(r.getUuid())){
            throw new WebAppException("Resume " + r.getUuid() + "not exist", r);
        }
        doUpdate(r);
    }

    protected abstract void doUpdate(Resume r);

    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with uuid=" + uuid);
        if (!exists(uuid)){
            throw new WebAppException("Resume " + uuid + "not exist");
        }
        return doLoad(uuid);
    }

    protected abstract Resume doLoad(String uuid);

    @Override
    public void delete(String uuid) {
        logger.info("Delete resume with uuid=" + uuid);
        if (!exists(uuid)){
            throw new WebAppException("Resume " + uuid + "not exist");
        }
        doDelete(uuid);
    }

    protected abstract void doDelete(String uuid);

    @Override
    public Collection<Resume> getAllSorted() {
        logger.info("getAllSorted");
        List<Resume> list = doGetAll();
        Collections.sort(list);
        return list;
        //return Collections.singletonList(new Resume());
    }

    protected abstract List<Resume> doGetAll();

    public abstract int size();


}
