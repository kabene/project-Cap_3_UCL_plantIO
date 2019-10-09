import java.io.*;
import data.Sample;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import interfaces.Filter;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class AlertTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AlertTest
{
    Sample [] samples = new Sample[3];
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
       samples [0] = new Sample(20,(float)70,new time.Instant(new Date(2017,12,20))); 
       samples [1] = new Sample(15,(float)50,new time.Instant(new Date(2017,12,20)));
       samples [2] = new Sample(25,(float)45,new time.Instant(new Date(2017,12,20)));
       PlantListener.add("rose");
       Configuration.set("rose", "true");
       PlantListener.add("orchidea");
       Configuration.set("orchidea", "true");
       PlantListener.add("bamboo");
       Configuration.set("bamboo", "true");
    }
    
    @Test
    public void Testcheck(){
        Alert.check("bamboo",samples [0]);
        assertTrue(Alert.bambooIsDanger == false);
        
        Alert.check("orchidea",samples[1]);
        assertTrue(Alert.orchideaIsDanger == false);
        
        Alert.check("rose",samples [1]);
        assertTrue(Alert.roseIsDanger == false);
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

}
