package vovik.java.webapp.model;

import java.util.*;

/**
 * Vovik
 * 1/22/2019
 */

public class Resume implements Comparable<Resume> {
    private String uuid;
    private String fullName;
    private String location;
    private String homePage;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
    //private List<Contact> contacts = new LinkedList<>();
    //private List<Section> sections = new LinkedList<>();

    public Resume(String fullName, String location) {
        this(UUID.randomUUID().toString(), fullName, location);
    }

    public Resume(String uuid, String fullName, String location) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.location = location;
    }

    public Resume(Resume r){
        this(r.uuid,r.fullName,r.location);
    }

    public Resume() {
    }

    public void addSection(SectionType type, Section section){
        sections.put(type, section);
    }

    public void addContact(ContactType type, String value){
        contacts.put(type, value);
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getHomePage() {
        return homePage;
    }

/*    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Section> getSections() {
        return sections;
    }
*/
    public String getContact(ContactType type){
        return contacts.get(type);
    }

    public Section getSections(SectionType type){
        return sections.get(type);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, location, homePage, contacts, sections);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Resume other = (Resume) obj;
        return Objects.equals(this.uuid, other.uuid)
                && Objects.equals(this.fullName, other.fullName)
                && Objects.equals(this.location, other.location)
                && Objects.equals(this.homePage, other.homePage)
                && Objects.equals(this.contacts, other.contacts)
                && Objects.equals(this.sections, other.sections);
    }

    @Override
    public int compareTo(Resume o) {
        return fullName.compareTo(o.fullName);
    }

    @Override
    public String toString() {
        return "fullName " + fullName + " (" + uuid + ")";
    }
}
