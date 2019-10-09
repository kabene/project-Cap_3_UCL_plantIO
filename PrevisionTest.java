
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrevisionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PrevisionTest
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
    public void testPrevisionTemp(){
        Prevision prevOrchi= new Prevision("Tests/orchidea");
        assertEquals(30.0, prevOrchi.previsionTemp(12), 0.2);
    }

    @Test
    public void testPrevisionHum(){
        Prevision prevOrchi= new Prevision("Tests/orchidea");
        assertEquals(65.0, prevOrchi.previsionHum(12), 0.2);
    }
    

    @Test 
    public void testPrevisionTemp2(){
        Prevision prevRose= new Prevision("Tests/rose");
        assertEquals(28, prevRose.previsionTemp(40), 0.2);
    }
    
    @Test
    public void testPrevisionHum2(){
        Prevision prevRose= new Prevision("Tests/rose");
        assertEquals(53.0, prevRose.previsionHum(40), 0.2);
    }
}