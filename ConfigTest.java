import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ConfigTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ConfigTest
{        
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSet(){
        Configuration.set("bamboo","false");
        assertTrue(PlantListener.isActive("bamboo")==false);
    }

    @Test
    public void TestLoad()
    {
        Configuration.load();
        assertTrue(PlantListener.isActive("bamboo"));
    }

    @Test
    public void testSave(){
        if(PlantListener.isActive("cactus"))
            PlantListener.remove("cactus");
        Configuration.save();
        assertTrue(PlantListener.isActive("cactus")==false);
    }
}

