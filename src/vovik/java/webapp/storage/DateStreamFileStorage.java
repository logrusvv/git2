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

public class DateStreamFileStorage extends FileStorage {

    private static final String NULL = "null";

    public DateStreamFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume r) {
        try (FileOutputStream fos = new FileOutputStream(file); DataOutputStream dos = new DataOutputStream(fos)) {
            writeString(dos, r.getFullName());
            writeString(dos, r.getLocation());
            writeString(dos, r.getHomePage());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
                dos.writeInt(entry.getKey().ordinal());
                writeString(dos, entry.getValue());
            }
            // TODO section implementation
        } catch (IOException e) {
            throw new WebAppException("Couldn't write file " + file.getAbsolutePath(), r, e);
        }
    }

    protected Resume read(File file) {
        Resume r = new Resume();

        try (InputStream is = new FileInputStream(file); DataInputStream dis = new DataInputStream(is)) {
            r.setFullName(readString(dis));
            r.setLocation(readString(dis));
            r.setHomePage(readString(dis));
            int contactsSize = dis.readInt();
            for (int i = 0; i < contactsSize; i++) {
                r.addContact(ContactType.VALUES[dis.readInt()], readString(dis));
            }
            //TODO
        } catch (IOException e) {
            throw new WebAppException("Couldn't read file " + file.getAbsolutePath(), e);
        }
        return null;
    }

    private void writeString(DataOutputStream dos, String str) throws IOException{
        dos.writeUTF(str == null ? NULL : str);
    }

    private String readString(DataInputStream dis) throws IOException{
        String str = dis.readUTF();
        return str.equals(NULL) ? null : str;
    }

}
