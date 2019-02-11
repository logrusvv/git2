package vovik.java.webapp.storage;

import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.ContactType;
import vovik.java.webapp.model.Resume;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Vovik
 * 2/9/2019
 */

public abstract class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage(String path) {
        this.dir = new File(path);
        if (!dir.isDirectory() || !dir.canWrite())
            throw new IllegalArgumentException("'" + path + "' is not directory or is not writable");
    }

    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file: files){
            doDelete(file);
        }
    }

    @Override
    protected File getContext(String fileName) {
        return new File(fileName);
    }

    @Override
    protected boolean exist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(File file, Resume r) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new WebAppException("Couldn't create file " + file.getAbsolutePath(), r, e);
        }
        write(file, r);
    }

     abstract protected void write(File file, Resume r);

    @Override
    protected void doUpdate(File file, Resume r) {
        write(file, r);
    }

    abstract protected Resume read(File file);

    @Override
    protected Resume doLoad(File file) {
        //TODO
        return read(file);
    }

    @Override
    protected void doDelete(File file) {
        if(!file.delete()) throw new WebAppException("File" + file.getAbsolutePath() + " can not be deleted");
    }

    @Override
    protected List<Resume> doGetAll() {
        return null;
    }

    @Override
    public int size() {
        String[] list = dir.list();
        if(list == null) throw new WebAppException("Couldn't read directory" + dir.getAbsolutePath());
        return list.length;
    }
}
