package vovik.java.webapp.storage;

import vovik.java.webapp.model.*;
import vovik.java.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Vovik
 * 2/23/2019
 */

public class XmlFileStorage extends FileStorage {
    private XmlParser xmlParser;

    public XmlFileStorage(String path) {
        super(path);
        xmlParser = new XmlParser(Resume.class, Organization.class, Link.class,
                OrganizationSection.class, TextSection.class, MultiTextSection.class, Organization.Period.class);
    }

    @Override
    protected void write(OutputStream os, Resume r) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(r, w);
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }
}
