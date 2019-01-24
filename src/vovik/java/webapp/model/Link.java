package vovik.java.webapp.model;

import java.util.Objects;

/**
 * Vovik
 * 1/23/2019
 */

public class Link {
    private static Link EMPTY = new Link();
    private final String name;
    private final String url;

    private Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Link(Link link) {
        this(link.name, link.url);
       // this.name = link.name;
       // this.url = link.url;
    }

    private Link() {
        this("",null);
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
}
