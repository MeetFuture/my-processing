package com;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import processing.core.PApplet;

/**
 * Unit test for simple ProcessingTest.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        try {
            PApplet.main(ProcessingTest.class);
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
