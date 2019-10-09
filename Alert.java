import java.io.*;
import data.Sample;

public class Alert {
    public static boolean bambooIsDanger = false;
    public static boolean cactusIsDanger = false;
    public static boolean orchideaIsDanger = false;
    public static boolean roseIsDanger = false;
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     *      sample != null
     * @post check plant's humidity and send alert if the plant's humidity is higher its higher bound or lower than her lower bound
     */
    public static void check(String plant, Sample sample){
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        // Plant's last humidity
        float humidity = sample.getHumidity();
        
        if (plant.equals("bamboo")) {
            if (humidity > PlantListener.bamboo.getHigherBound() || humidity < PlantListener.bamboo.getLowerBound()) {
                try {
                    TelegramListener.client.sendMessage(
                        Lang.get("ALERT"),
                        Lang.get("bamboo_is_in_danger")
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (plant.equals("cactus")) {
            if (humidity > PlantListener.cactus.getHigherBound() || humidity < PlantListener.cactus.getLowerBound()) {
                try {
                    TelegramListener.client.sendMessage(
                        Lang.get("ALERT"),
                        Lang.get("cactus_is_in_danger")
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (plant.equals("orchidea")) {
            if (humidity > PlantListener.orchidea.getHigherBound() || humidity < PlantListener.orchidea.getLowerBound()) {
                try {
                    TelegramListener.client.sendMessage(
                        Lang.get("ALERT"),
                        Lang.get("orchidea_is_in_danger")
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (plant.equals("rose")) {
            if (humidity > PlantListener.rose.getHigherBound() || humidity < PlantListener.rose.getLowerBound()) {
                try {
                    TelegramListener.client.sendMessage(
                        Lang.get("ALERT"),
                        Lang.get("rose_is_in_danger")
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
