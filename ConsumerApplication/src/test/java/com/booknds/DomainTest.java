package com.booknds;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.booknds.domain.Consumer;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class DomainTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DomainTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DomainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
{
    assertTrue( true );
}

}
