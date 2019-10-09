import data.Sensor;
import monitorable.*;

public class PlantListener {
    public static Bamboo bamboo = null;
    public static Cactus cactus = null;
    public static Orchidea orchidea = null;
    public static Rose rose = null;
    
    public static boolean bambooIsActive = false;
    public static boolean cactusIsActive = false;
    public static boolean orchideaIsActive = false;
    public static boolean roseIsActive = false;
    
    public static PlantSample bambooLastSample = null;
    public static PlantSample cactusLastSample = null;
    public static PlantSample orchideaLastSample = null;
    public static PlantSample roseLastSample = null;
    
    /*
     * @pre -
     * @post add listener to plants
     */
    public static void listen() {
        bamboo.addListener(new PlantSampleListener() {
            @Override
            public void sampleTaken(PlantSample sample) {
                if (bambooIsActive) {
                    bambooLastSample = sample;
                    Irrigation.irrigate("bamboo");
                    Alert.check("bamboo", bambooLastSample);
                    Database.save("bamboo", bambooLastSample);
                }
            }
        });
        
        cactus.addListener(new PlantSampleListener() {
            @Override
            public void sampleTaken(PlantSample sample) {
                if (cactusIsActive) {
                    cactusLastSample = sample;
                    Irrigation.irrigate("cactus");
                    Alert.check("cactus", cactusLastSample);
                    Database.save("cactus", cactusLastSample);
                }
            }
        });
        
        orchidea.addListener(new PlantSampleListener() {
            @Override
            public void sampleTaken(PlantSample sample) {
                if (orchideaIsActive) {
                    orchideaLastSample = sample;
                    Irrigation.irrigate("orchidea");
                    Alert.check("orchidea", orchideaLastSample);
                    Database.save("orchidea", orchideaLastSample);
                }
            }
        });
        
        rose.addListener(new PlantSampleListener() {
            @Override
            public void sampleTaken(PlantSample sample) {
                if (roseIsActive) {
                    roseLastSample = sample;
                    Irrigation.irrigate("rose");
                    Alert.check("rose", roseLastSample);
                    Database.save("rose", roseLastSample);
                }
            }
        });
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post return true if plant is active, false if plant is not active
     */
    public static boolean isActive(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        if (plant.equals("bamboo")) {
            return bambooIsActive;
        }
        
        if (plant.equals("cactus")) {
            return cactusIsActive;
        }
        
        if (plant.equals("orchidea")) {
            return orchideaIsActive;
        }
        
        if (plant.equals("rose")) {
            return roseIsActive;
        }
        
        return false;
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post activate a plant
     */
    public static void add(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        if (plant.equals("bamboo")) {
            bambooIsActive = true;
        }
        
        if (plant.equals("cactus")) {
            cactusIsActive = true;
        }
        
        if (plant.equals("orchidea")) {
            orchideaIsActive = true;
        }
        
        if (plant.equals("rose")) {
            roseIsActive = true;
        }
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post desactivate a plant
     */
    public static void remove(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        if (plant.equals("bamboo")) {
            bambooIsActive = false;
            Database.clear("bamboo");
        }
        
        if (plant.equals("cactus")) {
            cactusIsActive = false;
            Database.clear("cactus");
        }
        
        if (plant.equals("orchidea")) {
            orchideaIsActive = false;
            Database.clear("orchidea");
        }
        
        if (plant.equals("rose")) {
            roseIsActive = false;
            Database.clear("rose");
        }
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post return the plant's humidity lower bound
     */
    public static float getLowerBound(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        if (plant.equals("bamboo")) {
            return bamboo.getLowerBound();
        }
        
        if (plant.equals("cactus")) {
            return cactus.getLowerBound();
        }
        
        if (plant.equals("orchidea")) {
            return orchidea.getLowerBound();
        }
        
        return rose.getLowerBound();
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post return the plant's humidity higher bound
     */
    public static float getHigherBound(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        if (plant.equals("bamboo")) {
            return bamboo.getHigherBound();
        }
        
        if (plant.equals("cactus")) {
            return cactus.getHigherBound();
        }
        
        if (plant.equals("orchidea")) {
            return orchidea.getHigherBound();
        }
        
        return rose.getHigherBound();
    }
    
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post return the plant's temperature
     */
    public static float getHumidity(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        if (plant.equals("bamboo")) {
            return bambooLastSample.getHumidity();
        }
        
        if (plant.equals("cactus")) {
            return cactusLastSample.getHumidity();
        }
        
        if (plant.equals("orchidea")) {
            return orchideaLastSample.getHumidity();
        }
        
        return roseLastSample.getHumidity();
    }
}
