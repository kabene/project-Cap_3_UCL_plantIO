import java.io.*;
import monitorable.*;

public class Configuration {
    // File to save the configuration
    public static String file = "config/app.txt";
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     *      value != null, value must be "true" or "false"
     * @post create new instace of plant and activate it
     */
    public static void set(String plant, String value) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        assert value != null;
        assert value.equals("true") || value.equals("false");
        
        if (plant.equals("bamboo")) {
            PlantListener.bamboo = new Bamboo(App.sensor);
            PlantListener.bambooIsActive = Boolean.parseBoolean(value);
        }
        
        if (plant.equals("cactus")) {
            PlantListener.cactus = new Cactus(App.sensor);
            PlantListener.cactusIsActive = Boolean.parseBoolean(value);
        }
        
        if (plant.equals("orchidea")) {
            PlantListener.orchidea = new Orchidea(App.sensor);
            PlantListener.orchideaIsActive = Boolean.parseBoolean(value);
        }
        
        if (plant.equals("rose")) {
            PlantListener.rose = new Rose(App.sensor);
            PlantListener.roseIsActive = Boolean.parseBoolean(value);
        }
    }
    
    /*
     * @pre -
     * @post load configuration file and set plants
     */
    public static void load() {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("=");
                
                String name = split[0];
                String value = split[1];
       
                set(name, value);                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /*
     * @pre -
     * @post save on configuration file
     */
    public static void save() {
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter(file));
            
            writer.write("bamboo=" + PlantListener.bambooIsActive);
            writer.newLine();
            
            writer.write("cactus=" + PlantListener.cactusIsActive);
            writer.newLine();
            
            writer.write("orchidea=" + PlantListener.orchideaIsActive);
            writer.newLine();
            
            writer.write("rose=" + PlantListener.roseIsActive);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
