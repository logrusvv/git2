package lesson5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import vovik.java.webapp.WebAppException;

import static org.junit.Assert.*;

/**
 * Vovik
 * 2/1/2019
 */


public class CalculatorTest {

    static Calculator calc;

    static {
        calc = new Calculator();
    }

    @Test(expected = WebAppException.class)
    public void abs() throws Exception {
        assertEquals(5, calc.abs(-5));
        throw new WebAppException("");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
