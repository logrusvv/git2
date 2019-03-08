package vovik.java.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Objects;

/**
 * Vovik
 * 1/23/2019
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Link implements Serializable {

    static final long serialVersionUID = 1L;

    public static Link EMPTY = new Link();

    private final String name;
    private final String url;


    public Link() {
        this("", "");
    }

    public Link(String name, String url) {
        Objects.requireNonNull(name, "name is null");
        this.name = name;
        this.url = url == null ? "" : url;
    }

    public Link(Link link) {
        this(link.name, link.url);
       // this.name = link.name;
       // this.url = link.url;
    }


    public static Link empty(){
        return EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return name.equals(link.name) &&
                Objects.equals(url, link.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
