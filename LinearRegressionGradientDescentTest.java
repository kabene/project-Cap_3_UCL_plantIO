
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LinearRegressionTest2.
 *
 * @author  (Elliott Dubuisson)
 * @version (25/11/17)
 */
public class LinearRegressionGradientDescentTest
{
    double[]x; 
    double[]y;
    StraightLine line;

    double[]x2; 
    double[]y2;
    StraightLine line2;

    double[]x3; 
    double[]y3;
    StraightLine line3;

    double[]x4; 
    double[]y4;
    StraightLine line4;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //création de la première droite et de son ensemble de points

        x=new double[]{1,2,3,4};
        y=new double[]{1,2,3,4};
        line= LinearRegressionGradientDescent.fitLine(x,y,0.001,60000);

        //création de la deuxième droite et de son ensemble de points

        x2= new double[] {-30 ,-29 ,-28 ,-27 ,-26 ,-25 ,-24 ,-23 ,-22 ,-21 ,-20 ,-19 ,-18 ,-17 ,-16 ,-15 ,-14 ,-13 ,-12 ,-11 ,-10 ,-9 ,-8 ,-7 ,-6 ,-5 ,-4 ,-3 ,-2 ,-1 ,0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,11 ,12 ,13 ,14 ,15 ,16 ,17 ,18 ,19 ,20 ,21 ,22 ,23 ,24 ,25 ,26 ,27 ,28 ,29 ,30};
        y2 = new double[] {71.3785723159893 ,71.1009285118908 ,66.0176060907966 ,64.8672503111012 ,65.9128556203021 ,60.7562768798252 ,54.7416826727136 ,51.9007654234647 ,48.7186647545069 ,51.6802073214893 ,44.2008990088112 ,44.2223872279092 ,41.3897253857293 ,36.0650519499323 ,33.7714141016156 ,38.6894639261838 ,28.699276601832 ,28.0825294289231 ,27.657346572273 ,21.1101623408424 ,23.1485417828651 ,18.971098832071 ,12.6634171620319 ,12.7478385224928 ,13.2733413152202 ,8.15805006623133 ,6.56095445161007 ,0.714551933391548 ,-0.0189398715478499 ,-1.10828676237505 ,-0.767656279222711 ,-5.49661433541721 ,-9.31636675291868 ,-11.1839944617837 ,-14.985289013749 ,-17.5102607666443 ,-17.4388973195043 ,-22.0177055509089 ,-21.8982429146523 ,-26.9060202140161 ,-27.8555444530198 ,-30.8475684826555 ,-32.6585195844803 ,-37.7423050345617 ,-40.3823779451945 ,-42.1247379389224 ,-43.0815857860857 ,-46.8383345095629 ,-45.6902903370226 ,-49.9128296033442 ,-52.2125762114854 ,-57.4360197733719 ,-58.1755153496758 ,-63.9748679665111 ,-61.2968428527313 ,-64.7508050305413 ,-67.8529128364356 ,-70.8104899514322 ,-73.6062862775653 ,-75.3294981117544 ,-78.2031184347992};
        line2= LinearRegressionGradientDescent.fitLine(x2, y2, 0.0001, 600000);

        //création de la troisième droite et de son ensemble de points

        x3=new double[]{1, 2, 3, 4, 5, 6};
        y3=new double[]{1, 1, 1, 1, 10, 1};
        line3= LinearRegressionGradientDescent.fitLine(x3, y3, 0.001, 60000);

        //création de la quatrième droite et de son ensemble de points        

        x4=new double[]{1, 1, 1, 1, 5, 1};
        y4=new double[]{1, 2, 3, 4, 1, 5};
        line4= LinearRegressionGradientDescent.fitLine(x4, y4, 0.001, 60000);
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
    public void testSlope1(){
        assertEquals(1, line.getSlope(), 0.4);
    }

    @Test
    public void testIntercept1(){
        assertEquals(0, line.getIntercept(), 0.4);   
    }

    @Test
    public void testSlope2(){
        assertEquals(-2.5, line2.getSlope(), 0.4);
    }

    @Test
    public void testIntercept2(){
        assertEquals(-4, line2.getIntercept(), 0.4);   
    }

    @Test
    public void testSlope3(){
        assertEquals(0.5, line3.getSlope(), 0.4);
    }

    @Test
    public void testIntercept3(){
        assertEquals(0, line3.getIntercept(), 0.4);   
    }

    @Test
    public void testSlope4(){
        assertEquals(-0.5, line4.getSlope(), 0.4);
    }

    @Test
    public void testIntercept4(){
        assertEquals(3.5, line4.getIntercept(), 0.4);   
    }
}
