import java.io.*;

import data.Sample;
import chart.Chart;
import chart.DataSet;

public class Graphics {
    /*
     * @pre file != null
     * @post save graphic of plant's temperature
     */
    public static void temperature(String file) {
        assert file != null;
        
        DataSet temperature = new DataSet("Temperature", DataSet.PRECISION_SECONDS);
        Sample[] samples = Database.load(file);
        
        for (int i = 0; i < samples.length; i++) {
             temperature.addPoint(samples[i].getTime().toDate(), samples[i].getTemperature());
        }
        
        Chart chart = new Chart("", temperature);

        try {
            chart.saveChartAsPNG("graph/temp/bamboo.png", 1200, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * @pre file != null
     * @post save graphic of plant's humidity
     */
    public static void humidity(String file) {
        assert file != null;
        
        DataSet humidity = new DataSet("Humidity", DataSet.PRECISION_SECONDS);
        Sample[] samples = Database.load(file);
        
        for (int i = 0; i < samples.length; i++) {
             humidity.addPoint(samples[i].getTime().toDate(), samples[i].getHumidity());
        }
        
        Chart chart = new Chart("", humidity);

        try {
            chart.saveChartAsPNG("graph/hum/bamboo.png", 1200, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void luminosity(String file) {
        assert file != null;
        
        DataSet luminosity = new DataSet("Luminosity", DataSet.PRECISION_SECONDS);
        Sample[] samples = Database.loadLuminosity(file);
        
        for (int i = 0; i < samples.length; i++) {
             luminosity.addPoint(samples[i].getTime().toDate(), samples[i].getTemperature());
        }
        
        Chart chart = new Chart("", luminosity);

        try {
            chart.saveChartAsPNG("graph/lum/bamboo.png", 1200, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
