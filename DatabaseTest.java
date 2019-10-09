import data.Sample;
import time.Instant;
import java.util.Date;
import java.text.*;
import java.io.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DatabaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DatabaseTest
{
    Sample sampleRose0= new Sample(24,(float)50, new time.Instant(new Date(117, 11, 04, 1, 30, 30)));
    Sample roseSample= new Sample(55,(float)93, new time.Instant(new Date(117, 11, 04, 00, 00, 00)));
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
    public void testsampleToString(){
        assertTrue(Database.sampleToString(sampleRose0).equals("04/12/2017@01:30:30=24.0,50.0"));
    }

    @Test 
    public void testStringToSample(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy@hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse("04/12/2017@01:30:01");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Sample test = Database.stringToSample("04/12/2017@01:30:01=24.0,50.0");

        Sample sample = new Sample((float)24.0,(float)50.0, new Instant(date));  

        assertTrue(test.getHumidity() == sample.getHumidity());
        assertTrue(test.getTemperature() == sample.getTemperature());
        assertTrue(test.getTime().toDate().toString().equals (sample.getTime().toDate().toString()));

    }

    @Test
    public void testSave(){
        Database.save("/Tests/cactus", roseSample);
        Sample[] test =Database.load("/Tests/cactus");
        assertTrue(test[test.length-1].getTemperature()==55.0);
        assertTrue(test[test.length-1].getHumidity()==93.0);        
        assertTrue(test[test.length-1].getTime().toDate().toString().equals(roseSample.getTime().toDate().toString()));
    }

    @Test
    public void testLoad(){
        Sample[] test =Database.load("/Tests/rose");
        assertTrue(test[0].getHumidity()==49.0);
        assertTrue(test[0].getTemperature()==24.0);
        assertTrue(test[0].getTime().toDate().toString().equals(roseSample.getTime().toDate().toString()));
    }
    
    @Test
    public void testClear(){
        Database.clear("/Tests/bamboo");
        BufferedReader reader=null;
        String line;
        try{
            reader = new BufferedReader(new FileReader("sample/Tests/bamboo.txt"));
            line=reader.readLine();
            assertTrue(line==null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
