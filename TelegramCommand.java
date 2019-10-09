import java.io.*;

import data.Sample;

public class TelegramCommand {
    public static void setLang(String message) {
        assert message != null;
        
        String[] split1 = message.split("_");
        String[] split2 = split1[1].split("@");
        String lang = split2[0];
        Lang.load(lang);
        
        try {            
            TelegramListener.client.sendMessage(
                Lang.get("success"),
                Lang.get("lang_change") +
                "\n /lang: " + Lang.get("back_main")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void getData(String type) {
        assert type != null;
        assert type.equals("sensor") || type.equals("bamboo") || type.equals("cactus") || type.equals("orchidea") || type.equals("rose"); 
        
        try {
            if (type.equals("sensor")) {          
                TelegramListener.client.sendMessage(
                    Lang.get("sensor_data"),
                    Lang.get("humidity") + " : " + App.sensor.takeSample().getHumidity() + "%\n" +
                    Lang.get("temperature") + " : " + App.sensor.takeSample().getTemperature() + "°C\n" +
                    "Luminosity : " + Database.getLast("lum") + "lux\n" + //ANCHOR
                    "\n /get : " + Lang.get("back_menu")
                );
            } else {            
                TelegramListener.client.sendMessage(
                    type + " " + Lang.get("humidity"),
                    Lang.get("humidity(current)") + " : " + PlantListener.getHumidity(type) + "%\n" +
                    Lang.get("humidity(lower_bound)") + " : " + PlantListener.getLowerBound(type) + "%\n" +
                    Lang.get("humidity(higher_bound)") + " : " + PlantListener.getHigherBound(type) + "%\n" +
                    "\n /get : "+ Lang.get("back_menu")
                );
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * @pre plant != null, plant must be "menu", "bamboo", "cactus", "orchidea", "rose"
     * @post add plant if not active yet and send feedback to user
     */
    public static void addPlant(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        try {
            if (PlantListener.isActive(plant)) {
                TelegramListener.client.sendMessage(
                    Lang.get("fail"),
                    Lang.get(plant+"_was_already_added") + "\n" +
                    "\n /add : " + Lang.get("back_add")
                );
            } else {
                PlantListener.add(plant);            
                TelegramListener.client.sendMessage(
                    Lang.get("success"),
                    Lang.get(plant+"_was_added") + "\n" +
                    "\n /add : " + Lang.get("back_add")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post remove plant if active and send feedback to user
     */
    public static void removePlant(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        try {            
            if (!PlantListener.isActive(plant)) {
                TelegramListener.client.sendMessage(
                    Lang.get("fail"),
                    Lang.get(plant+"_was_already_removed") + "\n" +
                    "\n /remove : " + Lang.get("back_remove")
                );
            } else {
                PlantListener.remove(plant);            
                TelegramListener.client.sendMessage(
                    Lang.get("success"),
                    Lang.get(plant+"_was_removed") + "\n" +
                    "\n /remove : " + Lang.get("back_remove")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post send user the plant humidity statistics
     */
    public static void getHumidityStats(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        try {
            Statistics stats = new Statistics();
            Sample[] samples = Database.load(plant);
            
            TelegramListener.client.sendMessage(
                Lang.get("humidity_statistics"),
                Lang.get("average") + " : " + stats.getAverageHum(samples) + "%\n" +
                Lang.get("minimum") + " : " + stats.getMinHum(samples) + "%\n" +
                Lang.get("maximum") + " : " + stats.getMaxTemp(samples) + "%\n" +
                Lang.get("variance") + " : " + stats.getVarianceHum(samples) + "\n" +
                Lang.get("standard_deviation") + " : " + stats.getStandardDeviationHum(samples) + "\n" +
                Lang.get("correlation(temperature)") + " : " + stats.correlationTempHum(samples) + "\n" +
                "\n /stat\\_humidity : " + Lang.get("back_hum_stats")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post send user the plant temperature statistics
     */
    public static void getTemperatureStats(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        try {
            Statistics stats = new Statistics();
            Sample[] samples = Database.load(plant);
            
            TelegramListener.client.sendMessage(
                Lang.get("temperature_statistics"),
                Lang.get("average") + " : " + stats.getAverageTemp(samples) + "°C\n" +
                Lang.get("minimum") + " : " + stats.getMinTemp(samples) + "°C\n" +
                Lang.get("maximum") + " : " + stats.getMaxTemp(samples) + "°C\n" +
                Lang.get("variance") + " : " + stats.getVarianceTemp(samples) + "\n" +
                Lang.get("standard_deviation") + " : " + stats.getStandardDeviationTemp(samples) + "\n" +
                Lang.get("correlation(humidity)") + " : " + stats.correlationTempHum(samples) + "\n" +
                "\n /stat\\_temperature : " + Lang.get("back_temp_stats")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void getLuminosityStats(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        try {
            Statistics stats = new Statistics();
            Sample[] samples = Database.loadLuminosity(plant);
            
            TelegramListener.client.sendMessage(
                Lang.get("luminosity_statistics"),
                Lang.get("average") + " : " + stats.getAverageTemp(samples) + "lum\n" +
                Lang.get("minimum") + " : " + stats.getMinTemp(samples) + "lum\n" +
                Lang.get("maximum") + " : " + stats.getMaxTemp(samples) + "lum\n" +
                Lang.get("variance") + " : " + stats.getVarianceTemp(samples) + "\n" +
                Lang.get("standard_deviation") + " : " + stats.getStandardDeviationTemp(samples) + "\n" +
                // Lang.get("correlation(humidity)") + " : " + stats.correlationTempHum(samples) + "\n" +
                "\n /stat\\_luminosity : " + Lang.get("back_lum_stats")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void getHumidityGraph(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        Graphics.humidity("bamboo");
        
        try {
            TelegramListener.client.sendFile(
                "graph/hum/" + plant + ".png",
                "/graph_humidity : " + Lang.get("back_hum_graph")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void getTemperatureGraph(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        Graphics.temperature("bamboo");
        
        try {
            TelegramListener.client.sendFile(
                "graph/temp/" + plant + ".png",
                "/graph_temperature : " + Lang.get("back_temp_graph")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void getLuminosityGraph(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        Graphics.luminosity("bamboo");
        
        try {
            TelegramListener.client.sendFile(
                "graph/lum/" + plant + ".png",
                "/graph_luminosity : " + Lang.get("back_lum_graph")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
 
    public static void getPrediction(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        Prevision p = new Prevision(plant);
        
        try {
            TelegramListener.client.sendMessage(
                plant + " prediction",
                Lang.get("humidity") + " : " + Prevision.previsionHum(86400.0) + "%\n" +
                Lang.get("temperature") + " : " + Prevision.previsionTemp(86400.0) + "°C\n" +
                Lang.get("luminosity") + " : " + Prevision.previsionLum(86400.0) + "lum\n" +
                "\n /prediction : " + Lang.get("back_prediction")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   /*
     * @pre -
     * @post send user the database file (file.txt)
     */
    public static void saveFile(String file){
        try {
            TelegramListener.client.sendFile(
                "sample/" + file + ".txt",
                "/save : " + Lang.get("back_save")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
