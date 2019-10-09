import data.Sample;
import java.time.Instant;
import java.util.Date;
import interfaces.Filter;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StatsImplTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StatisticsTest
{
    Statistics a = new Statistics();
       Sample [] samples = new Sample[3];
       
    Statistics b = new Statistics();    
       Sample [] samples2 = new Sample[4];
       
    Filter filter;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
       //Tableau de sample utilisé pour les 9 premiers test
       samples [0] = new Sample(20,(float)70,new time.Instant(new Date(2017,12,20))); 
       samples [1] = new Sample(15,(float)50,new time.Instant(new Date(2017,12,20)));
       samples [2] = new Sample(25,(float)45,new time.Instant(new Date(2017,12,20)));
       
       //Tableau utilisé pour tester la méthode filter
       samples2 [0] = new Sample(20,(float)70,new time.Instant(new Date(2017,12,20))); 
       samples2 [1] = new Sample(15,(float)31,new time.Instant(new Date(2017,12,20)));
       samples2 [2] = new Sample(25,(float)20,new time.Instant(new Date(2017,12,20)));
       samples2 [3] = new Sample(25,(float)10,new time.Instant(new Date(2017,12,20)));
       
       filter = new testFilter();
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
    public void testTempAverage(){
        assertEquals(20, a.getAverageTemp(samples), 0);
    }
    
    @Test
    public void testHumAverage(){
        assertEquals(55, a.getAverageHum(samples), 0);
    }
    
    @Test
    public void testGetMinTemp(){
        assertEquals(15, a.getMinTemp(samples), 0);
    }
    
    @Test
    public void testGetMaxTemp(){
        assertEquals(25, a.getMaxTemp(samples), 0);
    }
    
    @Test
    public void testGetMinHum(){
        assertEquals(45, a.getMinHum(samples), 0);
    }
    
    @Test
    public void testGetMaxHum(){
        assertEquals(70, a.getMaxHum(samples), 0);
    }
    
    @Test
    public void testGetVarianceTemp(){
        assertEquals(17, a.getVarianceTemp(samples), 0.4);
    }
    
    @Test
    public void TestgetVarianceHum(){
        assertEquals(117, a.getVarianceHum(samples), 0.4);
    }
    
    @Test
    public void testGetStandardDeviationTemp(){
        assertEquals(4, a.getStandardDeviationTemp(samples), 0.4);
    }
    
    @Test
    public void testGetStandardVariationHum(){
        assertEquals(11, a.getStandardDeviationHum(samples), 0.4);
    }
    
    @Test
    public void testGetCovarianceTempHum(){
        assertEquals(-8, a.getCovarianceTempHum(samples), 0.4);
    }
    
    @Test
    public void testGetCorrelationTempHum(){
        assertEquals(0.2, a.correlationTempHum(samples), 0.4);
    }
    
    @Test
    public void testFilter(){
        assertEquals(2, b.filter(samples2, filter).length, 0);
    }
}
