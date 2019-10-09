import java.util.Date;
import data.Sample;
import time.Instant;

public class Prevision
{
    public static String plant;
    public static Sample[] sampleData;
    public static Sample[] sampleLum;
    public static double[] timeTab;
    public static double[] humTab;
    public static double[] lumTab;
    public static double[] tempTab;
    public static StraightLine previsionDroiteLum;
    public static StraightLine previsionDroiteHum;
    public static StraightLine previsionDroiteTemp;

    /**
     * Constructor for objects of class Prevision
     */
    public Prevision(String plant){
        assert plant.equals("orchidea") || plant.equals("bamboo") || plant.equals("cactus") || plant.equals("rose");
        this.plant = plant;

        sampleData = Database.load(plant);
        sampleLum = Database.loadLuminosity(plant);

        timeTab = new double[sampleData.length];
        tempTab = new double[sampleData.length];
        humTab = new double[sampleData.length];
        lumTab = new double[sampleLum.length];
    }
    /**
     * @pre sampleData!=null
     * @post retourne un tableau avec le temps de chaque sample du fichier
     */
    public static double[] getTimeTab(){
        assert sampleData != null;

        for(int i=0; i<sampleData.length; i++){
            timeTab[i]=(sampleData[i]).getTime().toEpochSecond()-(sampleData[0]).getTime().toEpochSecond();
        }
        return timeTab;
    }
    /**
     * @pre sampleData!=null
     * @post retourne un tableau avec l'humidité de chaque sample du fichier
     */
    public static double[] getHumTab(){
        assert sampleData != null;

        for(int i=0; i<sampleData.length; i++){
            humTab[i]=sampleData[i].getHumidity();
        }
        return humTab;
    }

    /**
     * @pre sampleData!=null
     * @post retourne un tableau avec la température de chaque sample du fichier
     */
    public static double[] getTempTab(){
        assert sampleData != null;

        for(int i=0; i<sampleData.length; i++){
            tempTab[i]= sampleData[i].getTemperature();
        }
        return tempTab;
    }
    
    public static double[] getLumTab(){
        assert sampleLum != null;

        for(int i=0; i<sampleLum.length; i++){
            lumTab[i]= sampleLum[i].getTemperature();
        }
        return lumTab;
    }

    /**
     * @pre -
     * @post retourne une droite créée par la régression linéaire du tableau des humidités en fonction du temps
     */
    public static StraightLine getPrevisionDroiteHum(){
        previsionDroiteHum=LinearRegressionGradientDescent.fitLine(getTimeTab(), getHumTab(), 0.001, 60000);
        return previsionDroiteHum;
    }
    /**
     * @pre -
     * @post retourne une droite créée par la régression linéaire du tableau des températures en fonction du temps
     */
    public static StraightLine getPrevisionDroiteTemp(){
        previsionDroiteTemp=LinearRegressionGradientDescent.fitLine(getTimeTab(), getTempTab(), 0.001, 60000);
        return previsionDroiteTemp;
    }
    
    public static StraightLine getPrevisionDroiteLum(){
        previsionDroiteLum=LinearRegressionGradientDescent.fitLine(getTimeTab(), getLumTab(), 0.001, 60000);
        return previsionDroiteLum;
    }
    /**
     * @pre -
     * @post retourne une estimation de l'humidité au temps temps
     */
    public static double previsionHum(double temps){
        return getPrevisionDroiteHum().evaluate(temps);
    }
    
    public static double previsionLum(double temps){
        return getPrevisionDroiteLum().evaluate(temps);
    }

    /**
     * @pre -
     * @post retourne une estimation de la température au temps temps
     */
    public static double previsionTemp(double temps){
        return getPrevisionDroiteTemp().evaluate(temps);
    }
}
