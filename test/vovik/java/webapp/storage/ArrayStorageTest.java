package vovik.java.webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vovik.java.webapp.WebAppException;
import vovik.java.webapp.model.ContactType;
import vovik.java.webapp.model.Resume;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * Vovik
 * 1/27/2019
 */


public class ArrayStorageTest extends AbstractStorageTest {
    {
        storage = new ArrayStorage();
    }

}
