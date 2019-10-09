import java.io.*;
import data.Sensor;

public class App {
    public static Sensor sensor = Sensor.getRaspberryPiSensor();
    
    public static void main(String[] args) {
        // Loads the configuration file
        Configuration.load();
        
        // Loads the language file
        Lang.load("en");
        
        // Listen to plants
        PlantListener.listen();
        
        try {
            // Listen to telegram
            TelegramListener.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        sensor.start();
    }
}
