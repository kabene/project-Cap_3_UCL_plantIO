import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;

import data.Sensor;
import data.Sample;
import java.util.Date;

import monitorable.Rose;
import monitorable.Plant;
import monitorable.Bamboo;
import monitorable.Cactus;
import monitorable.Orchidea;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlantListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlantListenerTest
{
    /**
     * Default constructor for test class PlantListTest
     */
    public PlantListenerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Configuration.load();
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
    public void testAdd(){
        PlantListener.add("rose");
        assertTrue(PlantListener.isActive("rose"));
    } 

    @Test
    public void testRemove(){
        PlantListener.remove("bamboo");
        assertTrue(PlantListener.isActive("bamboo")==false);
    }

    @Test
    public void testIsActive(){
        PlantListener.remove("bamboo");
        assertTrue(PlantListener.isActive("bamboo")==false);
    }

    @Test
    public void testGetHigherBound(){
        PlantListener.add("bamboo");
        assertEquals(95, PlantListener.getHigherBound("bamboo"),0);
        PlantListener.add("rose");
        assertEquals(80, PlantListener.getHigherBound("rose"),0);
        PlantListener.add("cactus");
        assertEquals(90, PlantListener.getHigherBound("cactus"),0);
        PlantListener.add("orchidea");
        assertEquals(70, PlantListener.getHigherBound("orchidea"),0);
    }

    @Test
    public void testGetLowerBound(){
        assertEquals(40, PlantListener.getLowerBound("bamboo"),0);
        assertEquals(25, PlantListener.getLowerBound("rose"),0);
        assertEquals(20, PlantListener.getLowerBound("cactus"),0);
        assertEquals(40, PlantListener.getLowerBound("orchidea"),0);
    }
}
